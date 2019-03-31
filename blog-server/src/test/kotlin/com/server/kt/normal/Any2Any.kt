package com.server.kt.normal

import com.server.kt.db.entity.UserInfo
import org.junit.Test

/**
 * 对象拷贝测试
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-31 15:47
 */
class Any2Any{

    @Test
    fun any2Any(){
        val user = User("1","1")
        user.component1()
    }
}
data class User(val username:String,val password:String)