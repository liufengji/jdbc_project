package com.yinggu.demo1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

/**
 * 此类用于演示获取连接的几种方式
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 * 
 * 连接url的格式： jdbc:mysql://主机名:端口号/库名 
 * 注意：如果是本机并且为默认端口号，则可以直接写成：
 *         jdbc:mysql:///库名
 * 
 *
 */
public class TestConnection2 {
	
	// 方式一：
	@Test
	public void test1() throws Exception {
		
		// 1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 2.获取连接
		Connection connection = DriverManager.getConnection("jdbc:mysql:///girls?user=root&password=root");

		System.out.println(connection);

	}

	// 方式二：
	@Test
	public void test2() throws Exception {
		// 1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 2.获取连接
		Connection connection = DriverManager.getConnection("jdbc:mysql:///girls", "root", "root");

		System.out.println(connection);

	}

	// 方式三：
	@Test
	public void test3() throws Exception { 
		// 1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 2.获取连接
		Properties info = new Properties();
		info.load(new FileInputStream("src/db.properties"));
		
		Connection connection = DriverManager.getConnection("jdbc:mysql:///girls", info);

		System.out.println(connection);

	}

	// 方式四：通用的方式
	@Test
	public void test4() throws Exception {

		Properties info = new Properties();
		info.load(new FileInputStream("src/db.properties"));

		String driverClass = info.getProperty("driverClass");
		String url = info.getProperty("url");
		String user = info.getProperty("user");
		String password = info.getProperty("password");

		// 1.加载驱动
		Class.forName(driverClass);

		// 2.获取连接
		Connection connection = DriverManager.getConnection(url, user, password);

		System.out.println(connection);

	}

}
