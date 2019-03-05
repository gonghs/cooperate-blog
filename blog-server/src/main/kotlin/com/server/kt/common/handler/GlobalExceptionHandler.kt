package com.server.kt.common.handler

import com.server.kt.common.entity.ResultObj
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

/**
 * 全局异常处理拦截器
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-05 16:16
 */
@ControllerAdvice
class GlobalExceptionHandler {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @ResponseBody
    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResultObj<String> {
        log.error(e.message)
        return ResultObj.failure(e)
    }
}