package com.tge.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: ResponseDemo1
 * Package: com.tge.web.response
 * Description:redirect
 *
 * @Author: tge
 * @Create: 2023/9/3 - 21:31
 * Version:
 */

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 访问该资源，自动跳转到/responseDemo2
        System.out.println("demo1..../////");

        // 1. 设置状态码为302
        // resp.setStatus(302);
        //
        // resp.setHeader("location","/responseDemo2");

        // 简单的重定向
        resp.sendRedirect("/responseDemo2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
