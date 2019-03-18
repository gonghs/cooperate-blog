<template>
  <div>
    <el-container class="page">
      <div class="bg"></div>
      <el-header class="head">
        <fullscreen></fullscreen>
        <span style="min-width: 300px">后台管理系统</span>
      </el-header>
      <el-main class="main">
        <div class="login-form">
          <div class="form-head"><span>用户登陆</span></div>
          <el-form ref="form" :model="form" label-width="75px" style="padding-right: 10px">
            <el-form-item label="账号:">
              <el-input v-model="form.account" placeholder="账号"></el-input>
            </el-form-item>
            <el-form-item label="密码:">
              <el-input v-model="form.password" placeholder="密码"></el-input>
            </el-form-item>
            <el-form-item label="记住密码:">
              <el-switch v-model="form.rememberPwd"></el-switch>
            </el-form-item>
          </el-form>
          <div style="display: flex;justify-content: center">
            <el-button type="primary">注册</el-button>
            <el-button type="primary" @click="login">登陆</el-button>
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import $http from './assets/js/axios/api'

export default {
  name: 'Login',
  data () {
    return {
      form: {
        account: '',
        password: '',
        rememberPwd: ''
      }
    }
  },
  methods: {
    login: function () {
      let _this = this
      $http.get('getUserById', {params: {id: 'aa'}}).then(resp => {
        _this.$message(
          {
            message: `成功了 ${resp}`,
            type: 'success'
          })
      })
    }
  }
}
</script>

<style>

  .head {
    text-align: center;
    color: #409EFF;
    font-size: 50px;
    z-index: 1;
    margin-top: 20px;
  }

  .login-form {
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    padding: 20px 20px 20px 15px;
    border: 1px #67C23A solid;
    filter: alpha(opacity=100);
    -moz-opacity: 1;
    opacity: 1;
    border-radius: 5px;
    box-sizing: border-box;
    max-width: 450px;
    max-height: 350px;
    margin: 100px auto;
  }

  .main {
    padding: 0;
    margin: 0;
  }

  .page {
    height: 100%;
  }

  .form-head {
    text-align: center;
    line-height: 40px;
    margin-bottom: 20px;
    font-size: 20px;
    color: #409EFF;
  }
</style>
