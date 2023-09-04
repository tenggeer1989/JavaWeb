package com.tge.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: RequsetDemo1
 * Package: com.tge.web.request
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/1 - 9:47
 * Version:
 */

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求方式 ：GET
        String method = req.getMethod();
        System.out.println(method);
        //2.(*)获取虚拟目录：/chapter1
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //3. 获取Servlet路径: /requestDemo1
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        //4. 获取get方式请求参数：name=zhangsan
        String queryString = req.getQueryString();
        System.out.println(queryString);
        //5.(*)获取请求URI：/chapter1/requestDemo1
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURI);// /chapter1/requestDemo1
        System.out.println(requestURL);// http://localhost/chapter1/requestDemo1
        //6. 获取协议及版本：HTTP/1.1
        String protocol = req.getProtocol();
        System.out.println(protocol);
        //7. 获取客户机的IP地址：// 0:0:0:0:0:0:0:1
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
