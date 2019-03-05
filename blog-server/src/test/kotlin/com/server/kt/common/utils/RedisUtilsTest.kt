package com.server.kt.common.utils

import com.server.ja.BaseTest
import org.junit.Test
import org.slf4j.LoggerFactory
import javax.inject.Inject

/**
 * redis 工具类测试
 *
 * @author maple
 * @version 1.0
 * @since 2019-02-28 00:06
 */
class RedisUtilsTest : BaseTest() {
    private val log = LoggerFactory.getLogger(this.javaClass)
    private val testKey = this.javaClass.name

    @Inject
    lateinit var redisUtils: RedisUtils

    @Test
    fun testGetAny() {
        redisUtils.setAny(testKey, "11111")
        println(redisUtils.getT<String>(testKey))
        redisUtils.delete(testKey)
    }
}