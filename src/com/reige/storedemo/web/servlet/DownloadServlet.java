package com.reige.storedemo.web.servlet;

import com.reige.storedemo.domain.Product;
import com.reige.storedemo.service.ProductService;
import com.reige.storedemo.utils.DownloadUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by REIGE on 2017/7/7.
 */
public class DownloadServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        try {
            List<Product> products = productService.downloadSell();
            String filename = "销售榜单"+new Date().toLocaleString()+".csv";
            resp.setContentType(this.getServletContext().getMimeType(filename));

            resp.setHeader("content-disposition","attachment;filename="+
                    DownloadUtils.getDownloadFileName(req.getHeader("user-agent"),filename));
            //设置相应编码 因为我们要返回的csv文件要使用excel 他默认的编码是gbk
            resp.setCharacterEncoding("gbk");
            PrintWriter out = resp.getWriter();
            out.println("产品名称,商品数量");
            for (Product p :products){
                out.println(p.getName()+","+p.getTotalSaleNum());
                out.flush();
            }
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
