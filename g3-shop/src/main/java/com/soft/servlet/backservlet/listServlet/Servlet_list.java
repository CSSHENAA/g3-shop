package com.soft.servlet.backservlet.listServlet;

import com.alibaba.fastjson.JSON;
import com.soft.entity.PageSplit;
import com.soft.entity.Member;
import com.soft.service.UserService;
import com.soft.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author : XXX
 * @version : 1.0
 * @date : 2024/7/27 11:08
 */
@WebServlet("/memberManageList")
public class Servlet_list extends HttpServlet
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
        resp.setCharacterEncoding("utf-8");
        PrintWriter pw = resp.getWriter();
        String currpage = req.getParameter("currpage");
        System.out.println(currpage);

        if (currpage==null)
        {
            currpage="1";
        }

        try
        {

            Integer num = Integer.valueOf(currpage);
            int start = (num-1)*5;
            int end = start+5;

            int count = userService.count();
            int totalpage = count%5==0?count/5:count/5+1;


            List<Member> list = null;

             list = userService.list(start, end);


            PageSplit pageSplit = new PageSplit();
            pageSplit.setList(list);
            pageSplit.setCurrpage(num);
            pageSplit.setTotalpage(totalpage);


            String jsonString = JSON.toJSONString(pageSplit);
            System.out.println(jsonString);
            pw.write(jsonString);


        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}