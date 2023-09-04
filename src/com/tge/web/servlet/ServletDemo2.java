package com.tge.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: ServletDemo2
 * Package: com.tge.web.servlet
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/1 - 8:45
 * Version:
 */

//@WebServlet({"/d4","/dd4","/ddd4"})
//@WebServlet({"/user/*"})
//@WebServlet({"*.do"})
@WebServlet("/user/demo")
public class ServletDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo");
    }
}
