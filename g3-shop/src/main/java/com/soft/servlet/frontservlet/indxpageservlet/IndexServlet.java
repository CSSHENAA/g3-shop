package com.soft.servlet.frontservlet.indxpageservlet;

import com.alibaba.fastjson.JSON;
import com.soft.entity.Goods;
import com.soft.service.GoodsManageService;
import com.soft.service.IndexPageService;
import com.soft.service.impl.GoodsManageServiceImpl;
import com.soft.service.impl.IndexPageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author : qwj
 * @version : 1.0
 * @date : 2024/7/29 11:51
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsId = req.getParameter("id");
//        System.out.println(goodsId);
        GoodsManageService gms = new GoodsManageServiceImpl();
        try {
            Goods goods = gms.updateById(Integer.parseInt(goodsId));
            req.setAttribute("goods",goods);
            req.getRequestDispatcher("front/page/goodInfo.jsp").forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       resp.setCharacterEncoding("utf-8");

        String className = req.getParameter("classname");
//        System.out.println(className);
        IndexPageService backHomeService = new IndexPageServiceImpl();
        List<Goods> goodsList = null;
        try {
            if (className.equals("全部商品")) {
                goodsList = backHomeService.findGoodsAll();
            } else {
                goodsList = backHomeService.findClassName(className);
            }
//            System.out.println(goodsList);
            PrintWriter pw = resp.getWriter();
            String jsonString = JSON.toJSONString(goodsList);
            pw.write(jsonString);
            System.out.println(jsonString);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
