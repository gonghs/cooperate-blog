package com.server.kt.config

import com.server.kt.db.repository.UserRepository
import com.server.kt.shiro.MyRealm
import com.server.kt.shiro.MySessionManager
import org.apache.shiro.authc.credential.HashedCredentialsMatcher
import org.apache.shiro.mgt.SecurityManager
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.web.mgt.DefaultWebSecurityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.inject.Inject

/**
 * 权限配置
 *
 * @author maple
 * @version 1.0
 * @since 2019-02-17 15:24
 */
@Configuration
open class ShiroConfig {

    @Inject
    private lateinit var mySessionManager: MySessionManager

    /**
     * 凭证匹配器
     */
    @Bean
    open fun hashedCredentialsMatcher(): HashedCredentialsMatcher {
        val hashedCredentialsMatcher = HashedCredentialsMatcher()
        hashedCredentialsMatcher.hashAlgorithmName = "md5"
        //进行两次md5加密验证
        hashedCredentialsMatcher.hashIterations = 2
        return hashedCredentialsMatcher
    }

    @Bean
    open fun securityManager(): SecurityManager {
        val securityManager = DefaultWebSecurityManager()
        securityManager.setRealm(myRealm())
        securityManager.sessionManager = mySessionManager
        return securityManager
    }

    @Bean
    open fun myRealm(): MyRealm {
        val myRealm = MyRealm()
//        myRealm.credentialsMatcher = (hashedCredentialsMatcher())
        return myRealm
    }

    @Bean
    open fun shiroFilterFactoryBean(securityManager: SecurityManager): ShiroFilterFactoryBean {
        val shiroFilterFactoryBean = ShiroFilterFactoryBean()
        shiroFilterFactoryBean.securityManager = securityManager
        val map = HashMap<String, String>(2)
        map["/logout"] = "logout"
        map["/login"] = "anon"
        map["/css/**"] = "anon"
        map["/js/**"] = "anon"
        //对所有用户认证
        map["/**"] = "authc"
        //配置未登录时访问的url
        shiroFilterFactoryBean.loginUrl = "/unLogin"
        shiroFilterFactoryBean.unauthorizedUrl = "/error"
        shiroFilterFactoryBean.filterChainDefinitionMap = map
        return shiroFilterFactoryBean
    }

    @Bean
    open fun authorizationAttributeSourceAdvisor(securityManager: SecurityManager): AuthorizationAttributeSourceAdvisor {
        return AuthorizationAttributeSourceAdvisor().apply { this.securityManager = securityManager }
    }
}