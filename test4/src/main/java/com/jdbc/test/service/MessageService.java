package com.jdbc.test.service;
import com.jdbc.test.bean.Message;
import com.jdbc.test.dao.MessageDao;

import java.util.List;

public class MessageService {
    private MessageDao messageDao;
    public MessageService(){
        messageDao = new MessageDao();
    }
    public List<Message> getMessages(){
        return null;
    }
}
