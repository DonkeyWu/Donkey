package com.donkey.redisdemo.web;

import com.donkey.redisdemo.dto.DonkeyDto;
import com.donkey.redisdemo.dto.DonkeyProxy;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;

/**
 * @author wch
 * @since 2023/5/5
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    DonkeyProxy donkeyProxy;

    @GetMapping("/getCache")
    public String getCache(){
        DonkeyDto donkey = donkeyProxy.get("donkey");
        return donkey.toString();
    }

    @GetMapping("/putCache")
    public String putCache(){
        DonkeyDto donkey = DonkeyDto.builder().age(18).name("donkey").birth(new Date()).build();
        donkey.save();
        return "success";
    }
}
