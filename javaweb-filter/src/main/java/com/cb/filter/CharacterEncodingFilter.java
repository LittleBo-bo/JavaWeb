package com.cb.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        System.out.println("CharacterEncodingFilter执行前");
        filterChain.doFilter(request,response); //让我们的请求继续走，如果不写，程序停止
        System.out.println("CharacterEncodingFilter执行后");
    }

    //web服务器关闭时，过滤会销毁
    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter销毁");
    }
}
