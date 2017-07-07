package com.reige.storedemo.web.servlet;

import com.reige.storedemo.domain.User;
import com.reige.storedemo.exception.ActiveCodeException;
import com.reige.storedemo.service.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

/**
 * Created by REIGE on 2017/7/6.
 */
public class ActiveUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String activeCode = req.getParameter("activeCode");
        UserService service = new UserService();

        try {
            service.activeUser(activeCode);
            resp.getWriter().write("激活成功，请回<a href='http://www.estore.com'>首页</a>");
        } catch (SQLException e) {
            throw new ActiveCodeException();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
