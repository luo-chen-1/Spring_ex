import axios from 'axios';
import { loginreq, req } from './axiosFun';

// 登录接口 
export const login = (params) => { return loginreq("post", "/api/admin/login", params) };
// 退出接口
export const loginout = () => { return axios.delete("/api/login?&token=" + localStorage.getItem('logintoken')).then(res => res.data) };

/**
 * 用户管理 
 **/
// 用户管理-获取用户列表
export const userList = (params) => { return req("post", "/api/admin/getUserList", params) };
// 用户管理-保存（添加编辑）
export const editUser = (params) => { return req("post", "/api/admin/editUserInfo", params) };
export const addUser = (params) => { return req("post", "/api/admin/addUser", params) };
// 用户管理-删除用户
export const userDelete = (params) => { return req("post","/api/admin/deleteUser",params) };
// 用户管理-重置密码
export const userpwd = (params) => { return req("post", "/api/admin/resetUserPassword", params) };


/**
 * 图书管理 
 **/
// 图书管理-获取图书列表
export const bookList = (params) => { return req("post", "/api/admin/getBookListByQuery", params) };
// 图书管理-更新图书
export const updateBook = (params) => { return req("post", "/api/admin/updateBook", params) };
//图书管理- 插入图书 
export const insertBook = (params) => { return req("post", "/api/admin/addBook", params) };
// 公司管理-删除公司
export const deleteBook = (params) => { return axios.get("/api/admin/deleteBook?id=" + params + "&token=" + localStorage.getItem('logintoken')).then(res => res.data) };
export const getMajorCate = ()=> {return req("post", "/api/admin/getMajorCate")};
