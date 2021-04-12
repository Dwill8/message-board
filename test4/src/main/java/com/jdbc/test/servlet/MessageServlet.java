package com.jdbc.test.servlet;

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
        if(Objects.equals("/leaveMessage.do",pathName)) {
    } else {
            req.getRequestDispatcher("/message/list.do").forward(req,resp);
        }
    }
}
