package com.soft.servlet.freeze;

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
 * @date : 2024/7/30 11:56
 */
@WebServlet("/memberUpdate")
public class Servlet_freeze extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
//        String id = req.getParameter("id");
//        UserService userService = new UserServiceImpl();
//        try
//        {
//            member member = userService.queryFreezeById(Integer.valueOf(id));
//            if (member.getId()!=null)
//            {
//                req.setAttribute("mm",member);
//                req.getRequestDispatcher("back/memberManageList.jsp").forward(req,resp);
//            }
//        } catch (Exception e)
//        {
//            throw new RuntimeException(e);
//        }

        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");
        String freeze = req.getParameter("freeze");
        UserService userService = new UserServiceImpl();
        Integer ids = Integer.valueOf(id);
        try
        {
            int cnt = userService.updateById(ids, freeze);
            if (cnt!=0)
            {
                req.getRequestDispatcher("back/memberManageList.jsp").forward(req,resp);
            }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
}