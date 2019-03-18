package com.server.kt.controller;

import com.server.kt.common.exception.UnLoginException
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
    fun unLogin(){
        throw UnLoginException()
    }
}
