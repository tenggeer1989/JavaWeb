package com.tge.web.request.test.app;

import com.tge.web.request.test.dao.UserDao;
import com.tge.web.request.test.domain.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * ClassName: UserDaoAPP
 * Package: com.tge.web.request.test.app
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/1 - 23:30
 * Version:
 */
public class UserDaoAPP {

    @Test
    public void testLogin()  {
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123");

        UserDao dao = new UserDao();
        User login = dao.login(user);

        System.out.println(login);


    }
}
