package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        //获取链接对象
        try ( Connection conn=DBUtils.getConn()){
        //创建执行sql语句对象
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery("select name from emp");
            //遍历结果集对象
            while(rs.next()){
                String name=rs.getString("name");
                System.out.println(name);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
