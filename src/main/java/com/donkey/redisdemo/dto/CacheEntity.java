package com.donkey.redisdemo.dto;

import cn.hutool.core.util.StrUtil;
import com.donkey.redisdemo.repository.CacheDao;
import com.donkey.redisdemo.utils.CacheUtils;
import com.donkey.redisdemo.utils.RedisUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;


/**
 * @author wch
 * @since 2023/5/5
 **/
@Data
public class CacheEntity<T> {


    @JsonIgnore
    private String jsonKey;

    @JsonIgnore
    private String jsonValue;

    private static final String EMPTY_VALUE="EMPTY";

    public void upload(String key, T value) {
        setJsonKey(key);
        setJsonValue(new Gson().toJson(value));
        RedisUtils.getRedisTemplate().opsForValue().set(key, jsonValue, 3000, TimeUnit.SECONDS);
    }

    public void uploadEmpty(String key) {
        setJsonKey(key);
        setJsonValue(EMPTY_VALUE);
        RedisUtils.getRedisTemplate().opsForValue().set(key, jsonValue, 3000, TimeUnit.SECONDS);
    }

    public <T> T get(String key) {
        setJsonKey(key);
        return get();
    }

    public <T> T get() {
        jsonValue = RedisUtils.getRedisTemplate().opsForValue().get(jsonKey);
        if (StrUtil.equals(jsonValue,EMPTY_VALUE)) {
            return null;
        }
        if (StrUtil.isEmpty(jsonValue)) {
            CacheDao cacheRepository = CacheUtils.getCacheRepository();
            CacheEntity temp = cacheRepository.select(this);
            if (temp==null) {
                uploadEmpty(jsonKey);
                return null;
            }
            jsonValue = temp.getJsonValue();
        }
        return new Gson().fromJson(jsonValue, (Type) this.getClass());
    }

    public <T> T get(CacheEntity cacheEntity){
        return new Gson().fromJson(cacheEntity.getJsonValue(), (Type) this.getClass());
    }

    public void flush(){
        CacheDao cacheRepository = CacheUtils.getCacheRepository();
        if (cacheRepository.exists(this)>0) {
            cacheRepository.update(this);
        }else{
            cacheRepository.insert(this);
        }
    }

}
