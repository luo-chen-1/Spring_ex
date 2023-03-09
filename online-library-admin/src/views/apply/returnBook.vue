/**
 * 申请管理 还书申请
 */
<template>
  <div>
    <!-- 面包屑导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>还书申请</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 搜索筛选 -->
    <el-form :inline="true" :model="formInline" class="user-search">
      <el-form-item label="搜索：">
        <el-input
          size="small"
          v-model="formInline.userName"
          placeholder="输入用户名"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-input
          size="small"
          v-model="formInline.bookName"
          placeholder="输入图书名"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button
          size="small"
          type="primary"
          icon="el-icon-search"
          @click="search"
          >搜索</el-button
        >
      </el-form-item>
    </el-form>
    <!--列表-->
    <el-table
      size="small"
      :data="listData"
      highlight-current-row
      v-loading="loading"
      border
      element-loading-text="拼命加载中"
      style="width: 100%"
    >
      <el-table-column align="center" type="index" width="60">
      </el-table-column>
      <el-table-column
        sortable
        prop="userName"
        label="用户名称"
        width="120"
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column
        sortable
        prop="bookName"
        label="图书名称"
        width="140"
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column
        sortable
        prop="borrowTime"
        label="借书时间"
        width="140"
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column
        sortable
        prop="bookState"
        label="图书状态"
        width="120"
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column
        sortable
        prop="overdue"
        label="是否逾期"
        width="120"
        show-overflow-tooltip
      >
        <template slot-scope="scope">
          <p v-if="scope.row.overdue">已逾期</p>
          <p v-else>未逾期</p>
        </template>
      </el-table-column>
      <el-table-column
        sortable
        prop="overdueTime"
        label="逾期时间"
        width="140"
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column
        sortable
        prop="fineNum"
        label="罚款金额"
        width="140"
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column
        sortable
        prop="applyTime"
        label="申请还书时间"
        width="140"
        show-overflow-tooltip
      >
      </el-table-column>
      <el-table-column align="center" label="操作" min-width="150">
        <template slot-scope="scope">
          <el-button size="mini" @click="pass(scope.row)">通过</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <Pagination
      v-bind:child-msg="pageparm"
      @callFather="callFather"
    ></Pagination>
  </div>
</template>

<script>
import { recordList, returnBook } from "../../api/applyMG";
import Pagination from "../../components/Pagination";
export default {
  data() {
    return {
      loading: false, //是显示加载
      editFormVisible: false, //控制编辑页面显示与隐藏
      formInline: {
        page: 1,
        limit: 10,
        userName: "",
        bookName: "",
        token: localStorage.getItem("logintoken"),
      },
      // 删除部门
      seletedata: {
        ids: "",
        token: localStorage.getItem("logintoken"),
      },
      userparm: [], //搜索权限
      listData: [], //用户数据
      // 分页参数
      pageparm: {
        currentPage: 1,
        pageSize: 10,
        total: 10,
      },
    };
  },
  // 注册组件
  components: {
    Pagination,
  },
  /**
   * 数据发生改变
   */

  /**
   * 创建完毕
   */
  created() {
    this.getdata(this.formInline);
  },

  /**
   * 里面的方法只有被调用才会执行
   */
  methods: {
    getdata(parameter) {
      this.loading = true;
      recordList(parameter)
        .then((res) => {
          this.loading = false;
          if (res.success == false) {
            setTimeout(() => {
              this.$message.error(res.message)
              this.$store.commit("logout", "false");
              this.$router.push({ path: "/login" });
            }, 1000);
          } else {
            //this.$message.success(res.message)
            this.listData = res.data.recordList;
            // 分页赋值
            this.pageparm.currentPage = this.formInline.page;
            this.pageparm.pageSize = this.formInline.limit;
            this.pageparm.total = res.data.total;
          }
        })
        .catch((err) => {
          this.loading = false;
          this.$message.error("数据加载失败，请稍后再试！");
        });
    },
    // 分页插件事件
    callFather(parm) {
      this.formInline.page = parm.currentPage;
      this.formInline.limit = parm.pageSize;
      this.getdata(this.formInline);
    },
    // 搜索事件
    search() {
      this.getdata(this.formInline);
    },
    pass(row) {
      if (row.overdue) {
        this.$confirm("该申请存在逾期请确定用户已缴纳罚金", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            returnBook(row)
              .then((res) => {
                if (res.success == false) {
                  setTimeout(() => {
                    this.$store.commit("logout", "false");
                    this.$router.push({ path: "/login" });
                  }, 1000);
                } else {
                  if (res.code == 20000) {
                    this.$message.success(res.message);
                    this.getdata(this.formInline);
                  } else {
                    this.$message.error(res.message);
                    this.getdata(this.formInline);
                  }
                }
              })
              .catch((err) => {
                this.$message.error("审批失败，请稍后再试！");
              });
          })
          .catch(() => {});
      } else {
        returnBook(row).then((res) => {
          this.loading = false;
          if (res.success == false) {
            setTimeout(() => {
              this.$store.commit("logout", "false");
              this.$router.push({ path: "/login" });
            }, 1000);
          } else {
            if (res.code == 20000) {
              this.$message.success(res.message);
              this.getdata(this.formInline);
            } else {
              this.$message.error(res.message);
              this.getdata(this.formInline);
            }
          }
        });
      }
    },
  },
};
</script>

<style scoped>
.user-search {
  margin-top: 20px;
}
.userRole {
  width: 100%;
}
</style>

 
 

 