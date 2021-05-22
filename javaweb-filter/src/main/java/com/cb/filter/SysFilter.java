package com.cb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        Object user_session = request1.getSession().getAttribute("USER_SESSION");
        if(user_session==null){
            response1.sendRedirect("/error.jsp");
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
