package com.jdbc.test.bean;

public class Message {
    private long id;
    private String userName;
    private String title;
    private String content;
    private String createTime;
    private String createDate;

    public Message(long id, String userName, String title, String content, String createTime, String createDate) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
