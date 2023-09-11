package com.tge.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: SessionDemo2
 * Package: com.tge.web.session
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/6 - 22:28
 * Version:
 */

@WebServlet("/sessionDemo2")
public class SessionDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用session获取数据

        // 1. 获取session
        HttpSession session = req.getSession();
        // 2. 存储数据
        Object msg = session.getAttribute("msg");

        System.out.println(msg);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
