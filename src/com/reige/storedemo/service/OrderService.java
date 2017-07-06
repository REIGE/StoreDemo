package com.reige.storedemo.service;

import com.reige.storedemo.dao.OrderDao;
import com.reige.storedemo.dao.OrderItemDao;
import com.reige.storedemo.dao.ProductDao;
import com.reige.storedemo.domain.Order;
import com.reige.storedemo.domain.OrderItem;
import com.reige.storedemo.domain.User;
import com.reige.storedemo.utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by REIGE on 2017/7/6.
 */
public class OrderService {
    //添加订单方法
    public void addOrder(Order order){
        OrderDao orderDao = new OrderDao();
        OrderItemDao orderItemDao = new OrderItemDao();
        ProductDao productDao = new ProductDao();

        try {
            DataSourceUtils.startTransaction(DataSourceUtils.getConnectionByTransaction());
            //调用OrderDao完成向orders表中添加数据
            orderDao.addOrder(order);
            //调用OrderItemDao完成对orderItem表中的添加操作
            orderItemDao.addOrderItem(order.getItems());
            //调用ProductDao完成对products表中数量修改操作
            productDao.updatePnum(order.getItems());
        } catch (SQLException e) {
            //事物回滚
            try {
                DataSourceUtils.rollback(DataSourceUtils.getConnectionByTransaction());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            //释放资源,并且事物提交以及从ThreadLocal中移除Connection
            try {
                DataSourceUtils.closeConnection(DataSourceUtils.getConnectionByTransaction());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //根据用户 查询订单
    public List<Order> findOrder(User user) throws SQLException {
        return new OrderDao().findOrder(user);
    }

    //删除订单
    public void delOrderById(String id){
        OrderItemDao orderItemDao = new OrderItemDao();
        OrderDao orderDao = new OrderDao();
        ProductDao productDao = new ProductDao();
        try {
            //开启事物
            DataSourceUtils.startTransaction(DataSourceUtils.getConnectionByTransaction());
            //根据orderId 查询出所有订单
            List<OrderItem> items = orderItemDao.findOrderItemByOrderId(id);
            orderItemDao.delOrderItemByOrderId(id);
            orderDao.delOrderById(id);
            productDao.changePnum(items);
        } catch (SQLException e) {
            try {
                DataSourceUtils.rollback(DataSourceUtils.getConnectionByTransaction());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                DataSourceUtils.closeConnection(DataSourceUtils.getConnectionByTransaction());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
