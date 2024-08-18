package com.soft.servlet.frontservlet.goodsorderservlet;

import com.soft.entity.Member;
import com.soft.entity.Order;
import com.soft.service.GoodsManagerOrderService;
import com.soft.service.impl.GoodsManagerOrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : wyq
 * @version : 1.0
 * @date : 2024/7/25 11:36
 */
@WebServlet("/list")
public class GoodsListServlet extends HttpServlet {
    @Override
    protected void doGet ( HttpServletRequest req , HttpServletResponse resp ) throws ServletException, IOException {
        GoodsManagerOrderService gms = new GoodsManagerOrderServiceImpl();
        String currpage = req.getParameter ( "currpage" );
        if ( currpage==null ){
            currpage="1";
        }
        try
        {
            HttpSession session = req.getSession();
            Member userinfo = (Member)session.getAttribute("userinfo");
            Integer memberid = userinfo.getId();


            Integer numpage = Integer.valueOf ( currpage );
            int start =(numpage-1)*5;
            int end =5;
            int totalCount = gms.count(memberid);
            int totalPage=totalCount%5==0?totalCount/5:totalCount/5+1;
            List< Order > list=null;
            list=gms.list ( memberid,start,end );

            req.setAttribute ( "list",list );
            req.setAttribute ( "currpage",currpage );
            req.setAttribute ( "totalpage",totalPage );

            req.getRequestDispatcher ( "front/page/orderList.jsp" ).forward ( req,resp );
        } catch ( Exception e )
        {
            throw new RuntimeException ( e );
        }

    }

    @Override
    protected void doPost ( HttpServletRequest req , HttpServletResponse resp ) throws ServletException, IOException {
        GoodsManagerOrderService gms = new GoodsManagerOrderServiceImpl();
        req.setCharacterEncoding("utf-8");
        String ordercode = req.getParameter("ordercode");
        String username = req.getParameter("username");
        try
        {
            Order order = gms.find ( ordercode , username );
            if ( order.getId ()!=null ){
                Order a = gms.findOrder ( order.getId ( ) );
                ArrayList< Order > list = new ArrayList<> ( );
                list.add ( a );
                req.setAttribute ( "list",list );
            }
            req.getRequestDispatcher ( "front/page/orderList.jsp" ).forward ( req,resp );
        } catch ( Exception e )
        {
            throw new RuntimeException ( e );
        }
    }
}
