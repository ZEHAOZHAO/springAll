package com.zhzh;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: jason.zhao
 * @date:2019/4/11 16:27
 * @Description:
 */
@ConfigurationProperties(prefix = "mrbird.blog")
public class ConfigBean {
    private String name;
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
