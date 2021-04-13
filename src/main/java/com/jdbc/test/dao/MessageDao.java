package com.jdbc.test.dao;

import com.jdbc.test.DBConnection;
import com.jdbc.test.bean.MessageBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 保存留言信息
 *
 */
public class MessageDao {
    public boolean save(MessageBean messageBean){
        Connection connection = DBConnection.getConnection();
        String sql = "insert into messages(user_id, username, title, content, create time) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, messageBean.getUserId());
            preparedStatement.setString(2, messageBean.getUserName());
            preparedStatement.setString(3, messageBean.getTitle());
            preparedStatement.setString(4, messageBean.getContent());
            preparedStatement.setTimestamp(5, new Timestamp(messageBean.getCreateTime().getTime()));
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("保存留言信息失败。");
            e.printStackTrace();
            return false;
        } finally {
            DBConnection.release(null,preparedStatement,connection);
        }
        return true;
    }

    /** 分页查询全部留言
      * @param page 当前页码
      * @param pageSize 每页记录数
      */
    public List<MessageBean> getMessages(int page, int pageSize){
        Connection connection = DBConnection.getConnection();
        String sql = "select * from messages order by create_time desc limit ? offset ?";//limit m,n从第m条开始取出n条记录
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<MessageBean> messageBeans = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pageSize);
            preparedStatement.setInt(2, (page - 1) * pageSize);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                messageBeans.add(new MessageBean(resultSet.getLong("id"),resultSet.getLong("user_id"),
                        resultSet.getString("username"),resultSet.getString("title"),
                        resultSet.getString("content"),resultSet.getTimestamp("create_time")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return messageBeans;
    }

    /*
    计算留言数量
     */
    public int countMessages(){
        Connection connection = DBConnection.getConnection();
        String sql = "select count(*) total from messages";//获取共多少条消息
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getInt("total");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBConnection.release(resultSet,preparedStatement,connection);
        }
        return 0;

    }
}
