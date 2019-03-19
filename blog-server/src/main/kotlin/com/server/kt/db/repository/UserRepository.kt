package com.server.kt.db.repository

import com.server.kt.db.entity.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

/**
 * 用户数据访问类
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-05 15:28
 */
interface UserRepository : JpaRepository<UserInfo, String> {
    fun findByUsername(name: String):UserInfo?
    fun findByAccount(account: String):UserInfo?
}