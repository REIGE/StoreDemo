package com.reige.storedemo.dao;

import com.reige.storedemo.domain.User;
import com.reige.storedemo.utils.DataSourceUtils;
import com.reige.storedemo.utils.Md5Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;

import java.sql.SQLException;

/**
 * Created by REIGE on 2017/7/6.
 */
public class UserDao {

    /**
     * 用户注册
     * @param user
     * @throws SQLException
     */
    public void addUser(User user) throws SQLException {
        String sql = "insert into users values(null,?,?,?,?,?,?,?,null)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql,user.getUsername(),
                Md5Utils.md5(user.getPassword()),
                user.getNickname(),
                user.getEmail(),
                "user",
                0,
                user.getActivecode());
    }
    //查找用户， 根据激活码
    public User findUserByActiveCode(String activeCode) throws SQLException {
        String sql = "select * from users where activecode = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class),activeCode);
    }

    //激活用户
    public void activeUser(String activeCode) throws SQLException {
        String sql = "update users set state = 1 where activecode = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql,activeCode);
    }

    //登陆操作
    public User findUserByLogin(String username,String password) throws SQLException {
        String sql = "select * from users where username=? and password=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanHandler<User>(User.class),username,Md5Utils.md5(password));
    }

}
