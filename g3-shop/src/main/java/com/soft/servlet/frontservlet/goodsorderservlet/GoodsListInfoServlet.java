package com.soft.servlet.frontservlet.goodsorderservlet;

import com.soft.entity.Goods_orderdetail;
import com.soft.entity.Order;
import com.soft.service.GoodsManagerOrderService;
import com.soft.service.impl.GoodsManagerOrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : wyq
 * @version : 1.0
 * @date : 2024/7/26 19:44
 */
@WebServlet("/listinfo")
public class GoodsListInfoServlet extends HttpServlet {
    @Override
    protected void doGet ( HttpServletRequest req , HttpServletResponse resp ) throws ServletException, IOException {
        this.doPost ( req,resp );
    }

    @Override
    protected void doPost ( HttpServletRequest req , HttpServletResponse resp ) throws ServletException, IOException {
        GoodsManagerOrderService gms = new GoodsManagerOrderServiceImpl();
        try
        {
            String od = req.getParameter ( "ordercode" );
            Order orderInfo = gms.orderInfo2 ( od );
            req.setAttribute ( "ordercode",orderInfo );

            System.out.println(orderInfo.getId());

            List< Goods_orderdetail > god = gms.goodsimg (orderInfo.getId ( ) );
            req.setAttribute ( "god",god );
            System.out.println (god );

            req.getRequestDispatcher ( "front/page/orderInfo.jsp" ).forward ( req,resp );
        } catch ( Exception e )
        {
            throw new RuntimeException ( e );
        }
    }
}
