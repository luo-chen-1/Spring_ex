package org.wjj.ioc.ex5.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :wjj
 * @date : 2023/3/6
 * @Description :
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void save() {
        this.userDao.save();
        System.out.println("userService....save...");
    }
}
