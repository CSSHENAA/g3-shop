package com.soft.servlet.frontservlet.registServlet;

import com.soft.service.UserService;
import com.soft.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : XXX
 * @version : 1.0
 * @date : 2024/7/25 11:21
 */
@WebServlet("/reg")
public class Servlet_regist extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String flg = req.getParameter("flg2");
        if ("1".equals(flg)){
            this.doPost(req,resp);
        }else{
            check(req,resp);
        }





    }

    private void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String flg = req.getParameter("flg");
        UserService userService = new UserServiceImpl();
        Integer flg1 = Integer.valueOf(flg);
//        System.out.println(flg1);

        if (flg1==1)
        {
            try
            {
                int i = userService.queryByName(name);
                PrintWriter pw = resp.getWriter();
                if (i!=0)
                {
                    pw.write("用户名无效");
                }
                else
                {
                    pw.write("用户名有效");
                }
            } catch (Exception e)
            {
                throw new RuntimeException(e);
            }

        }
        else
        {
            try
            {
                int cnt = userService.queryByTrname(name);
                PrintWriter writer = resp.getWriter();
                if (cnt!=0)
                {
                    writer.write("名字无效");
                }
                else
                {
                    writer.write("名字有效");
                }
            } catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
//        System.out.println(1111);
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
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
            int regist = userService.regist(username, truename, password, city, address, email, Integer.valueOf(postcode), cardno, tel,"0");
            System.out.println(regist);
            if (regist!=0)
            {
                req.setAttribute("msg","注册成功，请登录");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
            else
            {
                req.setAttribute("msg","注册失败，请重新注册");
                req.getRequestDispatcher("/reg").forward(req,resp);
            }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }


    }
}