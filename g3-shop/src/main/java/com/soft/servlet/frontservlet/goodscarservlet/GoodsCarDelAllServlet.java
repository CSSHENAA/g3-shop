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
 * @date : 2024/7/26 22:36
 */
@WebServlet("/deleteAll")
public class GoodsCarDelAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        String ids = req.getParameter("ids");
        System.out.println("批量删除ids："+ids);

        String[] split = ids.split(",");
        GoodsCarService goodsCarService = new GoodsCarServiceImpl();

        try {
            int cnt = goodsCarService.deleteAll(split);
            if (cnt!=0){
                System.out.println("删除成功");
                req.setAttribute("msg","删除成功");
               // req.getRequestDispatcher("front/page/shopCar.jsp").forward(req, resp);
            }else{
                System.out.println("删除失败");
                req.setAttribute("msg","删除失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}