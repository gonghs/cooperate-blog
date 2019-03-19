package com.server.kt.common.enumerate

import com.server.kt.common.exception.UnLoginException
import com.server.kt.common.exception.UndefinedException
import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.IncorrectCredentialsException
import org.apache.shiro.authc.LockedAccountException
import org.apache.shiro.authc.UnknownAccountException
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

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
    //空相关的异常
    NOT_FIND("001", "未找到对应的记录", NoSuchElementException::class.java),
    FIND_NULL("002", "未找到对应的记录", NullPointerException::class.java),

    NUMBER_FORMAT("003", "数字转化异常", NumberFormatException::class.java),
    METHOD_ARGUMENT_TYPE("004", "方法参数有误", MethodArgumentTypeMismatchException::class.java),

    //权限相关的异常
    UN_LOGIN("000", "未登录", UnLoginException::class.java),
    PASSWORD_ERROR("005", "密码错误", IncorrectCredentialsException::class.java),
    LOCKED_ACCOUNT("006", "用户已被冻结", LockedAccountException ::class.java),
    UNKNOWN_ACCOUNT("007", "用户不存在", UnknownAccountException ::class.java),
    USER_NOT_EXIST("008", "用户不存在", AuthenticationException ::class.java)
    ;

    companion object {
        fun getErrorCodeByExceptionClass(e: Exception): ErrorCode {
            return ErrorCode.values().filter { it.clazz === e::class.java }.getOrElse(0) { ERROR }
        }
    }
}