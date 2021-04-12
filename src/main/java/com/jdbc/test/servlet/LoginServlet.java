package com.jdbc.test.servlet;

import com.jdbc.test.bean.UserBean;
import com.jdbc.test.dao.UserDao;
import com.jdbc.test.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserBean userBean = userService.login(username, password);
        //登录成功
        if (userBean != null) {
            req.getSession().setAttribute("user", userBean);
            req.getRequestDispatcher("/message/list.do").forward(req, resp);
        } else {
            req.getRequestDispatcher("/login.do").forward(req, resp);
        }
    }

    @Override
    public void destroy(){
        super.destroy();
    }

}
