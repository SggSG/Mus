package com.util;

import java.sql.*;

public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/tes?useunicuee=true& characterEncoding=utf8"; 
	static String username = "root"; 
	static String password = "123456"; 
	static Connection  conn = null;
	static ResultSet rs = null;
	static PreparedStatement ps =null;
	public static void init(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println("init [SQL椹卞姩绋嬪簭鍒濆鍖栧け璐ワ紒]");
			e.printStackTrace();
		}
	}
	public static int addUpdDel(String sql){
		int i = 0;
		try {
			PreparedStatement ps =  conn.prepareStatement(sql);
			i =  ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql鏁版嵁搴撳鍒犳敼寮傚父");
			e.printStackTrace();
		}
		
		return i;
	}
	public static ResultSet selectSql(String sql){
		try {
			ps =  conn.prepareStatement(sql);
			rs =  ps.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("sql鏁版嵁搴撴煡璇㈠紓甯�");
			e.printStackTrace();
		}
		return rs;
	}
	public static void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql鏁版嵁搴撳叧闂紓甯�");
			e.printStackTrace();
		}
	}
}
