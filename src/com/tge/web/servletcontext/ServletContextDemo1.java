package com.tge.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: ServletContextDemo1
 * Package: com.tge.web.servletcontext
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/4 - 0:34
 * Version:
 */

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过request获取
        ServletContext context1 = req.getServletContext();
        //2.通过HttpServlet获取
        ServletContext context2 = this.getServletContext();

        System.out.println(context1);
        System.out.println(context2);
        System.out.println(context1 == context2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
