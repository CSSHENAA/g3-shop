package com.soft.servlet.frontservlet.goodscarservlet;

import com.soft.entity.GoodsCar;
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
import java.util.Date;
import java.util.List;

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/27 19:49
 */
@WebServlet({"/order"})
public class GoodsCarOrderServlet extends HttpServlet {
    String ids = null;
    String totalPrice=null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // System.out.println("dopost");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");//收件人姓名
        String tel = req.getParameter("tel");//电话
        String pro = req.getParameter("provinceName");
        String city = req.getParameter("cityName");
        String contry = req.getParameter("countyName");
        String address = req.getParameter("address");//详细地址
        String postcodes = req.getParameter("postcode");//邮政编码

        int postcode = Integer.parseInt(postcodes);
        String payName = req.getParameter("payName");
        String carryName = req.getParameter("carryName");
        String bz = req.getParameter("bz");//备注
        // 组合完整的地址
        String fullAddress = pro + " " + city + " " + contry + " " + address;
        //下单时间
        Date date = new Date();
        //订单编号
        long time = date.getTime();
        String ordercode = String.valueOf(time);
        //执行
        String enforce = "0";

        HttpSession session = req.getSession();
        Member userinfo = (Member)session.getAttribute("userinfo");
        Integer memberid = userinfo.getId();

        GoodsCarService goodsCarService = new GoodsCarServiceImpl();
       // System.out.println(ids+"=================");
        try {
            //购物车选购商品
            List<GoodsCar> goodsCar = goodsCarService.findGoodsCar(ids);
            //种类数
            int bnumber = goodsCar.size();
            System.out.println(bnumber);
            //总金额
            double allprice= Double.parseDouble(totalPrice);

            //添加订单
            goodsCarService.addOrder(memberid,ordercode,bnumber,username,fullAddress,postcode,tel,payName,carryName,date,enforce,bz,allprice);
            //根据订单号查询订单id
            int orderId = goodsCarService.findOrderCode(ordercode);
            int cnt = goodsCarService.addOrderDetail(orderId, ids);


            //删除购物车信息
            int i = goodsCarService.deleteGoodsCar(memberid, ids);
            System.out.println("删除了"+i+"条数据");

            if (cnt!=0){
                System.out.println("订单添加成功");
                req.getRequestDispatcher("list").forward(req,resp);
            }else {
                System.out.println("订单失败");
                req.getRequestDispatcher("front/page/newOrder.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         ids = req.getParameter("ids");
        totalPrice = req.getParameter("totalPrice");

//        System.out.println("====="+ids+totalPrice);

        req.getRequestDispatcher("front/page/newOrder.jsp").forward(req,resp);

    }
}