package org.wjj.ioc;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class UserServiceimpl implements UserService{

    private  UserDao userDao;

    private String msq;



    public UserServiceimpl() {

    }

    public UserServiceimpl(String mag) {
        this.userDao = userDao;
    }

    public void setMsq(String msq) {
        this.msq = msq;
    }

    @Override
    public String toString() {
        return "UserServiceimpl{" +
                "msq='" + msq + '\'' +
                '}';
    }

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void say() {
        this.userDao.say();
        System.out.println("userService say hello world!");
    }




}
