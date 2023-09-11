package com.tge.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: CookieDemo3
 * Package: com.tge.web.cookie
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/4 - 22:36
 * Version:
 */

@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 创建cookie对象
        Cookie c1 = new Cookie("msg", "hello");
        Cookie c2 = new Cookie("name", "tom");

        // 2. 发送cookie
        resp.addCookie(c1);
        resp.addCookie(c2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
