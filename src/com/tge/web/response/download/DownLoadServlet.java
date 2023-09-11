package com.tge.web.response.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ClassName: DownLoadServlet
 * Package: com.tge.web.response.download
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/4 - 22:08
 * Version:
 */

@WebServlet("/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求参数，文件名称
        String filename = req.getParameter("filename");
        // 2. 使用字节输入流加载文件进内存
        // 2.1 找到文件服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        // 2.2 用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        // 3. 设置response的响应头
        // 3.1 设置响应头类型， content-type
        String mimeType = getServletContext().getMimeType(filename);
        resp.setHeader("content-type",mimeType);

        // 3.2 设置响应头打开方式 content-disposition

        // 解决中文文件名问题
        // 1. 获取
         resp.setHeader("content-disposition","attachment;filename=" + filename);

        // 4. 将输入流的数据写出到输出流中
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }
        fis.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
