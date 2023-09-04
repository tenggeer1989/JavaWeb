package com.tge.web.request.test.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: JDBCUtils
 * Package: com.tge.web.request.test.util
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/1 - 23:15
 * Version:
 */
public class JDBCUtils {

    private static DataSource ds;

    static {
        // 1. 加重配置文件
        try {
            Properties properties = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);

            // 2. 初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * 获取连接池对象
    * */
    public static DataSource getDataSource(){
        return ds;
    }

    /*
    * 获取连接Connection对象
    * */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}
