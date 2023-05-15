package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo05 {
    public static void main(String[] args) {
        try ( Connection conn=DBUtils.getConn()){
            Statement s= conn.createStatement();
            ResultSet rs=s.executeQuery("select name,age from hero");
            //遍历所有name，age
            while(rs.next()){
                String name= rs.getString("name");
                int age=rs.getInt("age");
                System.out.println(name+":"+age);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
