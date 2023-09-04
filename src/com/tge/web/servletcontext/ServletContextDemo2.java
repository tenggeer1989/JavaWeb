package com.tge.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: ServletContextDemo2
 * Package: com.tge.web.servletcontext
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/4 - 0:37
 * Version:
 */
@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过HttpServlet获取
        ServletContext context = this.getServletContext();

        // 定义文件名称
        String filename = "a.txt";

        // 获取MIME类型
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
