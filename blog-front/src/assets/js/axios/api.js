/**
 * 引入axios并添加拦截器
 * @author maple
 * @date 2019-3-12
 */
import axios from 'axios'
import qs from 'qs'
import { Message } from 'element-ui'
const service = axios.create({
  baseURL: 'http://localhost:9002/',
  timeout: 5000
})

// get请求默认采用表单提交,post请求默认采用json提交
service.interceptors.request.use(cfg => {
  if (cfg.method === 'post') {
    cfg.data = qs.stringify({...cfg.data})
    cfg.headers['Content-Type'] = 'application/json'
  } else {
    cfg.params = {...cfg.params}
    cfg.headers['Content-Type'] = 'application/x-www-form-urlencoded'
  }
  return cfg
}, error => {
  Message.error(`啊偶..请求失败了.. 错误信息: ${error}`)
})

// 响应贴合后台封装进行处理
service.interceptors.response.use(resp => {
  if (resp.data.success) {
    return resp.data
  } else {
    Message.error(resp.data)
    throw new Error(resp.data)
  }
}, error => {
  Message.error(`啊偶..请求失败了.. 错误信息: ${error}`)
})
export default service
