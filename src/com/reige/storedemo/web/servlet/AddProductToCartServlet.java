package com.reige.storedemo.web.servlet;

import com.reige.storedemo.domain.Product;
import com.reige.storedemo.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by REIGE on 2017/7/7.
 */
public class AddProductToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到商品id
        String id = req.getParameter("id");
        //根据id查询商品
        ProductService productService = new ProductService();
        try {
            Product p = productService.findById(id);
            HttpSession session = req.getSession();
            //从session中获取购物车
            Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
            //如果cart为null 购物车为空 第一次购物
            if (cart == null) {
                cart = new HashMap<>();
            }
            //判断 购物车中是滞有当前要买的商品
            Integer count = cart.get(p);
            if (count == null) {
                count = 1;
            } else {
                count += 1;
            }
//            count = count == null ? 1 : count + 1;
            cart.put(p, count);
            session.setAttribute("cart", cart);
            resp.getWriter().write("添加商品到购物车成功，<a href='http://www.estore.com'>继续购物</a>,<a href='http://locahost:8080/showCart.jsp'>查看购物车</a>");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
