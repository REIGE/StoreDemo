package com.reige.storedemo.service;


import com.reige.storedemo.dao.UserDao;
import com.reige.storedemo.domain.User;
import com.reige.storedemo.exception.ActiveCodeException;
import com.reige.storedemo.exception.RegistException;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class UserService {
    public void regist(User user) throws RegistException {
        UserDao dao = new UserDao();
        try {
            dao.addUser(user);
            // TODO: 2017/7/6 发送激活邮件

            String emailMsg = "注册成功，请<a href='http://locahost:8080/activeUser?activeCode="
                    + user.getActivecode()
                    + "'>激活</a>,激活码为:"
                    + user.getActivecode();
//            MailUtils.sendMail(user.getEmail(), emailMsg);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RegistException("注册失败");
        }
    }

    //用户激活操作
    public void activeUser(String activeCode) throws SQLException {
        UserDao dao = new UserDao();
        User user = dao.findUserByActiveCode(activeCode);
        if (user != null) {
            dao.activeUser(activeCode);
        } else {
            throw new ActiveCodeException("用户不存在");
        }
    }

    //登陆操作
    public User login(String username, String password) throws LoginException {
        UserDao dao = new UserDao();
        try {
            User user = dao.findUserByLogin(username, password);
            if (user != null) {
                if (user.getState() == 1) {
                    return user;
                } else {
                    throw new LoginException("用户未激活");
                }
            } else {
                throw new LoginException("用户名或密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("用户名或密码错误");
        }
    }
}
