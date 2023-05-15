package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
        //1 获取数据库链接,异常抛出
        Connection conn= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                "root","0726725han");
        System.out.println("连接对象"+conn);
        //2创建执行sql语句的对象
        Statement s=conn.createStatement();
        //3执行sql语句
        s.execute("drop table jdbct1");
        //4关闭资源
        conn.close();
        System.out.println("执行完毕！");


    }
}
