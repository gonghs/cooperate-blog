package com.server.kt.common.utils

import org.junit.Test
import org.slf4j.LoggerFactory

/**
 * md5加密测试类
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-19 16:07
 */
class MdUtilsTest {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Test
    fun md5() {
        log.info(MdUtils.md5(MdUtils.md5(MdUtils.md5("maple"))))
        log.info(MdUtils.md5("maple", 3))
    }

    @Test
    fun encodeByMD5() {
        val testStr = "我是用来md5测试的"
        log.info(testStr.encodeByMD5())
        log.info(testStr.encodeByMD5(2))
    }
}