package com.server.kt.controller;

import com.server.kt.common.entity.ResultObj
import com.server.kt.common.enumerate.GlobalConst
import com.server.kt.common.exception.UnLoginException
import com.server.kt.common.utils.MdUtils
import com.server.kt.common.utils.RedisUtils
import com.server.kt.db.entity.UserInfo
import com.server.kt.db.repository.UserRepository
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.LockedAccountException
import org.apache.shiro.authc.UsernamePasswordToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.inject.Inject
import javax.servlet.http.HttpServletRequest

/**
 * 权限相关控制器
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-18 15:17
 */
@RestController
class AuthController {
    @Inject
    lateinit var userRepository: UserRepository
    @Inject
    private lateinit var redisUtils: RedisUtils

    @GetMapping("/unLogin")
    fun unLogin() {
        throw UnLoginException()
    }

    @PostMapping("/login")
    fun login(@RequestBody userInfo: UserInfo): ResultObj<String> {
        val subject = SecurityUtils.getSubject()
        val token = UsernamePasswordToken(userInfo.account, MdUtils.md5(userInfo.password!!, 2))
        subject.login(token)
        val user = userRepository.findByAccount(userInfo.account!!)
        //存入redis缓存
        redisUtils.setAny(GlobalConst.SESSION_USER_KEY, user!!)
        return ResultObj.success(subject.session.id.toString())
    }

    @GetMapping("/logout")
    fun logout(): ResultObj<String> {
        // 使用权限管理工具进行用户的退出，注销登录
        SecurityUtils.getSubject().logout()
        redisUtils.delete(GlobalConst.SESSION_USER_KEY)
        // 直接抛出未登陆异常,让前端跳转登陆页
        throw UnLoginException()
    }
}
