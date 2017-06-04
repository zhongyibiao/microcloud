package com.xiaoweiyunchuang.microcloud.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;  
import com.fasterxml.jackson.annotation.PropertyAccessor;  
import com.fasterxml.jackson.databind.ObjectMapper;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;  
import org.springframework.cache.annotation.CachingConfigurerSupport;  
import org.springframework.cache.annotation.EnableCaching;  
import org.springframework.cache.interceptor.KeyGenerator;  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.data.redis.cache.RedisCacheManager;  
import org.springframework.data.redis.connection.RedisConnectionFactory;  
import org.springframework.data.redis.core.RedisTemplate;  
import org.springframework.data.redis.core.StringRedisTemplate;  
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;  
  



import java.lang.reflect.Method;

/** 
 * @author  lilufeng 
 * @date 创建时间：2016年5月9日 下午2:46:23 
 * 
 */

@Configuration  
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
	
	private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

	 @Bean  
	 public KeyGenerator wiselyKeyGenerator(){  
        return new KeyGenerator() {  
            @Override  
            public Object generate(Object target, Method method, Object... params) {  
                StringBuilder sb = new StringBuilder();  
                sb.append(target.getClass().getName());  
                sb.append(method.getName());  
                for (Object obj : params) {  
                    sb.append(obj.toString());  
                }  
                logger.info("KeyGenerator:" + sb.toString());
                return sb.toString();  
            }  
        };  
  
    }  
  
    @SuppressWarnings("rawtypes")
	@Bean  
    public CacheManager cacheManager(RedisTemplate redisTemplate) {  
        return new RedisCacheManager(redisTemplate);  
    }  
  
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean  
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {  
        StringRedisTemplate template = new StringRedisTemplate(factory);  
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);  
        ObjectMapper om = new ObjectMapper();  
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
        jackson2JsonRedisSerializer.setObjectMapper(om);  
        template.setValueSerializer(jackson2JsonRedisSerializer);  
        template.afterPropertiesSet();  
        return template;  
    }  
}  
