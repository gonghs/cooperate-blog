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
class ResultObj<T> private constructor(val data: T?, val success: Boolean, val errorCode: String, val msg: String) {
    /**
     * 默认为成功
     */
    private constructor(data: T?) : this(data, true, GlobalConst.SUCCESS, GlobalConst.DEFAULT_SUCCESS_MSG)

    private constructor(data: T?, errorCode: String, msg: String) : this(data, false, errorCode, msg)

    companion object {
        fun <T> failure(t: T, e: Exception): ResultObj<T> {
            val errorCode = ErrorCode.getErrorCodeByExceptionClass(e)
            return ResultObj(t, errorCode.getErrorCode(), errorCode.getErrorMsg())
        }

        fun <T> success(t: T): ResultObj<T> {
            return ResultObj(t)
        }

        fun <T> failure(data: T?, errorCode: String, msg: String): ResultObj<T> {
            return ResultObj(data, errorCode, msg)
        }

        fun failure(e: Exception): ResultObj<String> {
            val errorCode = ErrorCode.getErrorCodeByExceptionClass(e)
            return ResultObj(errorCode.getErrorMsg(), errorCode.getErrorCode(), errorCode.getErrorMsg())
        }
    }
}