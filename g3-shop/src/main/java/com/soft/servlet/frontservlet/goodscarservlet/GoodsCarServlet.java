package com.soft.servlet.frontservlet.goodscarservlet;

import com.alibaba.fastjson.JSON;
import com.soft.entity.GoodsCar;
import com.soft.entity.Member;
import com.soft.entity.PageSplitGoodsCar;
import com.soft.service.GoodsCarService;
import com.soft.service.impl.GoodsCarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
//   ${pageContext.request.contextPath}

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/25 14:16
 */
@WebServlet("/shopCar11")
public class GoodsCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // System.out.println("doget");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        Member userinfo = (Member)session.getAttribute("userinfo");
        Integer memberid = userinfo.getId();

        GoodsCarService goodsCarService = new GoodsCarServiceImpl();
        //分页
        PrintWriter pw = resp.getWriter();
        req.getParameter("currpage");

        String currpage = req.getParameter("currpage");
        if (currpage == null) {
            currpage = "1";
        }

        try {

            //分页处理
            Integer numpage = Integer.valueOf(currpage);
            int startindex = (numpage - 1) * 6;
            int psize = 6;

            List<GoodsCar> list =null;



            //获取总页数
            int totalcount = goodsCarService.count(memberid);
            int totalpage = totalcount % 6 == 0 ? totalcount / 6 : totalcount / 6 + 1;

            //获取列表中数据
             list = goodsCarService.list(startindex, psize, memberid);
            //System.out.println(list);
           //ajax分页
            PageSplitGoodsCar pageSplitGoodsCar=new PageSplitGoodsCar();

            pageSplitGoodsCar.setList(list);
            pageSplitGoodsCar.setCurrpage(numpage);
            pageSplitGoodsCar.setTotalpage(totalpage);
            //list-->json对象：'[{},{}]'
            String jsonString = JSON.toJSONString(pageSplitGoodsCar);
            pw.write(jsonString);

//            //把数据放到前台页面
//            req.setAttribute("list", list);
//关闭同步
//            req.getRequestDispatcher("front/page/shopCar.jsp").forward(req, resp);
//            return;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("dopost");
        this.doGet(req,resp);
    }
}