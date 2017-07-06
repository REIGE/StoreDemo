package com.reige.storedemo.dao;

import java.sql.SQLException;
import java.util.List;

import com.reige.storedemo.domain.OrderItem;
import com.reige.storedemo.domain.Product;
import com.reige.storedemo.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


public class ProductDao {
	// 添加商品
	public void addProduct(Product p) throws SQLException {
		String sql = "insert into products values(?,?,?,?,?,?,?)";

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		runner.update(sql, p.getId(), p.getName(), p.getPrice(),
				p.getCategory(), p.getPnum(), p.getImgurl(), p.getDescription());
	}

	// 查询所有商品
	public List<Product> findAll() throws SQLException {
		String sql = "select * from products";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		return runner.query(sql, new BeanListHandler<Product>(Product.class));
	}

	public Product findById(String id) throws SQLException {
		String sql = "select * from products where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		return runner.query(sql, new BeanHandler<Product>(Product.class), id);
	}

	// 添加订单后，修改商品的数量.
	public void updatePnum(List<OrderItem> items) throws SQLException {
		String sql = "update products set pnum=pnum-? where id=?";

		QueryRunner runner = new QueryRunner();
		Object[][] params = new Object[items.size()][2];

		for (int i = 0; i < items.size(); i++) {
			OrderItem item = items.get(i);
			params[i][0] = item.getBuynum();
			params[i][1] = item.getProduct_id();

		}

		runner.batch(DataSourceUtils.getConnectionByTransaction(), sql, params);
	}

	// 删除订单后，恢复商品的数量
	public void changePnum(List<OrderItem> items) throws SQLException {
		String sql = "update products set pnum=pnum+? where id=?";

		QueryRunner runner = new QueryRunner();
		Object[][] params = new Object[items.size()][2];

		for (int i = 0; i < items.size(); i++) {
			OrderItem item = items.get(i);
			params[i][0] = item.getBuynum();
			params[i][1] = item.getProduct_id();

		}

		runner.batch(DataSourceUtils.getConnectionByTransaction(), sql, params);
	}

	// 下载榜单
	public List<Product> downloadSell() throws SQLException {
		String sql = "select products.name,sum(buynum) totalSaleNum			from					products,orderitem,orders 			where 				orderitem.product_id=products.id			and				orders.id=orderitem.order_id			and				orders.paystate=1			group by				products.name			order by				totalSaleNum desc";
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		return runner.query(sql, new BeanListHandler<Product>(Product.class));
	}

}
