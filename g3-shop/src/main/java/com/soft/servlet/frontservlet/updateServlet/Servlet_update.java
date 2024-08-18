package com.soft.servlet.frontservlet.updateServlet;

import com.soft.entity.Member;
import com.soft.service.UserService;
import com.soft.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author : XXX
 * @version : 1.0
 * @date : 2024/7/26 16:08
 */
@WebServlet("/edit")
public class Servlet_update extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String flg = req.getParameter("flg2");
        if ("1".equals(flg))
        {
            this.doPost(req, resp);
        } else {
            check(req, resp);
        }



    }

    private void check(HttpServletRequest req, HttpServletResponse resp)
    {


        HttpSession session = req.getSession();
        Member userinfo = (Member)session.getAttribute("userinfo");
        Integer memberid = userinfo.getId();

//        String id = req.getParameter("id");
//        System.out.println(id);
        UserService userService = new UserServiceImpl();
        try
        {
            Member me = userService.queryById(memberid);
            System.out.println(me);
            if (me.getId()!=null)
            {
                System.out.println(me.getId());

                req.setAttribute("mem", me);
//                System.out.println(me);
                req.getRequestDispatcher("/front/page/edit.jsp").forward(req,resp);
            }
            else
            {
                req.setAttribute("msg","账号不存在");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String username = req.getParameter("sname");
        String truename = req.getParameter("trname");
        String password = req.getParameter("pass");
        String city = req.getParameter("citytxt");
        String add = req.getParameter("contrytxt");
        String pro = req.getParameter("provincetxt");
        String address = add+pro;
        String email = req.getParameter("email");
        String postcode = req.getParameter("postcode");
        String cardno = req.getParameter("cardno");
        String tel = req.getParameter("tel");

        UserService userService = new UserServiceImpl();
        try
        {
            int update = userService.update(Integer.valueOf(id), username, truename, password, city, address, email, Integer.valueOf(postcode), cardno, tel);
            if (update!=0)
            {
                req.setAttribute("msg","修改成功");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
            else
            {
                req.setAttribute("msg","修改失败");
                req.getRequestDispatcher("front/page/edit.jsp").forward(req,resp);
            }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
}