package com.server.kt.controller

import com.server.kt.common.entity.ResultObj
import com.server.kt.db.entity.UserInfo
import com.server.kt.db.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.inject.Inject
import javax.servlet.http.HttpServletRequest

/**
 * 用户访问控制层
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-05 16:04
 */
@RestController
class UserController {
    @Inject
    lateinit var userRepository: UserRepository

    @GetMapping("getUsers")
    fun getUsers(httpServletRequest: HttpServletRequest): ResultObj<List<UserInfo>> {
        return ResultObj.success(userRepository.findAll())
    }

    @GetMapping("getUserById")
    fun getUsers(id: String): ResultObj<UserInfo> {
        return ResultObj.success(userRepository.findById(id).get())
    }
}