package com.server.kt.common.entity

import com.server.kt.common.enumerate.ErrorCode
import com.server.kt.common.enumerate.GlobalConst
import java.lang.Exception

/**
 * 控制台返回结果的包装对象
 *
 * @author maple
 * @version 1.0
 * @since 2019-02-24 18:20
 */
data class ResultObj<T>(val data: T?, val success: Boolean, val errorCode: String) {
    /**
     * 默认为成功
     */
    constructor(data: T?) : this(data, true, GlobalConst.SUCCESS)

    companion object {
        fun <T> failure(t: T, e: Exception): ResultObj<T> {
            return ResultObj(t, false, ErrorCode.getErrorCodeByExceptionClass(e).code)
        }

        fun <T> success(t: T): ResultObj<T> {
            return ResultObj(t, true, GlobalConst.SUCCESS)
        }

        fun failure(e: Exception): ResultObj<String> {
            val errorCode = ErrorCode.getErrorCodeByExceptionClass(e)
            return ResultObj(errorCode.msg, false, errorCode.code)
        }
    }
}