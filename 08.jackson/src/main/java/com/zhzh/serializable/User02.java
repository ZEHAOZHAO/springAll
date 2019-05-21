package com.zhzh.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @Author: jason.zhao
 * @date:2019/4/24 13:24
 * @Description:
 */
public class User02 implements Externalizable {
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
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(password);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
         name = (String) in.readObject();
         password = (String) in.readObject();
    }
}
