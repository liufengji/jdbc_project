package com.yinggu.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 此类用于演示jdbc c3p0 数据库连接池 的连接的工具类 方法1：获取连接 方法2：关闭资源
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 *
 */
public class JDBCc3p0Utils {
	
	static ComboPooledDataSource cpds;
	
	static {
		// 1.创建连接池对象
		cpds = new ComboPooledDataSource("c3p0config");
	}

	/**
	 * 获取连接
	 * @return 可用的连接对象
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}

	/**
	 * 释放资源
	 * @param set
	 * @param statement
	 * @param connection
	 * @throws Exception
	 */
	public static void closeConnection(ResultSet set, Statement statement, Connection connection) throws Exception {
		if (set != null)
			set.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	}
}