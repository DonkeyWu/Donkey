package com.donkey.redisdemo.dto;

import com.donkey.redisdemo.repository.CacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wch
 * @since 2023/5/6
 **/
@Service
public class DonkeyProxy implements CacheProxy<DonkeyDto> {

    @Override
    public DonkeyDto get(String key) {
        return new DonkeyDto().get(key);
    }
}
