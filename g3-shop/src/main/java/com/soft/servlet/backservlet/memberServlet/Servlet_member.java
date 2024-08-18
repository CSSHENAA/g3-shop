package com.soft.servlet.backservlet.memberServlet;

import com.soft.entity.Member;
import com.soft.service.UserService;
import com.soft.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : XXX
 * @version : 1.0
 * @date : 2024/7/27 16:21
 */
@WebServlet("/memberManageView")
public class Servlet_member extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        UserService userService = new UserServiceImpl();
        String id = req.getParameter("id");
        try
        {
            Member member = userService.queryMemberById(Integer.valueOf(id));
            req.setAttribute("me",member);
            req.getRequestDispatcher("back/memberManageView.jsp").forward(req,resp);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}