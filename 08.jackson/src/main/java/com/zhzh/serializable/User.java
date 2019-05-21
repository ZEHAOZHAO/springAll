package com.zhzh.serializable;

import java.io.Serializable;

/**
 * @Author: jason.zhao
 * @date:2019/4/24 11:03
 * @Description:
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
