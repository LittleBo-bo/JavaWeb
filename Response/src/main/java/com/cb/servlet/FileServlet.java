package com.cb.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取下载文件的路径
        String realPath = "D:\\JavaEE\\JavaWeb\\Response\\target\\classes\\1.png";
        System.out.println("下载文件的路径："+realPath);
        //下载的文件名是啥
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //让浏览器能够支持下载我们需要的东西,让中文文件名编码，否则会乱码
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
        //获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //创建缓冲区
        int len = 0;
        byte[] bytes = new byte[1024];
        //获取outputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //将fileoutputStream流写入到buffer缓冲区,使用OutputStream将缓冲区中的数据输出带客户端
        while((len=in.read(bytes))>0){
            out.write(bytes,0,len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
