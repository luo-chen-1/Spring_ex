import { req } from './axiosFun';

/**
 * 图书申请配置信息
 **/
export const recordList = (params) => {return req("post","/api/admin/getApplyRecord",params)};
export const returnBook = (params) => {return req("post","/api/admin/addBookNum",params)};
/**
 * 图表配置信息
 **/
 export const getChartsInfo = (params) => {return req("post","/api/admin/getChartsInfo",params)};
 export const completedApply = (params) => {return req("post","/api/admin/completedApply",params)};