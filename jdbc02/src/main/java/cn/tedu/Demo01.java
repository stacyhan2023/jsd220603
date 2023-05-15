package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) {
        //获取链接对象
        try (Connection conn=DBUtils.getConn()){
            //创建执行sql语句对象
            Statement s=conn.createStatement();
            //3执行sql语句
            s.execute("create table hero(id int primary key auto_increment,name varchar(20),age int)");

            System.out.println("创建完成！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
