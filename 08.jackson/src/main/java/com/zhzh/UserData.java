package com.zhzh;

/**
 * @Author: jason.zhao
 * @date:2019/4/24 15:28
 * @Description:
 */
public class UserData {
    private User user;
    private String Name;
    private Boolean Verifie;
    private int[] Marks;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boolean getVerifie() {
        return Verifie;
    }

    public void setVerifie(Boolean verifie) {
        Verifie = verifie;
    }

    public int[] getMarks() {
        return Marks;
    }

    public void setMarks(int[] marks) {
        Marks = marks;
    }
}
