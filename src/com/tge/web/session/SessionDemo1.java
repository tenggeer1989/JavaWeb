package com.tge.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: SessionDemo1
 * Package: com.tge.web.session
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/6 - 22:25
 * Version:
 */

@WebServlet("/sessionDemo1")
public class SessionDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用session共享数据

        // 1. 获取session
        HttpSession session = req.getSession();
        // 2. 存储数据
        session.setAttribute("msg","hello session");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
