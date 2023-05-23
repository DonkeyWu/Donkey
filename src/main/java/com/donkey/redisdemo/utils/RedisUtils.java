package com.donkey.redisdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author wch
 * @since 2023/5/6
 **/
public class RedisUtils {
    public static RedisTemplate<String,String> getRedisTemplate(){
        return SpringBeanUtils.applicationContext.getBean("stringRedisTemplate",RedisTemplate.class);
    }


}
