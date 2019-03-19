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
data class ResultObj<T>(val data: T?, val success: Boolean, val errorCode: String, val msg:String) {
    /**
     * 默认为成功
     */
    constructor(data: T?) : this(data, true, GlobalConst.SUCCESS,GlobalConst.DEFAULT_SUCCESS_MSG)

    companion object {
        fun <T> failure(t: T, e: Exception): ResultObj<T> {
            val errorCode = ErrorCode.getErrorCodeByExceptionClass(e)
            return ResultObj(t, false, errorCode.code,errorCode.msg)
        }

        fun <T> success(t: T): ResultObj<T> {
            return ResultObj(t, true, GlobalConst.SUCCESS,GlobalConst.DEFAULT_SUCCESS_MSG)
        }

        fun failure(e: Exception): ResultObj<String> {
            val errorCode = ErrorCode.getErrorCodeByExceptionClass(e)
            return ResultObj(errorCode.msg, false, errorCode.code,errorCode.msg)
        }
    }
}