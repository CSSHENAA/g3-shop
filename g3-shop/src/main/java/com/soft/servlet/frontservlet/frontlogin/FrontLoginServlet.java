package com.soft.servlet.frontservlet.frontlogin;

import com.soft.entity.Member;
import com.soft.service.FrontLoginService;
import com.soft.service.impl.FrontLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/29 22:25
 */
@WebServlet({"/login","/logout"})
public class FrontLoginServlet extends HttpServlet {
    private static final Map<String, Integer> loginAttempts = new HashMap<>();
    private static final int MAX_ATTEMPTS = 3;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("sname");
        String password = req.getParameter("pass");
        FrontLoginService frontLoginService = new FrontLoginServiceImpl();
        System.out.println(username + "----" + password);
        try {
            int freeze = frontLoginService.findFreeze(username);
           // System.out.println(freeze);

        // 检查用户是否被锁定
            if (freeze == 1 ) {
                req.setAttribute("msg", "账号已冻结 请联系管理员");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
                return;
            }


            //查询该账号密码的用户信息
            Member namePass = frontLoginService.findNamePass(username, password);

            if (namePass != null && namePass.getId() != null) {
                // 登录成功时重置登录尝试次数
                loginAttempts.remove(username);
                //创建session对象存储登录信息
                HttpSession session = req.getSession();
                session.setAttribute("userinfo",namePass);

                req.getRequestDispatcher("index.jsp").forward(req, resp);

            } else {
                // 登录失败时 增加 登录尝试次数
                int attempts = loginAttempts.getOrDefault(username, 0) + 1;
                loginAttempts.put(username, attempts);
                if (attempts >= MAX_ATTEMPTS) {
//
                    req.setAttribute("msg","账号已冻结 请联系管理员");
                    frontLoginService.updateFreeze(username,"1");
                    req.getRequestDispatcher("login.jsp").forward(req,resp);
                } else {
                    //resp.getWriter().write("用户名或密码错误。剩余尝试次数: " + (MAX_ATTEMPTS - attempts));
                    //req.setAttribute("msg","用户名或密码错误。剩余尝试次数: " + (MAX_ATTEMPTS - attempts));
                  // req.getRequestDispatcher("login.jsp").forward(req,resp);
                    resp.sendRedirect("login.jsp");
//
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //删除session对象
        session.removeAttribute("userinfo");
        req.getRequestDispatcher("login.jsp").forward(req,resp);
        //doPost(req, resp);

    }
}
