package com.soft.servlet.backservlet.LoginServlet;

import com.soft.entity.Manager;
import com.soft.service.BackLoginService;
import com.soft.service.impl.BackLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/backlogin"})
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("------------doget-----------------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求参数
        System.out.println("---------dopost---------");
        String sname = req.getParameter("sname");
        String pass = req.getParameter("pass");
        System.out.println(sname + "-------------" + pass);
        BackLoginService backLoginService = new BackLoginServiceImpl();
        try
        {

            Manager manager = backLoginService.login(sname, pass);
            if (manager.getId() != null)
            {
                req.setAttribute("msg", "登录成功");
//                将用户信息储存到Session对象中
                HttpSession session = req.getSession();
                System.out.println(session.getId());
                session.setAttribute("loginfo",manager);
                req.getRequestDispatcher("back/goodsManageList.jsp").forward(req,resp);
            } else
            {
                req.setAttribute("msg", "登录失败");
                req.getRequestDispatcher("manage1.jsp").forward(req, resp);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

