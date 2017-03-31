package me.liumingbo.designPattern.factoryMethodPattern.bean;

import java.util.Arrays;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class User {
    private String username;
    private char[] password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
