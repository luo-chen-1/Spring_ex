package org.wjj.entity;

/**
 * @author :wjj
 * @date : 2023/3/7
 * @Description :
 */
public class User {

    private String username;

    private  String password;

    private   String createTime;

    public User(String username, String password, String createTime) {
        this.username = username;
        this.password = password;
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
