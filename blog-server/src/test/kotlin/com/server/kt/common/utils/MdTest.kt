package com.server.kt.common.utils

import org.junit.Test

/**
 * md5加密测试类
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-19 16:07
 */
class MdTest{
    @Test
    fun md5(){
        println(MdUtils.md5(MdUtils.md5(MdUtils.md5("maple"))))
        println(MdUtils.md5("maple",3))
    }
}