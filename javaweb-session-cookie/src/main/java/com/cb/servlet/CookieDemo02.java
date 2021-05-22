package com.cb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");


        //Cookie,服务器端从客户端获取
        Cookie[] cookies = req.getCookies(); //Cookie可能存在多个

        PrintWriter out = resp.getWriter();
        //判断cookie是否存在
        if(cookies!=null){
            //如果存在

            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获得cookie的名字
                if (cookie.getName().equals("name")) {
                    System.out.println(cookie.getValue());
                    out.write(URLEncoder.encode(cookie.getValue(),"utf-8"));  //防止乱码
                    out.write(cookie.getValue());
                }
            }
        }else {
            out.write("这是您第一次访问本站");
        }
        Cookie cookie = new Cookie("name", "陈博大哥");
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
