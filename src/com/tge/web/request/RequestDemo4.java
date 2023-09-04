package com.tge.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: RequestDemo4
 * Package: com.tge.web.request
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/1 - 10:18
 * Version:
 */

@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String referer = req.getHeader("referer");
        System.out.println(referer);//http://localhost/chapter1/login.html

        //防盗链
        if(referer != null ){
            if(referer.contains("/chapter1")){
                //正常访问
                // System.out.println("播放电影....");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("播放电影....");
            }else{
                //盗链
                //System.out.println("想看电影吗？来优酷吧...");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("想看电影吗？来优酷吧...");
            }
        }
    }
}
