package org.wjj.ioc;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class UserDaoimpl implements UserDao{

    @Override
    public void say() {
        System.out.println("userdao say hello world!");
    }
}
