package org.wjj.ioc.ex5.assemble;

import java.io.PrintWriter;
import java.util.List;

/**
 * @author :wjj
 * @date : 2023/3/6
 * @Description :
 */
public class User {

    private String username;
    private Integer password;
    private List<String> list;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public User() {
    }

    public User(String username, Integer password, List<String> list) {


        this.username = username;
        this.password = password;
        this.list = list;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + password +
                ", list=" + list +
                '}';
    }
}
