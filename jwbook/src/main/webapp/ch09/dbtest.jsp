<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 Connection conn=null;
 Statement stmt=null;
 ResultSet rs=null;
 
 try {

      Class.forName("com.mysql.cj.jdbc.Driver");

      conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jwbookdb?useSSL=false", "jwbook", "1234");

      //System.out.println("연결됨");
		//mysql8.X
		//conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jwbookdb?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC", "jwbook", "1234");	
		      

      stmt=conn.createStatement();

      

      //insert

      //stmt.executeUpdate("insert into student values('0494077','왕건','컴퓨터공학')");

      

      //update

      //stmt.executeUpdate("update student set dept='electric' where id='1091011'");

      

      //delete

      //stmt.executeUpdate("delete from student where id='0494077'");

      

      

      rs=stmt.executeQuery("select * from student");

      System.out.println("학번\t 이름\t 학과");

      System.out.println("=================================");

      while(rs.next()) {

         System.out.print(rs.getString("id")+"\t");

         System.out.print(rs.getString("username")+"\t");

         System.out.print(rs.getString("univ")+"\n");

      }

      

   }catch(Exception e) {

      e.printStackTrace();

   }finally {

      try {

         if(rs!=null) {

            rs.close();

         }

         if(conn!=null) {

            conn.close();

         }            

      }catch(Exception e) {

         e.printStackTrace();

      }

   }

%>