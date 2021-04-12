package com.jdbc.test;
import java.sql.*;

public final class DBConnection {
    private DBConnection(){}
    //数据库url，username，password
    static final String JDBC_url = "jdbc:mysql://localhost:3306/test4";
    static final String JDBC_user = "root";
    static final String JDBC_password = "123456789";

    static {
        try {//1.注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到驱动程序类，驱动加载失败");
        }
    }



    public static Connection getConnection() {
        try {
            //2.创建数据库连接
            return DriverManager.getConnection(JDBC_url, JDBC_user, JDBC_password);
        } catch (SQLException e) {
            System.out.println("创建数据库连接失败");
            e.printStackTrace();
            return null;
        }
    }

    public static void release(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection) {
        //按resultset,statement,connection逐级try catch,不管有没有报错都执行下去。
        try {
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                try{
                    if(connection != null){
                        connection.close();
                    }
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    /*
            //3.操作数据库
            String sql = "select * from students";//定义数据库语句
            PreparedStatement preparedStatement = Connection.prepareStatement(sql);//创建操作数据库的对象
            //preparedStatement.setObject();//注意索引从1开始

            ResultSet resultSet = preparedStatement.executeQuery();//执行数据库语句获取结果集


            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getNString("name");

                System.out.println("id" + id);
                System.out.println("姓名" + name);
            }

            //4.关闭结果集，数据库操作对象，数据库连接
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        }

     */

}
