package com.yinggu.demo1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 * 
 * 此类用于演示JDBC的实现步骤
 * 前提工作：
 * ①将mysql-connector-java-5.1.37-bin.jar复制到项目根目录下
 * ②右击——build path——add to build path
 * 
 * 
 * 步骤： 
 * 1、加载驱动（注册驱动）
 * 方式一：静态加载
 * 方式二：动态加载 【建议】
 * 
 *  静态加载的不足：
 *             ① 依赖性太强，如果没有mysql驱动jar包 代码报错
 *             ② （查看源码）导致 Driver类new了两遍，效率较低 
 *
 */
public class TestConnection1 {

	@Test
	public void testConnection() throws SQLException, ClassNotFoundException{
		
		//1.加载驱动
		//方式一 静态加载
        DriverManager.registerDriver(new Driver());
		
		//方式二 动态加载
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.创建并获取连接
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/girls","root","root");
		
		//3.访问数据库的数据 -  对数据库的操作
		//3-1 获取执行sql语句的命令对象
		Statement statement = connection.createStatement();
		
		//3-2 执行
		int update = statement.executeUpdate("insert into admin(username,password) values('rose','000')");
		
		//3-3 处理结果
		System.out.println(update>0?"执行成功":"执行失败");
		
		//4.关闭连接
		connection.close();
		
	}
}
