package com.tge.web.cookie.test;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * ClassName: CookieLogin
 * Package: com.tge.web.cookie.test
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/5 - 22:24
 * Version:
 */
@WebServlet("/cookieLogin")
public class CookieLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断有cookie的情况下是否有该地址的cookie
        boolean flag = false;
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html;charset=utf-8");

        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("lastTime".equals(cookie.getName())) {
                    flag = true;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Date date = new Date();
                    String currentTime = sdf.format(date);
                    System.out.println("编码前：" + currentTime);
                    //URL编码
                    currentTime = URLEncoder.encode(currentTime,"utf-8");
                    System.out.println("编码后：" + currentTime);
                    // 覆盖上次登录时间
                    cookie.setValue(currentTime);
                    // 设置cookie的存活时间
                    cookie.setMaxAge(60 * 60 * 24);
                    resp.addCookie(cookie);
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    // URL解码
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后：" + value);

                    resp.getWriter().write("您上次登录时间为：" + value);
                    return;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || flag == false) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = new Date();
            String currentTime = sdf.format(date);
            //URL编码
            currentTime = URLEncoder.encode(currentTime,"utf-8");

            Cookie cookie = new Cookie("lastTime",currentTime);
            resp.addCookie(cookie);
            resp.getWriter().write("欢迎您，首次登录1！！！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
