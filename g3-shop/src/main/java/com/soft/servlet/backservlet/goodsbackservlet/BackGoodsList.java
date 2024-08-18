package com.soft.servlet.backservlet.goodsbackservlet;

import com.alibaba.fastjson2.JSON;
import com.soft.entity.Order;
import com.soft.entity.PageSplitOrder;
import com.soft.service.GoodsManagerOrderService;
import com.soft.service.impl.GoodsManagerOrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author : wyq
 * @version : 1.0
 * @date : 2024/7/27 10:53
 */
@WebServlet("/backList")
public class BackGoodsList extends HttpServlet {
    @Override
    protected void doGet ( HttpServletRequest req , HttpServletResponse resp ) throws ServletException, IOException
    {
       this.doPost ( req,resp );
    }

    @Override
    protected void doPost ( HttpServletRequest req , HttpServletResponse resp ) throws ServletException, IOException
    {

        resp.setCharacterEncoding ( "utf-8" );

        PrintWriter pw = resp.getWriter ( );
        GoodsManagerOrderService gms = new GoodsManagerOrderServiceImpl();
        String currpage = req.getParameter ( "currpage" );
        if ( currpage==null ){
            currpage="1";
        }

        try
        {
            Integer numpage = Integer.valueOf ( currpage );
            int start =(numpage-1)*5;
            int end =5;
            int totalCount = gms.backcount ();
            int totalPage=totalCount%5==0?totalCount/5:totalCount/5+1;
            List< Order > backlist=null;
            backlist=gms.listback ( start,end );

            PageSplitOrder pageSplit = new PageSplitOrder( );

            pageSplit.setBackList ( backlist );
            pageSplit.setCurrpage ( numpage );
            pageSplit.setTotalpage ( totalPage );
            String jsonString = JSON.toJSONString ( pageSplit );
            pw.write ( jsonString );

        } catch ( Exception e )
        {
            throw new RuntimeException ( e );
        }

    }
}
