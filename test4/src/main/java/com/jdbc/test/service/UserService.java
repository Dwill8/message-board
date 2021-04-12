package com.jdbc.test.service;

import com.jdbc.test.bean.UserBean;
import com.jdbc.test.dao.UserDao;

public class UserService {
    private UserDao userDao;
    public UserService() {
        userDao = new UserDao();
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 成功则返回用户bean，失败则返回null
     */
    public UserBean login(String username, String password) {
        return userDao.login(username, password);
    }

    public UserBean register(String id,String username,String password,String phoneNumber,String address,String birthday) {
        return userDao.register(id, username, password, phoneNumber, address, birthday);
    }

}
