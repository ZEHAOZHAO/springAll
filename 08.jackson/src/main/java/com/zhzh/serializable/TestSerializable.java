package com.zhzh.serializable;

import java.io.*;

/**
 * @Author: jason.zhao
 * @date:2019/4/24 13:09
 * @Description:
 */
public class TestSerializable {

    public static void writer(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\project\\springAll\\08.jackson\\lib\\output02.txt"));
            User02 user = new User02();
            user.setId(1);
            user.setName("xiaoming");
            user.setPassword("12345");
            oos.writeObject(user);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static User02 reader(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\project\\springAll\\08.jackson\\lib\\output02.txt"));
            User02 o = (User02) ois.readObject();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
   // writer();
        User02 reader = reader();
        System.out.println(reader.getId()+reader.getName()+reader.getPassword());
    }
}
