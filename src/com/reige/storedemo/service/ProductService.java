package com.reige.storedemo.service;

import com.reige.storedemo.dao.ProductDao;
import com.reige.storedemo.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by REIGE on 2017/7/6.
 */
public class ProductService {

    //添加商品
    public void addProduct(Product p) throws SQLException {
        new ProductDao().addProduct(p);
    }

    //查询所有商品
    public List<Product> findAll () throws SQLException {
        return new ProductDao().findAll();
    }

    //根据id查询商品
    public Product findById(String id) throws SQLException {
        return new ProductDao().findById(id);
    }

    //下载榜单数据
    public List<Product> downloadSell() throws SQLException {
        return new ProductDao().downloadSell();
    }

}
