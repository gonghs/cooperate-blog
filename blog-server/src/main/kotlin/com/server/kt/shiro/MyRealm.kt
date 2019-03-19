package com.server.kt.shiro

import com.server.kt.common.enumerate.GlobalConst
import com.server.kt.common.utils.RedisUtils
import com.server.kt.db.repository.UserRepository
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.AuthenticationInfo
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.authc.SimpleAuthenticationInfo
import org.apache.shiro.authz.AuthorizationInfo
import org.apache.shiro.authz.SimpleAuthorizationInfo
import org.apache.shiro.realm.AuthorizingRealm
import org.apache.shiro.subject.PrincipalCollection
import org.apache.shiro.util.ByteSource
import javax.inject.Inject
import org.apache.tomcat.jni.User.username


/**
 * 自定义shiro权限验证类
 *
 * @author maple
 * @version 1.0
 * @since 2019-02-16 19:48
 */
class MyRealm : AuthorizingRealm() {

    @Inject
    private lateinit var userRepository: UserRepository
    @Inject
    private lateinit var redisUtils: RedisUtils

    /**
     * 用户认证
     */
    override fun doGetAuthenticationInfo(token: AuthenticationToken): AuthenticationInfo? {
        token.principal ?: return null
        val account = token.principal.toString()
        val user = userRepository.findByAccount(account)
        return if (user == null) {
            null
        } else {
            val simpleAuthenticationInfo = SimpleAuthenticationInfo(account, user.password, name)
            simpleAuthenticationInfo
        }
    }

    /**
     * 权限追加
     */
    override fun doGetAuthorizationInfo(principals: PrincipalCollection): AuthorizationInfo {
        val account = principals.primaryPrincipal as String
        val user = userRepository.findByAccount(account)
        val simpleAuthorizationInfo = SimpleAuthorizationInfo()
//        user?.roles?.forEach {
//            simpleAuthorizationInfo.addRole(it.name)
//            simpleAuthorizationInfo.addStringPermissions(it.permissions.map { permission -> permission.name })
//        }
        return simpleAuthorizationInfo
    }

}