package com.tge.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: ResponseDemo4
 * Package: com.tge.web.response
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/3 - 22:10
 * Version:
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取流对象之前，设置流的编码
        //resp.setCharacterEncoding("utf-8");

        // 告诉浏览器，服务器发送的消息体数据用什么编码,建议浏览器用该编码
        resp.setHeader("content-type","text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw = resp.getWriter();
        //2.输出数据
        // pw.write("<h1>hello response</h1>");
        pw.write("你好  response ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
