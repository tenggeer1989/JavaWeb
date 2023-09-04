package com.tge.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
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

@WebServlet("/requestDemo7")
public class RequestDemo7 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置流的编码
        //req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");

        System.out.println(username);
    }
}
