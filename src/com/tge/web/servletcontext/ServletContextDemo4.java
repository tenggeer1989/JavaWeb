package com.tge.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: ServletContextDemo4
 * Package: com.tge.web.servletcontext
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/4 - 0:46
 * Version:
 */
@WebServlet("/servletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过HttpServlet获取
        ServletContext context = this.getServletContext();

        // 设置数据
        Object msg = context.getAttribute("msg");

        System.out.println(msg);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
