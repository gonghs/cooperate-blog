package com.server.kt.db.entity


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

/**
 * 权限相关的实体类
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-05 15:24
 */
@Entity
@Table(name = "user_info")
class UserInfo {
    @Id
    @GeneratedValue
    val id: Long? = null
    val username: String? = null
    val account: String? = null
    val password: String? = null
}