package com.reige.storedemo.web.servlet;

import com.reige.storedemo.domain.Order;
import com.reige.storedemo.domain.OrderItem;
import com.reige.storedemo.domain.Product;
import com.reige.storedemo.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by REIGE on 2017/7/7.
 */
public class AddOrderServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        try {
            //得到所有的请求参数 封装到bean
            BeanUtils.populate(order,req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        String uuid = UUID.randomUUID().toString();
        order.setId(uuid);
        order.setPaystate(0);

        //设置订单所属用户
        User user = (User) req.getSession().getAttribute("user");
        int id = user.getId();
        order.setUser_id(id);

        //将订单中所有的订单项信息封装

        List<OrderItem> items = new ArrayList<>();
        @SuppressWarnings("unchecked")
        Map<Product, Integer> cart = (Map<Product, Integer>) req.getSession().getAttribute("cart");
        //遍历购物车
        for (Product p : cart.keySet()) {
            OrderItem item = new OrderItem(); //创建一个订单项

            item.setOrder_id(order.getId()); //向订单项中封装当前订单编号
            item.setProduct_id(p.getId()); //封装订单项中商品id
            item.setBuynum(cart.get(p));//封装订单项中的商品数量

            items.add(item);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
