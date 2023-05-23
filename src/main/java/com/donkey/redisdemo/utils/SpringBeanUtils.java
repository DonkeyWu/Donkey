package com.donkey.redisdemo.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author wch
 * @since 2023/5/6
 **/
@Component
public class SpringBeanUtils implements ApplicationContextAware {
    public static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringBeanUtils.applicationContext = applicationContext;
    }
}

