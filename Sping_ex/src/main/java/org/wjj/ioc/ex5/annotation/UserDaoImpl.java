package org.wjj.ioc.ex5.annotation;

import org.springframework.stereotype.Repository;
import org.wjj.ioc.ex5.annotation.UserDao;


/**
 * @author :wjj
 * @date : 2023/3/6
 * @Description :
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("userDao...save...");
    }
}
