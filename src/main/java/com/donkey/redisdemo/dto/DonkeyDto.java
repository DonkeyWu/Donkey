package com.donkey.redisdemo.dto;

import lombok.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wch
 * @since 2023/5/5
 **/
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonkeyDto extends CacheEntity<DonkeyDto> implements Serializable {
    private String name;
    private Date birth;
    private Integer age;


    public void save() {
        upload(getName(), this);
        flush();
    }

    public DonkeyDto getOne() {
        return get(getName());
    }
}
