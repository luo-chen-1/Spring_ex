/**
* 图表界面
*/ 
<template>
  <!-- 组件主盒子 -->
  <div class="stbox">
    <!-- 面包屑导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>数据可视化</el-breadcrumb-item>
    </el-breadcrumb>
    <el-row :gutter="20">
      <el-col :span="6" v-for="item in cards" :key="item.title">
        <el-card class="box-card">
          <div slot="header" class="clearfix">{{ item.title }}</div>
          <div class="text item">
            <svg class="icon" aria-hidden="true">
              <use :xlink:href="item.icon" style="width: 100px"></use>
            </svg>
            <span class="text">{{ item.data }}</span>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <div id="myTimer"></div>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main"></div>
  </div>
</template>
<script type="text/ecmascript-6">
import { getChartsInfo } from "../../api/applyMG";
import * as echarts from "echarts";
export default {
  name: "welcome",
  data() {
    return {
      cards: [
        { title: "已借阅", data: 100, icon: "#iconlend-record-pro" },
        { title: "总访问", data: 100, icon: "#iconvisit" },
        { title: "图书数", data: 100, icon: "#iconbook-pro" },
        { title: "读者数", data: 1000, icon: "#iconpopulation" },
      ],
    };
  },
  // 导入组件
  components: {
    // 点聚合组件
  },
  // 创建完毕状态(里面是操作)
  created() {},
  // 挂载结束状态(里面是操作)
  mounted() {
    this.circleTimer();
    getChartsInfo().then((res) => {
      if (res.success == false) {
        setTimeout(() => {
          this.$message.error(res.message)
          this.$store.commit("logout", "false");
          this.$router.push({ path: "/login" });
        }, 1000);
      } else {
        this.cards[0].data = res.data.recordNum;
        this.cards[1].data = res.data.visitsNum;
        this.cards[2].data = res.data.bookNum;
        this.cards[3].data = res.data.userNum;
        var myChart = echarts.init(document.getElementById("main"));
        // 绘制图表
        myChart.setOption({
          title: {
            text: "统计",
          },
          tooltip: {
            trigger: "axis",
            // axisPointer: {
            //   type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            // }
          },
          grid: {
            left: "3%",
            right: "4%",
            bottom: "3%",
            containLabel: true,
          },
          xAxis: {
            type: "category",
            data: this.cards.map((item) => item.title),
            axisTick: {
              alignWithLabel: true,
            },
          },
          yAxis: {
            type: "value",
          },
          series: [
            {
              type: "bar",
              label: { show: true },
              barWidth: "25%",
              data: [
                {
                  value: this.cards[0].data,
                  itemStyle: { color: "#5470c6" },
                },
                {
                  value: this.cards[1].data,
                  itemStyle: { color: "#91cc75" },
                },
                {
                  value: this.cards[2].data,
                  itemStyle: { color: "#fac858" },
                },
                {
                  value: this.cards[3].data,
                  itemStyle: { color: "#ee6666" },
                },
              ],
            },
          ],
        });
        window.addEventListener("resize", () => {
          myChart.resize();
        });
      }
    });
  },
  // 里面的函数只有调用才会执行
  methods: {
    circleTimer() {
      this.getTimer();
      setInterval(() => {
        this.getTimer();
      }, 1000);
    },
    getTimer() {
      var d = new Date();
      var t = d.toLocaleString();
      if(document.getElementById("myTimer")!=null){
        document.getElementById("myTimer").innerHTML = t;
      }
    },
  },
};
</script>
<style>
.box-card {
  /* width: 30%; */
  margin-bottom: 25px;
}

.clearfix {
  text-align: center;
  font-size: 15px;
}

.text {
  text-align: center;
  font-size: 24px;
  font-weight: 700;
  vertical-align: super;
}

#main {
  width: 100%;
  height: 450px;
  margin-top: 20px;
}

.icon {
  width: 50px;
  height: 50px;
  padding-top: 5px;
  padding-right: 10px;
}
</style>