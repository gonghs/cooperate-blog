package com.server.kt.common.handler

import com.server.kt.common.entity.ResultObj
import com.server.kt.common.entity.ValidErrorEntity
import com.server.kt.common.enumerate.ErrorCode
import org.slf4j.LoggerFactory
import org.springframework.validation.BindException
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
        //对数据校验相关的做特殊处理
        if (e is BindException) {
            val msg = e.fieldError?.defaultMessage ?: ""
            //将校验失败字段放入返回数据中 失败信息为最后一个失败字段的信息
            ResultObj(
                e.fieldErrors.map { ValidErrorEntity(it.field, it.defaultMessage) },
                ErrorCode.VALID_ERROR_CODE,
                msg
            )
        }
        return ResultObj.failure(e)
    }
}