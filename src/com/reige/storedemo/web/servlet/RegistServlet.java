package com.reige.storedemo.web.servlet;

import com.reige.storedemo.domain.User;
import com.reige.storedemo.exception.RegistException;
import com.reige.storedemo.service.UserService;
import com.reige.storedemo.utils.ActiveCodeUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by REIGE on 2017/7/6.
 */
public class RegistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        //校验验证码
        String checkCode = req.getParameter("checkcode");
        String _checkCode = (String) req.getSession().getAttribute("checkcode_session");
        if (!checkCode.equals(_checkCode)){
            req.setAttribute("regist.message","验证码不正确");
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);
            return;
        }

        // 1.得到所有请求参数，封装到User对象中.
        User user = new User();
        try {
            BeanUtils.populate(user,req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Map<String, String> map = user.validation();
        if (map.size()!=0){
            req.setAttribute("map",map);
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);
            return;
        }
        user.setActivecode(ActiveCodeUtils.getActiveCode());
        UserService service = new UserService();

        try {
            service.regist(user);
            //注册成功
            resp.sendRedirect(req.getContextPath()+"/regist_success.jsp");
        } catch (RegistException e) {
            e.printStackTrace();
            req.setAttribute("regist.message",e.getMessage());
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
