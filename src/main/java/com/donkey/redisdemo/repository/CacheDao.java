package com.donkey.redisdemo.repository;

import com.donkey.redisdemo.dto.CacheEntity;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wch
 * @since 2023/5/23
 **/
@Mapper
public interface CacheDao {

    boolean update(CacheEntity cache);

    boolean insert(CacheEntity cache);

    CacheEntity select(CacheEntity cache);

    Long exists(CacheEntity cache);
}
