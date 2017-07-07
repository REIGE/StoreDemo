package com.reige.storedemo.web.servlet;

import com.reige.storedemo.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by REIGE on 2017/7/7.
 */
public class ChangeCountServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int count = Integer.parseInt(req.getParameter("count"));
        Map<Product,Integer> cart = (Map<Product, Integer>) req.getSession().getAttribute("cart");

        Product product = new Product();
        product.setId(id);
        if (count==0){
            cart.remove(product);
        }else {
            cart.put(product,count);
        }
        resp.sendRedirect(req.getContextPath()+"/showCart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
