package com.cb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //服务器告诉你访问的时间，把这个时间封装成为一个信件。

        //中文乱码
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        //Cookie,服务器端从客户端获取
        Cookie[] cookies = req.getCookies(); //Cookie可能存在多个

        //判断cookie是否存在
        if(cookies!=null){
             //如果存在
            out.write("你上一次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获得cookie的名字
                if (cookie.getName().equals("lastLoginTime")) {
                    //获取cookie中的值

                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(String.valueOf(date));
                }
            }
        }else {
            out.write("这是您第一次访问本站");
        }


        //服务给客户端响应一个cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");

        //cookie有效期为一天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
