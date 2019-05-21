package com.zhzh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: jason.zhao
 * @date:2019/4/11 16:21
 * @Description:
 */
@Component
public class BlogProperties {

    @Value("${mrbird.blog.name}")
    private String name;
    @Value("${mrbird.blog.title}")
    private String title;
    @Value("${mrbird.blog.wholeTitle}")
    private String wholeTitle;

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

    public String getWholeTitle() {
        return wholeTitle;
    }

    public void setWholeTitle(String wholeTitle) {
        this.wholeTitle = wholeTitle;
    }
}
