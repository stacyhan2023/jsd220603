package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) {
        //获取链接对象
        try (Connection conn=DBUtils.getConn()){
            //创建执行sql语句对象
            Statement s=conn.createStatement();
            //3执行sql语句
            s.executeUpdate("insert into hero values(null,'孙悟空',500),(null,'猪八戒',300)");
            System.out.println("插入数据完成");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
