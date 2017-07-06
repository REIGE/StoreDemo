package com.reige.storedemo.web.filter;

import com.reige.storedemo.domain.User;
import com.reige.storedemo.service.UserService;
import com.reige.storedemo.utils.CookieUtils;

import java.io.IOException;
import java.net.URLDecoder;

import javax.security.auth.login.LoginException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AutoLoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // 处理自动登录
        // 1.如果用户已经登录不需要自动登录
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user == null) {
            // 没有登录，进行自动登录
            // 2.判断访问的资源路径，例如登录，注册不需要进行自动登录
            String uri = httpServletRequest.getRequestURI();
            String contextPath = httpServletRequest.getContextPath();
            String path = uri.substring(contextPath.length());
            if (!("/regist".equals(path) || "/regist.jsp".equals(path)
                    || "/login.jsp".equals(path) || "/logout".equals(path))) {

                // 3.得到Cookie
                Cookie cookie = CookieUtils.findCookieByName(
                        httpServletRequest.getCookies(), "autologin");
                if (cookie != null) {

                    // 有cookie，进行登录操作.
                    String username = URLDecoder.decode(cookie.getValue()
                            .split("::")[0], "utf-8");
                    String password = cookie.getValue().split("::")[1];

                    UserService service = new UserService();
                    try {
                        User u = service.login(username, password);
                        if (u != null) {
                            httpServletRequest.getSession().setAttribute(
                                    "user", u);// 进行自动登录.
                        }
                    } catch (LoginException e) {
                        e.printStackTrace();
                    }

                }

            }
        }

        // 放行
        chain.doFilter(httpServletRequest, httpServletResponse);
    }

    public void destroy() {

    }

}
