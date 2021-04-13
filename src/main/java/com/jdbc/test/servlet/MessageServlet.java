package com.jdbc.test.servlet;

import com.jdbc.test.bean.MessageBean;
import com.jdbc.test.bean.UserBean;
import com.jdbc.test.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 留言处理servlet
 */
public class MessageServlet extends HttpServlet {


    private MessageService messageService;

    @Override
    public void init() throws ServletException{
        super.init();
        messageService = new MessageService();
    }



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathName = req.getServletPath();
        if(Objects.equals("/leaveMessagePrompt.do",pathName)) {
            req.getRequestDispatcher("/webapp/WEB-INF/leaveMessage.html").forward(req,resp);
    } else if (Objects.equals("/leaveMessage.do", pathName)){
            UserBean user = (UserBean) req.getSession().getAttribute("user");
            if (null == user) {
                req.getRequestDispatcher("/message/list.do").forward(req,resp);
            } else {
                String title = req.getParameter("title");
                String content = req.getParameter("content");
                boolean result = messageService.addMessage(new MessageBean(user.getId(), user.getUsername(), title, content));
                if (result) {
                    req.getRequestDispatcher("/message/list.do").forward(req, resp);
                } else {
                    req.getRequestDispatcher("/webapp/WEB-INF/leaveMessage.html").forward(req, resp);

                }
            }
        } else {
            req.getRequestDispatcher("/message/list.do").forward(req,resp);
        }
    }


}
