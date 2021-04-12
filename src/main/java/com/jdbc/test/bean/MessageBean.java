package com.jdbc.test.bean;

import java.util.Date;

public class MessageBean {
    private long id;
    private long userId;
    private String userName;
    private String title;
    private String content;
    private Date createTime;

    public MessageBean(long id, long userId, String userName, String title, String content, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() { return userId; }

    public void setUserId(long userId) { this.userId = userId; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
