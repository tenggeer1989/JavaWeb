package com.tge.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: RequestDemo3
 * Package: com.tge.web.request
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/1 - 10:05
 * Version:
 */

@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String agent = req.getHeader("user-agent");
        //判断agent的浏览器版本
        if(agent.contains("Chrome")){
            //谷歌
            System.out.println("google");
        }else if(agent.contains("Edg")){
            //edge
            System.out.println("edge");
        }

    }
}
