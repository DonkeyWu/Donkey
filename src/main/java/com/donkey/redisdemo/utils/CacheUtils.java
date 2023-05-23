package com.donkey.redisdemo.utils;

import com.donkey.redisdemo.repository.CacheDao;

/**
 * @author wch
 * @since 2023/5/23
 **/
public class CacheUtils {
    public static CacheDao getCacheRepository(){
        return SpringBeanUtils.applicationContext.getBean("cacheDao",CacheDao.class);
    }
}
