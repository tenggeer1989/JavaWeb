package com.tge.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * ClassName: ServletContextDemo5
 * Package: com.tge.web.servletcontext
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/4 - 0:50
 * Version:
 */
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过HttpServlet获取
        ServletContext context = this.getServletContext();

        // 获取文件路径
        String realPath = context.getRealPath("/b.txt");//web目录下的资源访问

        System.out.println(realPath);
        //File file = new File(realPath);

        String realPath1 = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
        System.out.println(realPath1);

        String realPath2 = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(realPath2);




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
