package com.server.kt.shiro

import com.server.kt.common.enumerate.GlobalConst
import org.apache.shiro.web.servlet.ShiroHttpServletRequest
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager
import org.apache.shiro.web.util.WebUtils
import org.springframework.stereotype.Component
import java.io.Serializable
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

/**
 * 自定义会话拦截
 *  需要定义这个拦截器修改前后端分离项目中sessionId的获取方式,否则请求会被shiro过滤
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-18 11:26
 */
@Component
class MySessionManager : DefaultWebSessionManager() {
    companion object {
        const val REFERENCED_SESSION_ID_SOURCE = "Stateless request"
    }

    override fun getSessionId(request: ServletRequest, response: ServletResponse?): Serializable {
        val token = WebUtils.toHttp(request).getHeader(GlobalConst.HEAD_TOKEN_KEY)
        //请求头中如果带了token 则从这里获取session id
        return if (token.isNotBlank()) {
            request.setAttribute(
                ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,
                REFERENCED_SESSION_ID_SOURCE
            )
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, token)
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, true)
            token
        } else {
            return super.getSessionId(request, response)
        }
    }
}