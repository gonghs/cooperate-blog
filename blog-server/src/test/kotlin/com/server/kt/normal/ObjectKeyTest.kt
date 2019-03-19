package com.server.kt.normal

import com.server.kt.common.enumerate.ErrorCode
import org.junit.Test
import java.lang.RuntimeException

/**
 * 以对象为key的测试类
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-19 12:34
 */
class ObjectKeyTest{
    @Test
    fun hashTest(){
        val map = HashMap<Class<out Exception>,ErrorCode>()
        val exception:Exception = RuntimeException()
        val exception1:Exception = Exception()
        map[Exception::class.java] = ErrorCode.FIND_NULL
        map[RuntimeException::class.java] = ErrorCode.ERROR
        println(map[exception.javaClass])
        println(map[exception1.javaClass])
        println(Class.forName(exception::class.java.name))
    }
}