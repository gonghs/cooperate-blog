package com.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

/**
 * 测试运行类
 *
 * @author maple
 * @version 1.0
 * @since 2019-02-27 01:31
 */

@SpringBootApplication
open class ServerRun

@RestController
class ControllerTest {
    @GetMapping("/")
    fun hello(): String {
        return "success"
    }
}

fun main(args: Array<String>) {
    runApplication<ServerRun>(*args)
}