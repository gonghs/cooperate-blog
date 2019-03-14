package com.server.kt.db.repository

import com.server.kt.BaseTest
import org.junit.Test
import javax.inject.Inject

/**
 * user数据访问类测试
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-14 20:25
 */
class UserRepositoryTest:BaseTest(){
    @Inject
    lateinit var userRepository: UserRepository

    @Test
    fun findByUsername(){
        val user = userRepository.findByUsername("maple")
        println(user.toString())
    }
}