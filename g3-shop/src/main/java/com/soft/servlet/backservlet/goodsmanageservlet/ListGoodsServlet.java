package com.soft.servlet.backservlet.goodsmanageservlet;

import com.alibaba.fastjson.JSON;
import com.soft.entity.Goods;
import com.soft.entity.PageSplitGoods;
import com.soft.service.GoodsManageService;
import com.soft.service.impl.GoodsManageServiceImpl;

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
 * @date : 2024/7/25 10:49
 */

//${pageContext.request.contextPath}

@WebServlet("/managelist")
public class ListGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------listdoget");
        String id = req.getParameter("id");
        System.out.println(id);
        GoodsManageService goodsManageService = new GoodsManageServiceImpl();
        try {
            Goods goods = goodsManageService.updateById(Integer.parseInt(id));
            if (goods.getId()!=null){
                System.out.println("查询成功");
                req.setAttribute("goods",goods);
                req.getRequestDispatcher("back/goodsManageView.jsp").forward(req,resp);
            }else {
                System.out.println("查询失败");
                req.getRequestDispatcher("back/goodsManageList.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 查询分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------listdopost");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        GoodsManageService goodsManageService = new GoodsManageServiceImpl();

        PrintWriter pw = resp.getWriter();
//        登录成功  默认到达第一页
        String currpage = req.getParameter("currpage");
        if(currpage==null){
            currpage="1";
        }
        //     分页处理
        try {

            Integer numpage = Integer.valueOf(currpage);
            int start = 0;
            int psize=5;
            int startindex=(numpage-1)*5;

            int end = startindex+psize;

//            总条数
            int totalcount =  goodsManageService.count();
//           总页数
            int totalpage = totalcount%5==0?totalcount/5:totalcount/5+1;
//            当前跳转页面前  获取列表数据

            List<Goods> list = null;
            list = goodsManageService.list(startindex,psize);

//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
//            }


            PageSplitGoods pageSplit = new PageSplitGoods();
            pageSplit.setList(list);

            pageSplit.setCurrpage(numpage);
            pageSplit.setTotalpage(totalpage);


//            list对象
            String jsonString = JSON.toJSONString(pageSplit);
            System.out.println(jsonString);
            pw.write(jsonString);

//            req.getRequestDispatcher("back/goodsManageList.jsp").forward(req,resp);





        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
