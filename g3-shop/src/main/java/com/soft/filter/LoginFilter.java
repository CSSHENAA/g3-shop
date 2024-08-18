package com.soft.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/30 00:59
 */
@WebFilter(urlPatterns = {"/shopCar.jsp","/addGoods","/shopCar11","/edit","/cartest","/list"})
//@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //权限验证
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;

        //获取session对象   -->使用过滤器登录验证
        HttpSession session = req.getSession();
//        String requestURI = req.getRequestURI();
//        System.out.println(req.getRequestURI());
//        System.out.println(session.getAttribute("userinfo"));
//        if (requestURI.endsWith("shopCar11")){
//            PrintWriter writer = resp.getWriter();
//            String str="{'code':100}";
//            writer.write(str);
//            return;
//        }
        if (session.getAttribute("userinfo") == null) {
            req.setAttribute("msg", "您没有权限 请先完成登录");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }




        //当验证正确  放行
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}