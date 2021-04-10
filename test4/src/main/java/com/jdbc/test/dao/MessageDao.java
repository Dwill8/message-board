package com.jdbc.test.dao;

import com.jdbc.test.DBConnection;
import com.jdbc.test.bean.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    public List<Message> getMessages(int page, int pageSize){
        Connection connection = DBConnection.getConnection();
        String sql = "select * from messages order by create_time desc limit ?, ?";//limit m,n从第m条开始取出n条记录
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Message> messages = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (page-1) * pageSize);
            preparedStatement.setInt(2, pageSize);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                messages.add(new Message(resultSet.getLong("id"),resultSet.getLong("user_id"),
                        resultSet.getString("username"),resultSet.getString("title"),
                        resultSet.getString("content"),resultSet.getTimestamp("create_time")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
