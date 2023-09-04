package com.tge.web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: RequestDemo5
 * Package: com.tge.web.request
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/1 - 10:42
 * Version:
 */

@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("demo8888被访问");
        // RequestDispatcher requestDispatcher = req.getRequestDispatcher("/requestDemo9");
        //
        // requestDispatcher.forward(req,resp);

        // 数据共享
        req.setAttribute("msg","hello");

        req.getRequestDispatcher("/requestDemo9").forward(req,resp);

    }
}
