package com.soft.servlet.backservlet.goodsbackservlet;

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
 * @date : 2024/7/27 16:34
 */
@WebServlet("/infoBack")
public class GoodsListInfoBack extends HttpServlet {
    @Override
    protected void doGet ( HttpServletRequest req , HttpServletResponse resp ) throws ServletException, IOException
    {
        this.doPost ( req,resp );
    }

    @Override
    protected void doPost ( HttpServletRequest req , HttpServletResponse resp ) throws ServletException, IOException
    {
        GoodsManagerOrderService gms = new GoodsManagerOrderServiceImpl();
        try
        {
            String od = req.getParameter ( "ordercode" );
            Order orderInfo = gms.orderInfo ( od );
            req.setAttribute ( "ordercode",orderInfo );
            List< Goods_orderdetail > goods = gms.goods ( Integer.valueOf ( od ));
            req.setAttribute ( "goods",goods );
            req.getRequestDispatcher ( "back/orderManageView.jsp" ).forward ( req,resp );
        } catch ( Exception e )
        {
            throw new RuntimeException ( e );
        }
    }
}
