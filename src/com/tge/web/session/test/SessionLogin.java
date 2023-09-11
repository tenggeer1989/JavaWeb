package com.tge.web.session.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.annotation.ElementType;

/**
 * ClassName: LoginServlet
 * Package: com.tge.web.session.test
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/6 - 23:42
 * Version:
 */

@WebServlet("/sessionLogin")
public class SessionLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置request编码
        req.setCharacterEncoding("utf-8");
        // 2. 获取参数map
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        // 3. 先获取生成的验证码
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("code");
        // 删除session中存储的验证码
        session.removeAttribute("code");
        // 4. 判断验证码是否正确
        if(code != null && checkCode.equalsIgnoreCase(code)){
            if("zhangsan".equals(username) && "123".equals(password)){
                //登录成功
                // 存储用户信息到session
                session.setAttribute("user",username);
                // 转发到登录页面
                resp.sendRedirect("/success.jsp");
            }else {
                // 登录失败
                // 存储提示信息到request
                req.setAttribute("login_error","用户名或密码错误");
                // 转发到登录页面
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }else {
            // 验证码不一致
            // 存储提示信息到request
            req.setAttribute("cc_error","验证码错误");
            // 转发到登录页面
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
