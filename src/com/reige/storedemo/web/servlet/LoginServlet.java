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

/**
 * Created by REIGE on 2017/7/6.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2.校验----作业

        // 3.调用service中登录的方法
        UserService service = new UserService();
        try {
            User user = service.login(username, password);

            // 登录成功

            // 判断是否勾选了记住用户名.
            String remember = req.getParameter("remember");
            if ("on".equals(remember)) {
                // 勾选了--考虑中文问题
                Cookie cookie = new Cookie("remember", URLEncoder.encode(
                        user.getUsername(), "utf-8"));
                cookie.setMaxAge(10 * 24 * 60 * 60);
                cookie.setPath("/");
                resp.addCookie(cookie);
            } else {
                // 如果用户没有勾选记住用户名，将cookie删除。删除cookie，只需要设置maxage=0或-1,注意：要与cookie的path一致.
                Cookie cookie = new Cookie("remember", URLEncoder.encode(
                        user.getUsername(), "utf-8"));
                cookie.setMaxAge(0);
                cookie.setPath("/");
                resp.addCookie(cookie);
            }

            // 自动登录

            String autologin=req.getParameter("autologin");
            if("on".equals(autologin)){
                Cookie cookie = new Cookie("autologin", URLEncoder.encode(
                        user.getUsername(), "utf-8")+"::"+password);
                cookie.setMaxAge(10 * 24 * 60 * 60);
                cookie.setPath("/");
                resp.addCookie(cookie);
            }else{
                Cookie cookie = new Cookie("autologin", URLEncoder.encode(
                        user.getUsername(), "utf-8")+"::"+password);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                resp.addCookie(cookie);
            }


            req.getSession().invalidate();//先销毁session。

            req.getSession().setAttribute("user", user);// 登录成功，将user存储到session中.

            resp.sendRedirect("http://www.estore.com"); // 重定向可以跳转到任意路径,请求转发只能在本站内跳转.
            return;

        } catch (LoginException e) {
            e.printStackTrace();
            req.setAttribute("login.message", e.getMessage());
            req.getRequestDispatcher("/home.jsp")
                    .forward(req, resp);
            return;
        } catch (ActiveCodeException e) {
            e.printStackTrace();
            req.setAttribute("login.message", e.getMessage());
            req.getRequestDispatcher("/home.jsp")
                    .forward(req, resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
