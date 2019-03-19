<template>
  <div>
    <el-container class="page">
      <el-header class="head">
        <span style="min-width: 300px">后台管理系统</span>
      </el-header>
      <el-main class="main">
        <div class="login-form">
          <div class="form-head"><span>用户登陆</span></div>
          <el-form ref="form" :model="form" :rules="rules" label-width="75px" style="padding-right: 10px">
            <el-form-item label="账号:" prop="account" required>
              <el-input v-model="form.account" placeholder="账号"></el-input>
            </el-form-item>
            <el-form-item label="密码:" prop="password" required>
              <el-input  type="password" v-model="form.password" placeholder="密码"></el-input>
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
        rememberPwd: false
      },
      rules: {
        account: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    login: function () {
      let _this = this
      this.$refs['form'].validate((valid) => {
        if (valid) {
          $http.post('login', {..._this.form}).then(resp => {
            localStorage.setItem('token', resp.data)
            _this.$message({
              message: resp.msg,
              type: 'success'
            })
            _this.$router.push('index')
          })
        } else {
          return false
        }
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
