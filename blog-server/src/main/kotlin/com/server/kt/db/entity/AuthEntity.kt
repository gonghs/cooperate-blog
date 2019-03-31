package com.server.kt.db.entity


import com.server.kt.common.entity.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotBlank

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
    @NotBlank(groups = [Login::class])
    val account: String? = null
    @NotBlank(groups = [Login::class])
    val password: String? = null

    //校验的标记接口

    //登陆校验
    interface Login

    override fun toString(): String {
        return "UserInfo(username=$username, account=$account, password=$password)"
    }
}