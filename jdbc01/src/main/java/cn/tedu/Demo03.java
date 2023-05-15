package cn.tedu;

import java.sql.*;

public class Demo03 {
    public static void main(String[] args) throws SQLException {
        //获取链接对象
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                "root","0726725han");
        //创建执行sql语句对象
        Statement s=conn.createStatement();
        //执行插入数据的sql语句
        //s.executeUpdate("insert into emp(name) values('Tom')");
        //执行修改数据的sql语句
        //s.executeUpdate("update emp set name='Jerry' where name='Tom'");
        //执行删除数据的sql语句
       // s.executeUpdate("delete from emp where name='Jerry'");
        //执行查询sql语句
        ResultSet rs=s.executeQuery("select * from emp");
        //遍历结果及对象
        while (rs.next()){//游标往下挪,询问是否有下一条数据
            String name=rs.getString("name");
            double sal=rs.getDouble("sal");
            System.out.println(name+":"+sal);
        }
        conn.close();
        System.out.println("执行完成！");
    }
}
