package com.reige.storedemo.dao;

import java.sql.SQLException;
import java.util.List;

import com.reige.storedemo.domain.Order;
import com.reige.storedemo.domain.User;
import com.reige.storedemo.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;



public class OrderDao {
	// 添加订单
	public void addOrder(Order order) throws SQLException {
		String sql = "insert into orders values(?,?,?,?,null,?)";

		QueryRunner runner = new QueryRunner(); // 手动事务

		runner.update(DataSourceUtils.getConnectionByTransaction(), sql,
				order.getId(), order.getMoney(), order.getReceiverinfo(),
				order.getPaystate(), order.getUser_id());
	}

	// 根据用户的角色来查询订单
	public List<Order> findOrder(User user) throws SQLException {

		String sql = "select users.username,users.nickname,orders.* from orders,users where users.id=orders.user_id ";
		if ("user".equals(user.getRole())) {
			sql += " and user_id=" + user.getId();
		}
		sql += " order by user_id,ordertime";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Order>(Order.class));
	}

	// 根据id删除订单
	public void delOrderById(String id) throws SQLException {
		String sql = "delete from orders where id=?";
		QueryRunner runner = new QueryRunner();
		runner.update(DataSourceUtils.getConnectionByTransaction(), sql, id);
	}

}
