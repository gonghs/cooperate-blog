package com.server.kt

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

/**
 * 基础测试类
 *
 * @author maple
 * @version 1.0
 * @since 2019-02-27 01:31
 */

@RunWith(SpringRunner::class)
@SpringBootTest
open class BaseTest {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Before
    fun before(){
        log.info("----------执行前----------")
    }
    @After
    fun after(){
        log.info("----------执行后----------")
    }
    @Test
    fun contextLoads() {

    }

}