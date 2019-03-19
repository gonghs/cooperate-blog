/**
 * 引入axios并添加拦截器
 * @author maple
 * @date 2019-3-12
 */
import axios from 'axios'
import router from '../../../router'
import { Message } from 'element-ui'
const $http = axios.create({
  baseURL: 'http://localhost:9002/',
  timeout: 500000
})

// get请求默认采用表单提交,post请求默认采用json提交
$http.interceptors.request.use(cfg => {
  if (cfg.method === 'post') {
    cfg.headers['Content-Type'] = 'application/json'
  } else {
    cfg.params = {...cfg.params}
    cfg.headers['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8'
  }
  if (localStorage.getItem('token')) {
    cfg.headers['token'] = localStorage.getItem('token')
  } else {
    cfg.headers['token'] = '1'
  }
  return cfg
}, error => {
  Message.error(`啊偶..请求失败了.. 错误信息: ${error}`)
  return Promise.reject(error)
})

// 响应贴合后台封装进行处理
$http.interceptors.response.use(resp => {
  if (resp.data.success) {
    return resp.data
  } else {
    // 如果该异常为未登录则路由跳转至登陆页面
    if (resp.data.errorCode === '000') {
      router.go('/login')
    }
    Message.error(resp.data.msg)
    return Promise.reject(resp.data)
  }
}, error => {
  Message.error(`啊偶..请求失败了.. 错误信息: ${error}`)
  return Promise.reject(error)
})
export default $http
