package com.donkey.redisdemo.dto;

import java.lang.reflect.Type;

/**
 * @author wch
 * @since 2023/5/6
 **/
public interface CacheProxy<T extends CacheEntity> {

    public <T> T get(String key);

}
