package com.server.kt.common.utils

import org.junit.Test

import java.util.*

/**
 * 时间工具类测试
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-31 15:27
 */
class DateUtilsTest {

    @Test
    fun format2Str() {
        println(Date().format2Str("yyyyMMdd"))
    }
}