package com.shsxt.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库的 获取链接 及 释放资源
 * @author Administrator
 *
 */
public class DBUtil {
	private static Properties pro =new Properties();
	static{
		try {
			pro.load(Thread.currentThread().getContextClassLoader().
					getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			pro =null;
		}
	}
	/**
	 * 获取链接  (c3p0)
	 * 1、放入jar 到lib
	 * 2、使用配置文件 
	 * 3、加载驱动
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		if(null==pro){
			return null;
		}
		//加载驱动
		Class.forName(pro.getProperty("jdbcName"));
		//获取链接
		return DriverManager.getConnection(pro.getProperty("dbUrl"), pro.getProperty("dbUserName"), pro.getProperty("dbPassword"));
	}
	
	/**
	 * 释放资源	
	 */
	public static void release(Connection conn,Statement stmt,ResultSet rs ){
		try {
			if (null != rs) {
				rs.close();
			} 
		} catch (Exception e) {
		}
		try {
			if (null != stmt) {
				stmt.close();
			} 
		} catch (Exception e) {
		}
		
		//放入连接池管理 
		try {
			if (null != conn) {
				conn.close();
			} 
		} catch (Exception e) {
		}
		
	}
	
	public static void release(Connection conn,Statement stmt ){
		release(conn, stmt, null);
	}
	

}
