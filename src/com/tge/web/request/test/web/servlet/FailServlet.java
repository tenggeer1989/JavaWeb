package com.tge.web.request.test.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: FailServlet
 * Package: com.tge.web.request.test.web.servlet
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/2 - 22:29
 * Version:
 */

@WebServlet("/failServlet")
public class FailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 返回一个页面

        // 设置编码
        resp.setContentType("text/html;charset=utf-8");

        // 输出
        resp.getWriter().write("登录失败，用户名或密码错误");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
