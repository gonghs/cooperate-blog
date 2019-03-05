package com.server.kt.controller

import com.server.kt.common.entity.ResultObj
import com.server.kt.db.entity.UserInfo
import com.server.kt.db.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.inject.Inject

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
    fun getUsers(): ResultObj<List<UserInfo>> {
        return ResultObj(userRepository.findAll())
    }

    @GetMapping("getUserById")
    fun getUsers(id: Long): ResultObj<UserInfo> {
        return ResultObj(userRepository.findById(id).get())
    }
}