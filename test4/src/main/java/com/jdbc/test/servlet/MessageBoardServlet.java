package com.jdbc.test.servlet;

import com.jdbc.test.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageBoardServlet extends HttpServlet {
    private MessageService messageService;

    @Override
    public void init() throws ServletException{
         super.init();
         messageService = new MessageService();
     }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");//知道当前页码
        int page =1;//页码默认值为1
        if(pageStr != null && (!"".equals(pageStr))){//页码不为空或空字符串
            try{
                page = Integer.parseInt(pageStr);//字符串转为整数
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        messageService.getMessages();//分页查询全部留言
    }


     @Override
    public void destroy(){
        super.destroy();
        messageService = null;
     }

}
