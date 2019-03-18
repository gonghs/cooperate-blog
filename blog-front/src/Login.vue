<template>
  <div>
    <el-container class="page">
      <div class="bg"></div>
      <el-header class="head">
        <el-row :gutter="20">
          <el-col :span="4">
            <fullscreen></fullscreen>
          </el-col>
          <el-col :span="8" :offset="4"><span>后台管理系统</span></el-col>
        </el-row>
      </el-header>
      <el-main class="main">
        <el-row :gutter="20">
          <el-col :span="8" :offset="8">
            <div class="login-form">
              <div class="form-head"><span>用户登陆</span></div>
              <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="账号:">
                  <el-input v-model="form.account" placeholder="账号"></el-input>
                </el-form-item>
                <el-form-item label="密码:">
                  <el-input v-model="form.password" placeholder="密码"></el-input>
                </el-form-item>
                <el-form-item label="记住密码:">
                  <el-switch v-model="form.rememberPwd"></el-switch>
                </el-form-item>
                <el-form-item style="text-align: center">
                  <el-button type="primary" style="margin-right: 100px">注册</el-button>
                  <el-button type="primary" @click="login">登陆</el-button>
                </el-form-item>
              </el-form>
            </div>
          </el-col>
        </el-row>
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
  #app {
    height: 100%;
    background-image: url('./assets/img/background1.jpg');
    background-size: 100% auto;
    background-repeat: no-repeat;
    opacity: 0.8;
  }

  .bg {
    background: rgba(0, 0, 0, .8);
    position: absolute;
    width: 100%;
    height: 100%;
  }

  .head {
    text-align: center;
    color: #409EFF;
    font-size: 50px;
    z-index: 1;
    margin-top: 20px;
  }

  .login-form {
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    padding: 20px 40px 20px 15px;
    border: 1px #67C23A solid;
    filter: alpha(opacity=100);
    -moz-opacity: 1;
    opacity: 1;
    border-radius: 5px;
  }

  .main {
    margin: 50px;
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
