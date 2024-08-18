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
 * @date : 2024/7/27 11:14
 */
@WebServlet("/update")
public class GoodsCarUpdateervlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget");
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //商品id
        int id = Integer.parseInt(req.getParameter("id"));
        //商品数量
        int number = Integer.parseInt(req.getParameter("num"));

        HttpSession session = req.getSession();
        Member userinfo = (Member)session.getAttribute("userinfo");
        Integer memberid = userinfo.getId();

        GoodsCarService goodsCarService =new GoodsCarServiceImpl();
        try {
            int cnt = goodsCarService.updateNum(number, memberid, id);
            if(cnt!=0){
                System.out.println("修改成功");
                req.setAttribute("msg","修改成功");
            }else{
                System.out.println("修改失败");
                req.setAttribute("msg","修改失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}