import Vue from 'vue'
import Router from 'vue-router'
import Login from '../Login'
import Index from '../Index'
// import child from 'children/index.js'
import Background from '../components/bg/Background.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index,
      meta: {
        auth: true
      }
    },
    {
      path: '/background',
      name: 'Background',
      component: Background,
      meta: {
        auth: true
      }
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
