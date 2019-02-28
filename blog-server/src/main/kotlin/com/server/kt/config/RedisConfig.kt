package com.server.kt.config


import com.alibaba.fastjson.parser.ParserConfig
import com.server.kt.utils.FastJsonRedisSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer

/**
 * redis 配置类
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-02 09:53
 */
@Configuration
open class RedisConfig{

    /**
     * 将redisTemplate格式化为string,any格式
     *
     * @param factory redis连接工厂
     * @return redisTemplate
     */
    @Bean
    open fun redisTemplate(factory: RedisConnectionFactory):RedisTemplate<String,Any> {
        val template = RedisTemplate<String,Any>()
        template.connectionFactory = factory
//        val hessianRedisSerializer = HessianRedisSerializer(Any::class.java)
//        var javaRedisSerializer = JavaRedisSerializer<Any>()
        val fastJsonRedisSerializer = FastJsonRedisSerializer(Any::class.java)
        //配置白名单
        ParserConfig.getGlobalInstance().addAccept("com.server")
        //或者直接关闭这个检测
//        ParserConfig.getGlobalInstance().isAutoTypeSupport = true
        val stringRedisSerializer = StringRedisSerializer()
        template.keySerializer = stringRedisSerializer
        template.hashKeySerializer = stringRedisSerializer
        template.valueSerializer = fastJsonRedisSerializer
        template.hashValueSerializer = fastJsonRedisSerializer
        template.afterPropertiesSet()
        return template
    }
}