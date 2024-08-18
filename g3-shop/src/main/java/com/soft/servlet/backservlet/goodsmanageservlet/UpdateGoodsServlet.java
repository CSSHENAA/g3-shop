package com.soft.servlet.backservlet.goodsmanageservlet;

import com.soft.entity.Goods;
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


/**
 * @author : qwj
 * @version : 1.0
 * @date : 2024/7/25 10:48
 */
@WebServlet("/manageupdate")
@MultipartConfig
public class UpdateGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(1111);
        String id = req.getParameter("id");
//        System.out.println(id);
        GoodsManageService goodsManageService = new GoodsManageServiceImpl();
        try {
            Goods goods = goodsManageService.updateById(Integer.valueOf(id));
            System.out.println("======="+goods);
            if(goods.getId()!=null){
                req.setAttribute("goods",goods);
                req.getRequestDispatcher("back/toGoodsManageEdit.jsp").forward(req,resp);
            }else {
                req.getRequestDispatcher("back/toGoodsManageList.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(2222);
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String id = req.getParameter("gid");
        System.out.println(id);
        int i = Integer.parseInt(id);
        String goodsname = req.getParameter("goodsname");

        Part picture = req.getPart("picture");

        String price = req.getParameter("price");
        Double aDouble = Double.valueOf(price);

        String introduce = req.getParameter("introduce");
        InputStream inputStream = picture.getInputStream();
        byte[] bt = new byte[inputStream.available()];
        inputStream.read(bt);

//        文件上传路径
        String serverPath = req.getServletContext().getRealPath("front/img/goods/");

//        没有文件夹创建
        if(!new File(serverPath).exists()){
            new File(serverPath).mkdir();
        }

        String header = picture.getHeader("content-disposition");// XX;XXX;filename="文件名"
        String filename = header.split(";")[2].split("=")[1].replace("\"","");
        //响应到浏览器端
//        ServletOutputStream os = resp.getOutputStream();
//        os.write(bt);
        //输出流
        FileOutputStream fos = new FileOutputStream(serverPath + filename);

        fos.write(bt);


        GoodsManageService goodsManageService = new GoodsManageServiceImpl();

        try {
//            只上传照片的名字
            int cnt = goodsManageService.update(i, goodsname, aDouble,filename, introduce);
            if(cnt!=0){
                System.out.println("fteadfeda");
//                req.setAttribute("mag","修改成功");
//                再次查询页面
//                req.getRequestDispatcher("back/goodsManageList.jsp").forward(req,resp);
                resp.sendRedirect("back/goodsManageList.jsp");
            }else {
                  System.out.println("修改失败");
//                req.setAttribute("msg","修改失败");
//                req.getRequestDispatcher("back/toGoodsManageEdit.jsp").forward(req,resp);
                  resp.sendRedirect("back/toGoodsManageEdit.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
