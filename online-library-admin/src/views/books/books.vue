/**
 * 基础菜单 图书管理
 */
<template>
  <div>
    <!-- 面包屑导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>图书管理</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 搜索筛选 -->
    <el-form :inline="true" :model="formInline" class="user-search">
      <el-form-item label="搜索：">
        <el-input
          size="small"
          v-model="formInline.bookName"
          placeholder="输入图书名称"
        ></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input
          size="small"
          v-model="formInline.author"
          placeholder="输入图书作者"
        ></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-select v-model="formInline.majorCate" placeholder="请选择分类">
          <el-option v-for="item in majorCate" :key="item" :value="item">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button
          size="small"
          type="primary"
          icon="el-icon-search"
          @click="search"
          >搜索</el-button
        >
        <el-button
          size="small"
          type="primary"
          icon="el-icon-plus"
          @click="handleEdit()"
          >添加</el-button
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
      <el-table-column align="center" type="selection" width="60">
      </el-table-column>
      <el-table-column sortable prop="cover" label="图书封面" width="130">
        <template slot-scope="scope">
          <div class="consumer-img">
            <img
              :src="getUrl(scope.row.cover)"
              @click="openUpCover(scope.row)"
              style="width: 100%"
            />
          </div>
        </template>
      </el-table-column>
      <el-table-column sortable prop="bookName" label="图书名称" width="200">
      </el-table-column>
      <el-table-column sortable prop="author" label="图书作者" width="150">
      </el-table-column>
      <el-table-column sortable prop="press" label="出版社" width="150">
      </el-table-column>
      <el-table-column sortable prop="majorCate" label="图书分类" width="100">
        <!-- <template slot-scope="scope">
          <div>{{scope.row.editTime|timestampToTime}}</div>
        </template> -->
      </el-table-column>
      <el-table-column sortable prop="intro" label="图书简介" width="580">
      </el-table-column>
      <el-table-column sortable prop="num" label="图书库存" width="100">
      </el-table-column>
      <el-table-column align="center" label="操作" min-width="100">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="deleteOption(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <Pagination
      v-bind:child-msg="pageparm"
      @callFather="callFather"
    ></Pagination>
    <!-- 编辑界面 -->
    <el-dialog
      :title="title"
      :visible.sync="editFormVisible"
      width="30%"
      @click="closeDialog"
    >
      <el-form
        label-width="120px"
        :model="editForm"
        :rules="rules"
        ref="editForm"
      >
        <el-form-item label="图书名称" prop="bookName">
          <el-input
            size="small"
            v-model="editForm.bookName"
            auto-complete="off"
            placeholder="请输入图书名称"
          ></el-input>
        </el-form-item>
        <el-form-item label="图书作者" prop="author">
          <el-input
            size="small"
            v-model="editForm.author"
            auto-complete="off"
            placeholder="请输入图书作者"
          ></el-input>
        </el-form-item>
        <el-form-item label="出版社" prop="press">
          <el-input
            size="small"
            v-model="editForm.press"
            auto-complete="off"
            placeholder="请输入出版社"
          ></el-input>
        </el-form-item>
        <el-form-item label="图书分类" prop="majorCate">
          <el-input
            size="small"
            v-model="editForm.majorCate"
            auto-complete="off"
            placeholder="请输入图书分类"
          ></el-input>
        </el-form-item>
        <el-form-item label="图书简介" prop="intro">
          <el-input
            size="small"
            v-model="editForm.intro"
            auto-complete="off"
            placeholder="请输入图书简介"
          ></el-input>
        </el-form-item>
        <el-form-item label="图书库存" prop="num">
          <el-input
            size="small"
            v-model="editForm.num"
            auto-complete="off"
            placeholder="请输入图书库存"
          ></el-input>
        </el-form-item>
        <!-- <el-form-item label="图书封面">
          <el-upload class="upload-demo" drag :action="uploadCover()" :limit="1" :headers="headerObj" :before-upload="beforeAvatorUpload" :on-success="handleAvatorSuccess"
          >
            <i class="el-icon-upload" ></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过10MB</div>
      </el-upload>
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="small" @click="closeDialog">取消</el-button>
        <el-button
          size="small"
          type="primary"
          :loading="loading"
          class="title"
          @click="submitForm('editForm')"
          >保存</el-button
        >
      </div>
    </el-dialog>
    <el-dialog title="更新图书封面" :visible.sync="dialogUpCover" width="30%">
      <el-upload
        class="upload-demo"
        drag
        :action="uploadCover()"
        :limit="1"
        :headers="headerObj"
        :before-upload="beforeAvatorUpload"
        :on-success="handleAvatorSuccess"
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip" slot="tip">
          只能上传jpg/png文件，且不超过10MB
        </div>
      </el-upload>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogUpCover = false">取 消</el-button>
        <el-button type="primary" @click="dialogUpCover = false"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {
  bookList,
  updateBook,
  deleteBook,
  insertBook,
  getMajorCate,
} from "../../api/userMG";
import Pagination from "../../components/Pagination";
export default {
  data() {
    var validateCheckPass = (rule,value,callback)=>{
                let reg = /^[0-9]$/
				        if (value === '') {
				            callback(new Error('请输入图书库存'));
				        } else if (value <0) {
				            callback(new Error('图书库存应大于等于0!'));
				        } else if(reg.test(value)){
				            callback();
				        }else{
                    callback("库存必须为数字")
                }
				};
    return {
      nshow: true, //switch开启
      fshow: false, //switch关闭
      loading: false, //是显示加载
      editFormVisible: false, //控制编辑页面显示与隐藏
      title: "添加",
      dialogUpCover: false,
      editForm: {
        id: "",
        bookName: "",
        author: "",
        press: "",
        majorCate: "",
        intro: "",
        num: "",
        token: localStorage.getItem("logintoken"),
      },
      headerObj: {
        token: localStorage.getItem("logintoken"),
      },
      majorCate: [],
      // rules表单验证
      rules: {
        bookName: [
          { required: true, message: "请输入图书名称", trigger: "blur" },
        ],
        author: [
          { required: true, message: "请输入图书代码", trigger: "blur" },
        ],
        press: [{ required: true, message: "请输入出版社", trigger: "blur" }],
        majorCate: [
          { required: true, message: "请输入图书分类", trigger: "blur" },
        ],
        intro: [{ required: true, message: "请输入图书简介", trigger: "blur" }],
        num: [{validator: validateCheckPass, required: true, trigger: "blur" }],
      },
      formInline: {
        page: 1,
        limit: 3,
        bookName: "",
        author: "",
        majorCate: "",
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
        pageSize: 3,
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
    this.getDataMajorCate();
  },

  /**
   * 里面的方法只有被调用才会执行
   */
  methods: {
    // 获取图书列表
    getdata(parameter) {
      this.loading = true;

      /***
       * 调用接口，注释上面模拟数据 取消下面注释
       */
      bookList(parameter)
        .then((res) => {
          this.loading = false;
          if (res.success == false) {
            setTimeout(() => {
              this.$message.error(res.message);
              this.$store.commit("logout", "false");
              this.$router.push({ path: "/login" });
            }, 1000);
          } else {
            //this.$message.success(res.message)
            this.listData = res.data.bookList;
            // 分页赋值
            this.pageparm.currentPage = this.formInline.page;
            this.pageparm.pageSize = this.formInline.limit;
            this.pageparm.total = res.data.total;
          }
        })
        .catch((err) => {
          this.loading = false;
          this.$message.error("图书加载失败，请稍后再试！");
        });
    },
    getDataMajorCate() {
      getMajorCate().then((res) => {
        if (res.success == false) {
        } else {
          this.majorCate = res.data.majorCate;
        }
      });
    },
    openUpCover(row) {
      this.dialogUpCover = true;
      this.editForm.id = row.id;
    },
    getUrl(url) {
      return `http://127.0.0.1:8081${url}`;
    },
    uploadCover() {
      return `http://127.0.0.1:8081/api/admin/updateCover?id=${this.editForm.id}`;
    },
    //上传图片之前的校验
    beforeAvatorUpload(file) {
      const isJPG = file.type === "image/jpeg" || file.type === "image/png";
      if (!isJPG) {
        this.$message.error("上传图书封面只能是jpg或png格式");
        return false;
      }
      const isLt2M = file.size / 1024 / 1024 < 10;
      if (!isLt2M) {
        this.$message.error("上传图书封面大小不能超过10MB");
        return false;
      }
      return true;
    },
    handleAvatorSuccess(res) {
      if (res.code == 20000) {
        this.getdata(this.formInline);
        this.$notify({
          title: "上传成功",
          type: "success",
        });
      } else {
        this.$notify({
          title: "上传失败",
          type: "error",
        });
      }
      this.dialogUpCover = false;
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
    //显示编辑界面
    handleEdit: function (index, row) {
      this.editFormVisible = true;
      if (row != undefined && row != "undefined") {
        this.title = "修改图书信息";
        this.editForm.id = row.id;
        this.editForm.bookName = row.bookName;
        this.editForm.author = row.author;
        this.editForm.press = row.press;
        this.editForm.majorCate = row.majorCate;
        this.editForm.intro = row.intro;
        this.editForm.num = row.num;
      } else {
        this.title = "添加图书信息";
        this.editForm.bookName = "";
        this.editForm.author = "";
        this.editForm.press = "";
        this.editForm.majorCate = "";
        this.editForm.intro = "";
        this.editForm.num = "";
      }
    },
    // 编辑、增加页面保存方法
    submitForm(editData) {
      this.$refs[editData].validate((valid) => {
        if (valid) {
          if (this.title == "修改图书信息") {
            updateBook(this.editForm)
              .then((res) => {
                this.editFormVisible = false;
                this.loading = false;
                if (res.code == 20000) {
                  this.getdata(this.formInline);
                  this.$message.success(res.message);
                } else {
                  this.$message.error(res.message);
                  if (res.success == false) {
                    setTimeout(() => {
                      //this.$message.error(res.message)
                      this.$store.commit("logout", "false");
                      this.$router.push({ path: "/login" });
                    }, 1000);
                  }
                }
              })
              .catch((err) => {
                this.editFormVisible = false;
                this.loading = false;
                this.$message.error("图书更新失败，请稍后再试！");
              });
          } else {
            insertBook(this.editForm)
              .then((res) => {
                this.editFormVisible = false;
                this.loading = false;
                if (res.code == 20000) {
                  this.getdata(this.formInline);
                  this.$message.success(res.message);
                } else {
                  this.$message.error(res.message);
                  if (res.success == false) {
                    setTimeout(() => {
                      //this.$message.error(res.message)
                      this.$store.commit("logout", "false");
                      this.$router.push({ path: "/login" });
                    }, 1000);
                  }
                }
              })
              .catch((err) => {
                this.editFormVisible = false;
                this.loading = false;
                this.$message.error("图书插入失败，请稍后再试！");
              });
          }
        } else {
          this.$message.error("请填写完所有信息后再提交！");
          return false;
        }
      });
    },
    // 删除图书
    deleteOption(index, row) {
      this.$confirm("确定要删除吗?", "信息", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          deleteBook(row.id)
            .then((res) => {
              if (res.code == 20000) {
                this.$message.success(res.message);
                this.getdata(this.formInline);
              } else {
                this.$message.error(res.message);
                if (res.success == false) {
                  setTimeout(() => {
                    //this.$message.error(res.message)
                    this.$store.commit("logout", "false");
                    this.$router.push({ path: "/login" });
                  }, 1000);
                }
              }
            })
            .catch((err) => {
              this.loading = false;
              this.$message.error("图书删除失败，请稍后再试！");
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    // 关闭编辑、增加弹出框
    closeDialog() {
      this.editFormVisible = false;
    },
  },
};
</script>

<style scoped>
.consumer-img {
  width: 100%;
  /* height: 100%; */
  border-radius: 5px;
  margin-bottom: 5px;
  overflow: hidden;
}
.user-search {
  margin-top: 20px;
}
.userRole {
  width: 100%;
}
</style>

 
 