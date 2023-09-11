package com.tge.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: CookieDemo4
 * Package: com.tge.web.cookie
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/4 - 22:45
 * Version:
 */

@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 创建cookie对象
        Cookie c1 = new Cookie("msg", "setMaxAge");

        // 2. 设置cookie的存活时间
        c1.setMaxAge(30); // 将cookie持久化到硬盘，30秒后会自动删除cookie文件

        // 3. 发送cookie
        resp.addCookie(c1);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
