package com.jdbc.test.servlet;
import com.jdbc.test.bean.MessageBean;
import com.jdbc.test.service.MessageService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        List<MessageBean> messages = messageService.getMessages(page, 5);//分页查询全部留言
        int count = messageService.countMessages();
        int last = count % 5 == 0 ? (count / 5) : ((count / 5) + 1);
        req.setAttribute("last", last);
        req.setAttribute("messages",messages);
        req.setAttribute("page", page);
        req.getRequestDispatcher("src / main / webapp / index.jsp").forward(req,resp);
    }


     @Override
    public void destroy(){
        super.destroy();
        messageService = null;
     }

}
