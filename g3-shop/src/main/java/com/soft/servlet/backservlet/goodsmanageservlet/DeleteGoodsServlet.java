package com.soft.servlet.backservlet.goodsmanageservlet;

import com.soft.service.GoodsManageService;
import com.soft.service.impl.GoodsManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : qwj
 * @version : 1.0
 * @date : 2024/7/25 10:49
 */
@WebServlet("/managedelete")
public class DeleteGoodsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(11111);
        String id = req.getParameter("id");
        System.out.println(id);

        GoodsManageService goodsManageService = new GoodsManageServiceImpl();

        try {
            int i = goodsManageService.deleteById(Integer.valueOf(id));
            if (i!=0){
                req.setAttribute("msg","删除成功");
            }else {
                req.setAttribute("msg","删除失败");
            }

            resp.sendRedirect("back/goodsManageList.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
