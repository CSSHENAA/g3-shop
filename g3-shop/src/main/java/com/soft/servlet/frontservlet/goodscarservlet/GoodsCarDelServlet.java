package com.soft.servlet.frontservlet.goodscarservlet;

import com.soft.service.GoodsCarService;
import com.soft.service.impl.GoodsCarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/26 17:21
 */
@WebServlet("/delete")
public class GoodsCarDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       resp.setCharacterEncoding("utf-8");
       //从页面拿到商品id
       String  id= req.getParameter("id");
        System.out.println(id);
        GoodsCarService goodsCarService=new GoodsCarServiceImpl();
        try {
            int cnt = goodsCarService.delete(Integer.parseInt(id));
            if(cnt!=0){
                System.out.println("删除成功");
                req.setAttribute("msg","删除成功");
                req.getRequestDispatcher("front/page/shopCar.jsp").forward(req, resp);
            }else{
                System.out.println("删除失败");
                req.setAttribute("msg","删除失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost");
    }
}