package com.jdbc.test.dao;

import com.jdbc.test.bean.User;

public class UserDao {
    public User login(String username, String password) {
        String sql ="select * from users where username = ? and password = ?";
    }
}
