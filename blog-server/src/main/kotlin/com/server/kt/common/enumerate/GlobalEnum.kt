package com.server.kt.common.enumerate

import com.server.kt.common.entity.UndefinedException

/**
 * 全局定义的枚举类
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-05 16:29
 */
enum class ErrorCode(val code: String, val msg: String, val clazz: Class<out Exception>) {
    /**
     * 这个值代表抛出了 未在这个枚举中被定义的异常
     */
    ERROR("999", "该异常未定义", UndefinedException::class.java),
    NOT_FIND("001", "未找到对应的记录", NoSuchElementException::class.java),
    FIND_NULL("002", "未找到对应的记录", NullPointerException::class.java)
    ;

    companion object {
        fun getErrorCodeByExceptionClass(e: Exception): ErrorCode {
            return ErrorCode.values().filter { it.clazz === e::class.java }.getOrElse(0) { ERROR }
        }
    }
}