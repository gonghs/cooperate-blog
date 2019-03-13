package com.server.kt.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import org.springframework.web.cors.CorsConfiguration



/**
 * 跨域配置
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-12 21:05
 */
@Configuration
open class CorsConfig{

    private fun buildConfig(): CorsConfiguration {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedOrigin("http://localhost:8080") // 1
        corsConfiguration.addAllowedOrigin("https://localhost:8080") // 1
        corsConfiguration.addAllowedHeader("*") // 2
        corsConfiguration.addAllowedMethod("*") // 3
        return corsConfiguration
    }

    @Bean
    open fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", buildConfig()) // 4
        return CorsFilter(source)
    }
}