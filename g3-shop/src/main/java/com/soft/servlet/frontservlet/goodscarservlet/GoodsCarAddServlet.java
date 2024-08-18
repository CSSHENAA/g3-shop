package com.soft.servlet.frontservlet.goodscarservlet;

import com.soft.entity.Member;
import com.soft.service.GoodsCarService;
import com.soft.service.impl.GoodsCarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/26 23:48
 */
@WebServlet("/addGoods")
public class GoodsCarAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String goodsId = req.getParameter("goodsId");
        String priceText = req.getParameter("priceText");
        //System.out.println("商品id："+goodsId);
        //System.out.println(priceText);
        String[] split = priceText.split("￥");
//        System.out.println(split[1]);
//double.parseDouble(split[1]);
        double price = Double.parseDouble(split[1]);
        GoodsCarService goodsCarService=new GoodsCarServiceImpl();

        HttpSession session = req.getSession();
        Member userinfo = (Member)session.getAttribute("userinfo");
        Integer memberid = userinfo.getId();

        try {
            //商品id  会员id
            int cnt = goodsCarService.add(Integer.parseInt(goodsId), memberid,price);

            if(cnt!=0){
                System.out.println("添加成功");
//                req.getRequestDispatcher("front/page/shopCar.jsp").forward(req, resp);
                resp.sendRedirect("front/page/shopCar.jsp");
            }else{
                System.out.println("添加失败");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}