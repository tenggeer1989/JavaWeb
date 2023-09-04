package com.tge.web.request.test.web.servlet;

import com.tge.web.request.test.dao.UserDao;
import com.tge.web.request.test.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * ClassName: servlet
 * Package: com.tge.web.request.test.web
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/2 - 22:20
 * Version:
 */

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置编码
        req.setCharacterEncoding("utf-8");

        /*// 2. 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 3. 封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        // 2. 获取所有请求参数
        Map<String, String[]> map = req.getParameterMap();

        // 3. 创建user对象
        User loginUser = new User();

        // 3.1 使用beanutils封装
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 4. 调用UserDao的login方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        if (user == null) {
            // 登录失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            // 登录成功
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
