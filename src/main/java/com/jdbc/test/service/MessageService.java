package com.jdbc.test.service;
import com.jdbc.test.bean.MessageBean;
import com.jdbc.test.dao.MessageDao;

import java.util.Date;
import java.util.List;

public class MessageService {
    private MessageDao messageDao;
    public MessageService(){
        messageDao = new MessageDao();
    }
    public boolean addMessage(MessageBean messageBean){
        messageBean.setCreateTime(new Date());
        return messageDao.save(messageBean);
    }

    /** 分页查询全部留言
     * @param page 当前页码
     * @param pageSize 每页记录数
     */
    public List<MessageBean> getMessages(int page, int pageSize){
        return messageDao.getMessages(page, pageSize);
    }

        /*
    计算留言数量
     */
    public int countMessages(){
        return messageDao.countMessages();
    }
}
