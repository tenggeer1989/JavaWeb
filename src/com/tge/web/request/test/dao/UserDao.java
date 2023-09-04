package com.tge.web.request.test.dao;

import com.tge.web.request.test.domain.User;
import com.tge.web.request.test.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ClassName: UserDao
 * Package: com.tge.web.request.test
 * Description:操作数据库中user表的类
 *
 * @Author: tge
 * @Create: 2023/9/1 - 23:12
 * Version:
 */
public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());





    public User login(User loginUser)  {
        try {
            // 1. 编写sql
            String sql = "select * from user where username = ? and password = ?";
            // 2. 调用query方法
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
