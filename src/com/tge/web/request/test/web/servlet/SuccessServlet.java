package com.tge.web.request.test.web.servlet;

import com.tge.web.request.test.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: SuccessServlet
 * Package: com.tge.web.request.test.web.servlet
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/2 - 22:29
 * Version:
 */

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取req域中共享的user对象
        User user = (User)req.getAttribute("user");

        if (user != null) {
            // 设置编码
            resp.setContentType("text/html;charset=utf-8");

            // 输出
            resp.getWriter().write("登录成功！" + user.getUsername() + ",欢迎您！");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
