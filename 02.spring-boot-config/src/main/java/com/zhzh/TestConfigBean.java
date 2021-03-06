package com.zhzh;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: jason.zhao
 * @date:2019/4/11 16:39
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "test")
@PropertySource("classpath:test.properties")
public class TestConfigBean {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
