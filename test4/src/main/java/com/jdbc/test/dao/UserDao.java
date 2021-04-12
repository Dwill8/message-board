package com.jdbc.test.dao;
import com.jdbc.test.DBConnection;
import com.jdbc.test.bean.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 成功则返回用户bean，失败则返回null
     */
    public UserBean login(String username, String password) {
        Connection connection = DBConnection.getConnection();
        String sql ="select * from users where username = ? and password = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserBean userBean = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userBean = new UserBean();
                userBean.setId(resultSet.getLong("id"));
                userBean.setUsername(resultSet.getString("username"));
                userBean.setPassword(resultSet.getString("password"));
                userBean.setPhoneNumber(resultSet.getString("phone number"));
                userBean.setAddress(resultSet.getString("address"));
                userBean.setBirthday(resultSet.getDate("birthday"));
            }
        } catch (SQLException e){
            System.out.println("登录失败。");
            e.printStackTrace();
        } finally {
            DBConnection.release(resultSet,preparedStatement,connection);
        }
        return userBean;
    }

    public UserBean register(String id,String username,String password,String phoneNumber,String address,String birthday) {
        Connection connection = DBConnection.getConnection();
        String sql ="insert users (id,username,password,phonenumber,address,birthday) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserBean userBean = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,phoneNumber);
            preparedStatement.setString(5,address);
            preparedStatement.setString(6,birthday);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userBean = new UserBean();
                userBean.setId(resultSet.getLong("id"));
                userBean.setUsername(resultSet.getString("username"));
                userBean.setPassword(resultSet.getString("password"));
                userBean.setPhoneNumber(resultSet.getString("phone number"));
                userBean.setAddress(resultSet.getString("address"));
                userBean.setBirthday(resultSet.getDate("birthday"));
            }
        } catch (SQLException e){
            System.out.println("注册失败。");
            e.printStackTrace();
        } finally {
            DBConnection.release(resultSet,preparedStatement,connection);
        }
        return userBean;
    }
}
