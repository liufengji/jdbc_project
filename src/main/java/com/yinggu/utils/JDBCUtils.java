package com.yinggu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 此类用于演示jdbc的连接的工具类 方法1：获取连接 方法2：关闭资源
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 *
 */
public class JDBCUtils {

	static String driverClass;
	static String url;
	static String user;
	static String password;

	static {
		try {
			// 加载配置文件
			Properties pro = new Properties();
			pro.load(new FileInputStream("src/db.properties"));
			//反射加载读取项目配置文件
			//pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties"));
			// 读取配置文件
			driverClass = pro.getProperty("driverClass");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");

			//加载驱动
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 功能：获取连接
	 * 异常抛就行，可根据自己的方式处理异常
	 * @return 可用的连接对象
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * 功能：关闭资源
	 * 
	 * @param set
	 * @param statement
	 * @param connection
	 * @throws SQLException
	 */
	public static void closeConnection(ResultSet set, Statement statement, Connection connection) throws SQLException {
		if (set != null)
			set.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}

}