package com.jdbc.test.servlet;
import com.jdbc.test.bean.UserBean;
import com.jdbc.test.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phoneNumber = req.getParameter("phonenumber");
        String address = req.getParameter("address");
        String birthday = req.getParameter("birthday");

        UserBean userBean = userService.register(id,username,password,phoneNumber,address,birthday);
        //注册成功
        if (userBean != null) {
            req.getSession().setAttribute("user", userBean);
            req.getRequestDispatcher("/message/list.do").forward(req, resp);
        } else {
            req.getRequestDispatcher("/register.do").forward(req, resp);
        }
    }

    @Override
    public void destroy(){
        super.destroy();
    }
}
