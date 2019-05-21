package com.zhzh;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: jason.zhao
 * @date:2019/4/24 11:03
 * @Description:
 */
//@JsonIgnoreProperties({"password", "id"})
//@JsonSerialize(using = UserSerializer.class)
//@JsonDeserialize(using = UserDeserializer.class)
public class User implements Serializable {
    public interface UserNameView {};
    public interface AllUserFieldView extends UserNameView {};
    private static final long serialVersionUID = 1324880418657391990L;
    @JsonView(UserNameView.class)
    private Integer id;
    //定义别名
    //@JsonProperty("userName")
    @JsonView(AllUserFieldView.class)
    private String name;
    //@JsonIgnore
    @JsonView(AllUserFieldView.class)
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDay;

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

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
