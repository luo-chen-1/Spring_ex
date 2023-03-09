/**
 * 系统管理 用户管理
 */
<template>
  <div>
    <!-- 面包屑导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户管理</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 搜索筛选 -->
    <el-form :inline="true" :model="formInline" class="user-search">
      <el-form-item label="">
        <el-input
          size="small"
          v-model="formInline.userName"
          placeholder="输入用户名"
        ></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input
          size="small"
          v-model="formInline.email"
          placeholder="输入邮箱"
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
      @selection-change="selectChange"
      :data="userData"
      highlight-current-row
      v-loading="loading"
      border
      element-loading-text="拼命加载中"
      style="width: 100%"
    >
      <el-table-column align="center" type="selection" width="50">
      </el-table-column>
      <el-table-column align="center" sortable prop="id" label="id" width="120">
      </el-table-column>
      <el-table-column
        align="center"
        sortable
        prop="userName"
        label="用户名"
        width="120"
      >
      </el-table-column>
      <el-table-column
        align="center"
        sortable
        prop="email"
        label="邮箱"
        width="200zzzzzzzzzzz"
      >
      </el-table-column>
      <el-table-column label="操作" min-width="300">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="deleteUser(scope.$index, scope.row)"
            >删除</el-button
          >
          <el-button
            size="mini"
            type="success"
            @click="resetpwd(scope.$index, scope.row)"
            >重置密码</el-button
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
      @click="closeDialog('edit')"
    >
      <el-form
        label-width="100px"
        ref="editForm"
        :model="editForm"
        :rules="rules"
      >
        <el-form-item label="用户名" prop="userName">
          <el-input
            size="small"
            v-model="editForm.userName"
            auto-complete="off"
            placeholder="请输入用户名"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码(非必填)" prop="password">
          <el-input
            size="small"
            v-model="editForm.password"
            auto-complete="off"
            placeholder="请输入密码"
          ></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input
            size="small"
            v-model="editForm.email"
            placeholder="请输入邮箱地址"
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="small" @click="closeDialog('edit')">取消</el-button>
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
    <el-dialog
      :title="title"
      :visible.sync="addFormVisible"
      width="30%"
      @click="closeDialog('edit')"
    >
      <el-form
        label-width="100px"
        ref="editForm"
        :model="editForm"
        :rules="rules"
      >
        <el-form-item label="用户名" prop="userName">
          <el-input
            size="small"
            v-model="editForm.userName"
            auto-complete="off"
            placeholder="请输入用户名"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            size="small"
            v-model="editForm.password"
            auto-complete="off"
            placeholder="请输入密码"
          ></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input
            size="small"
            v-model="editForm.email"
            placeholder="请输入邮箱地址"
          ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="small" @click="closeDialog('edit')">取消</el-button>
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
  </div>
</template>

<script>
// 导入请求方法
import {
  userList,
  editUser,
  addUser,
  userDelete,
  userpwd,
} from "../../api/userMG";
import Pagination from "../../components/Pagination";
export default {
  data() {
    return {
      nshow: true, //switch开启
      fshow: false, //switch关闭
      loading: false, //是显示加载
      title: "添加用户",
      editFormVisible: false, //控制编辑页面显示与隐藏
      addFormVisible: false,
      // 编辑与添加
      editForm: {
        id: "",
        userName: "",
        password: "",
        email: "",
        token: localStorage.getItem("logintoken"),
      },
      // 部门参数
      unitparm: {
        userIds: "",
        deptId: "",
        deptName: "",
      },
      // 选择数据
      selectdata: [],
      // rules表单验证
      rules: {
        userName: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        email: [
          { required: true, message: "请输入邮箱", trigger: "blur" },
          {
            pattern:
              /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,
            required: true,
            message: "请输入正确的邮箱",
            trigger: "blur",
          },
        ],
      },
      // 重置密码
      resetpsd: {
        id: "",
      },
      deleteUserId: {
        id: "",
      },
      // 请求数据参数
      formInline: {
        page: 1,
        limit: 10,
        id: "",
        userName: "",
        email: "",
      },
      //用户数据
      userData: [],
      // 选中
      checkmenu: [],
      //参数role
      saveroleId: "",
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
  watch: {},

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
    // 获取数据方法
    getdata(parameter) {
      this.loading = true;
      // 模拟数据结束
      /***
       * 调用接口，注释上面模拟数据 取消下面注释
       */
      userList(parameter).then((res) => {
        this.loading = false;
        if (res.success == false) {
          this.$message.error(res.message);
          this.$store.commit("logout", "false");
          this.$router.push({ path: "/login" });
        } else {
          this.userData = res.data.userList;
          // 分页赋值
          this.pageparm.currentPage = this.formInline.page;
          this.pageparm.pageSize = this.formInline.limit;
          this.pageparm.total = res.data.total;
        }
      });
    },
    // 分页插件事件
    callFather(parm) {
      this.formInline.page = parm.currentPage;
      this.formInline.limit = parm.pageSize;
      this.getdata(this.formInline);
    },
    //搜索事件
    search() {
      this.getdata(this.formInline);
    },
    //显示编辑界面
    handleEdit: function (index, row) {
      if (row != undefined && row != "undefined") {
        this.editFormVisible = true;
        this.title = "修改用户";
        this.editForm.id = row.id;
        this.editForm.userName = row.userName;
        this.editForm.email = row.email;
      } else {
        this.addFormVisible = true;
        this.title = "添加用户";
        this.editForm.id = "";
        this.editForm.userName = "";
        this.editForm.password = "";
        this.editForm.email = "";
      }
    },
    // 编辑、添加提交方法
    submitForm(editData) {
      this.$refs[editData].validate((valid) => {
        if (valid) {
          if (this.title == "添加用户") {
            // 请求方法
            addUser(this.editForm)
              .then((res) => {
                this.addFormVisible = false;
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
                this.addFormVisible = false;
                this.loading = false;
                this.$message.error("添加用户失败，请稍后再试！");
              });
          } else {
            editUser(this.editForm)
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
                this.addFormVisible = false;
                this.loading = false;
                this.$message.error("修改用户失败，请稍后再试！");
              });
          }
        } else {
          return false;
        }
      });
    },
    // 选择复选框事件
    selectChange(val) {
      this.selectdata = val;
    },
    // 关闭编辑、增加弹出框
    closeDialog(dialog) {
      if (dialog == "edit") {
        this.addFormVisible = false;
        this.editFormVisible = false;
      } else if (dialog == "perm") {
        this.dataAccessshow = false;
      } else if (dialog == "unit") {
        this.unitAccessshow = false;
      }
    },
    // 删除用户
    deleteUser(index, row) {
      this.$confirm("确定要删除吗?", "信息", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          // 删除
          this.deleteUserId.id = row.id;
          userDelete(this.deleteUserId)
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
              this.$message.error("用户删除失败，请稍后再试！");
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除！",
          });
        });
    },
    // 重置密码
    resetpwd(index, row) {
      this.resetpsd.id = row.id;
      this.$confirm("确定要重置密码吗?", "信息", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          userpwd(this.resetpsd)
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
              this.$message.error("重置密码失败，请稍后再试！");
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消重置密码！",
          });
        });
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

 