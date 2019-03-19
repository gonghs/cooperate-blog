package com.server.kt.controller;

import com.server.kt.common.entity.ResultObj
import com.server.kt.common.exception.UnLoginException
import com.server.kt.db.entity.UserInfo
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.LockedAccountException
import org.apache.shiro.authc.UsernamePasswordToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 权限相关控制器
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-18 15:17
 */
@RestController
class AuthController {

    @GetMapping("/unLogin")
    fun unLogin() {
        throw UnLoginException()
    }

    @GetMapping("/login")
    fun login(userInfo: UserInfo): ResultObj<String> {
        val subject = SecurityUtils.getSubject()
        val token = UsernamePasswordToken(userInfo.account, userInfo.password)
        subject.login(token)
        return ResultObj.success(subject.session.id.toString())
    }

    @GetMapping("/logout")
    fun logout(): ResultObj<String> {
        // 使用权限管理工具进行用户的退出，注销登录
        SecurityUtils.getSubject().logout()
        // 直接抛出未登陆异常,让前端跳转登陆页
        throw UnLoginException()
    }
}
