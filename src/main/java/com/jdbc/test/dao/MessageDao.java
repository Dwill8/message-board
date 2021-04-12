package com.jdbc.test.dao;

import com.jdbc.test.DBConnection;
import com.jdbc.test.bean.MessageBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    /** 分页查询全部留言
      * @param page 当前页码
      * @param pageSize 每页记录数
      */
    public List<MessageBean> getMessages(int page, int pageSize){
        Connection connection = DBConnection.getConnection();
        String sql = "select * from messages order by create_time desc limit ?, ?";//limit m,n从第m条开始取出n条记录
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<MessageBean> messageBeans = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (page-1) * pageSize);
            preparedStatement.setInt(2, pageSize);
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
