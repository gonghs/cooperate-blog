// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import router from './router'
import components from './components/componentServer'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/base.css'

Vue.config.productionTip = false

Vue.use(ElementUI)
Vue.use(components)

router.beforeEach((to, from, next) => {
  // 判断该路由是否需要登录权限
  const auth = to.meta.auth
  debugger
  if (auth) {
    if (window.localStorage.getItem('token')) {
      next()
    } else {
      next('/login')
    }
  } else {
    // 确保一定要有next()被调用
    next()
  }
})

new Vue({
  router
}).$mount('#app')
