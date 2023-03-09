// 导入组件
import Vue from 'vue';
import Router from 'vue-router';
// 登录
import login from '@/views/login';
// 首页
import index from '@/views/index';
/**
 * 基础菜单
 */
// 图书管理
import books from '@/views/books/books';

/**
 * 申请管理
 */

import Order from '@/views/apply/returnBook';
import CApply  from '@/views/apply/completedApply';

/**
 * 系统管理
 */
// 用户管理
import user from '@/views/system/user';
/**
 * 数据监控
 */
// 监控查询
import druidLogin from '@/views/druid/login';

// 图表界面
import statistics from '@/views/charts/statistics';

// 启用路由
Vue.use(Router);

// 导出路由 
export default new Router({
    routes: [{
        path: '/',
        name: '',
        component: login,
        hidden: true,
        meta: {
            requireAuth: false
        }
    }, {
        path: '/login',
        name: '登录',
        component: login,
        hidden: true,
        meta: {
            requireAuth: false
        }
    }, {
        path: '/index',
        name: '首页',
        component: index,
        iconCls: 'el-icon-tickets',
        children: [{
            path: '/books/books',
            name: '图书管理',
            component: books,
            meta: {
                requireAuth: true
            }
        }, {
            path: '/apply/returnBook',
            name: '还书申请',
            component: Order,
            meta: {
                requireAuth: true
            }
        }, {
            path: '/apply/completedApply',
            name: '已办结申请',
            component: CApply,
            meta: {
                requireAuth: true
            }
        },{
            path: '/system/user',
            name: '用户管理',
            component: user,
            meta: {
                requireAuth: true
            }
        },{
            path: '/druid/login',
            name: '监控查询',
            component: druidLogin,
            meta: {
                requireAuth: true
            }
        }, {
            path: '/charts/statistics',
            name: '数据可视化',
            component: statistics,
            meta: {
                requireAuth: true
            }
        }]
    }]
})