package com.tge.web.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: ResponseDemo5
 * Package: com.tge.web.response
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/3 - 22:49
 * Version:
 */
@WebServlet("/responseDemo5")
public class ResponseDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type","text/html;charset=utf-8");

        //1.获取字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //2.输出
        outputStream.write("hello".getBytes("utf-8"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
