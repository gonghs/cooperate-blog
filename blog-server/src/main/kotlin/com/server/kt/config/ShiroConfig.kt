package com.server.kt.config

import com.server.kt.shiro.MyShiroRealm
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
    private lateinit var myShiroReam: MyShiroRealm

//    @Bean
//    open fun securityManager(): SecurityManager {
//        val securityManager = DefaultWebSecurityManager()
//        securityManager.setRealm(myShiroReam)
//        return securityManager
//    }
//
//    @Bean
//    open fun shiroFilterFactoryBean(securityManager: SecurityManager): ShiroFilterFactoryBean {
//        val shiroFilterFactoryBean = ShiroFilterFactoryBean()
//        shiroFilterFactoryBean.securityManager = securityManager
//        val map = HashMap<String, String>(2)
//        map["/logout"] = "logout"
//        map["/css/**"] = "anon"
//        map["/js/**"] = "anon"
//        //对所有用户认证
//        map["/**"] = "authc"
//        shiroFilterFactoryBean.loginUrl = "/login"
//        shiroFilterFactoryBean.successUrl = "/index"
//        shiroFilterFactoryBean.unauthorizedUrl = "/error"
//        shiroFilterFactoryBean.filterChainDefinitionMap = map
//        return shiroFilterFactoryBean
//    }
//
//    @Bean
//    open fun authorizationAttributeSourceAdvisor(securityManager: SecurityManager):AuthorizationAttributeSourceAdvisor {
//        return AuthorizationAttributeSourceAdvisor().apply { this.securityManager = securityManager }
//    }
}