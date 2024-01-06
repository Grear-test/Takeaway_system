package com.gzj.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接工具类
 *
 */
public class DBUtil {
	
	static Connection conn;
	static PreparedStatement pst;
	
	static String driver;
	static String url;
	static String username;
	static String password;
	
	static{
		Properties p = new Properties();
		InputStream input = DBUtil.class.getResourceAsStream("jdbc.properties");
		try {
			p.load(input);
			driver=p.getProperty("jdbc.driver");
			url=p.getProperty("jdbc.url");
			username=p.getProperty("jdbc.username");
			password=p.getProperty("jdbc.password");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				input.close();
				p.clear();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PreparedStatement getPst(String sql){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			pst = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return pst;
	}
	
	public static void close(ResultSet rs){
		try {
			if (rs!=null) rs.close();
			if (pst!=null) pst.close();
			if (conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
