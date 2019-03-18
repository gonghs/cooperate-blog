package com.server.kt.db.entity


import com.server.kt.common.entity.BaseEntity
import javax.persistence.Entity
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
class UserInfo : BaseEntity() {
    val username: String? = null
    val account: String? = null
    val password: String? = null

    override fun toString(): String {
        return "UserInfo(username=$username, account=$account, password=$password)"
}
}