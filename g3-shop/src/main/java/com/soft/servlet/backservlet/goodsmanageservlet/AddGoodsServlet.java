package com.soft.servlet.backservlet.goodsmanageservlet;

import com.soft.service.GoodsManageService;
import com.soft.service.impl.GoodsManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author : qwj
 * @version : 1.0
 * @date : 2024/7/25 10:47
 */

@WebServlet("/manageadd")
@MultipartConfig
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println( "AddGoodsServlet");

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //商品名称
        String goodsName = req.getParameter("goodsName");
        System.out.println(goodsName);
        //图片
        Part part= req.getPart("goodsImg");

        String goodsPrice = req.getParameter("goodsPrice");

        //价格
//        double goodsPay = Double.parseDouble(goodsPrice);
        Double goodsPay =Double.valueOf(goodsPrice);
        //简介
        String goodsIntroduce = req.getParameter("goodsIntroduce");
        //时间
        Date credate = new Date();
        //类别
        String className = req.getParameter("className");


        InputStream inputStream = part.getInputStream();
        byte[] bt = new byte[inputStream.available()];
        inputStream.read(bt);

        String serverPath = req.getServletContext().getRealPath("front/img/goods/");

            if(!new File(serverPath).exists()){
            new File(serverPath).mkdir();
        }

        String header = part.getHeader("content-disposition");// XX;XXX;filename="文件名"
        String filename = header.split(";")[2].split("=")[1].replace("\"","");
        //响应到浏览器端
//        ServletOutputStream os = resp.getOutputStream();
//        os.write(bt);
        //输出流
        FileOutputStream fos = new FileOutputStream(serverPath + filename);

        fos.write(bt);




        GoodsManageService goodsManageService = new GoodsManageServiceImpl();
        try {
            int cnt = goodsManageService.add(goodsName, goodsPay, filename, credate, goodsIntroduce, className);
//            int cnt = gms.addProduct("3",13.2,"add.jpg",credate,"aaa","8");

            if (cnt != 0){
                System.out.println("添加成功！");
//                req.getRequestDispatcher("back/goodsManageList.jsp").forward(req,resp);
                resp.sendRedirect("back/goodsManageList.jsp");
            }else {
                System.out.println("添加失败");
//                req.getRequestDispatcher("backstage/toGoodsManageAdd.jsp").forward(req,resp);
                resp.sendRedirect("back/toGoodsManageAdd.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
