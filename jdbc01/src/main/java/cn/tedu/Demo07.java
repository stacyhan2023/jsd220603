package cn.tedu;

import java.sql.*;
import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();

        try ( Connection conn=DBUtils.getConn()){
           /* Statement s=conn.createStatement();
            String sql="select count(*) from user where username='"+username+"'and password='"+password+"'";
            System.out.println(sql);
            ResultSet rs=s.executeQuery(sql);*/
            //通过preparedstatement对象解决sql注入的问题
            String sql="select count(*) from user where username=? and password=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            /*把？替换成用户名和密码*/
            ps.setString(1,username);
            ps.setString(2,password);
            /*执行sql语句*/
            ResultSet rs=ps.executeQuery();

            /*让游标往下移动 指向返回的数据*/
            rs.next();
            /*取出查询到的数量 1代表查询到的位置*/
            int count=rs.getInt(1);
            if(count>0){
                System.out.println("登陆成功！");
            }else{
                System.out.println("用户名或者密码错误！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
