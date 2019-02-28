package com.yinggu.demo8;


import java.sql.Connection;
import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 * 
 * 数据库连接池的引入：
 *  传统模式的连接存在以下不足: 
 *     1.每次连接耗时较长，效率低 
 *     2.每次使用完需要关闭连接，数据库连接对象没有得到重复利用
 *     3.每次使用用完如果不关闭连接，则容易导致内存泄漏 数据库
 *  
 * 连接池的好处： 
 *     1、采用缓冲池的思想，效率提高
 *     2、连接得到重复利用 
 *     3、统一的资源管理和分配
 */

public class Testc3p0DataSource {

	// 使用c3p0方式一
	@Test
	public void testC3P0_1() throws Exception {
		// 1.创建连接池对象
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		// 2.设置连接池的连接参数
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql:///test");
		cpds.setUser("root");
		cpds.setPassword("root");

		// 3.设置连接池的配置参数
		cpds.setInitialPoolSize(5);// 设置池子的初始连接数
		cpds.setMinPoolSize(5);// 设置池子的最少连接数
		cpds.setMaxPoolSize(20);// 设置池子的最大连接数
		cpds.setAcquireIncrement(5);// 设置池子的每次向数据库服务器申请的连接数

		// 4.获取可用连接对象
		Connection connection = cpds.getConnection();

		// 5.使用连接
		System.out.println(connection);

		// 6.关闭连接,仅仅是将连接对象放回池子中，并没有断开和数据库服务器的连接
		connection.close();
	}

	// 使用c3p0方式二
	@Test
	public void testC3P0_2() throws Exception {

		// 1.创建连接池对象  c3p0config 和 c3p0-config.xml  中 named-config 属性name 值一样
		//c3p0-config.xml 文件名 不能改
		//c3p0-config.xml 放到 src 下面 
		ComboPooledDataSource cpds = new ComboPooledDataSource("c3p0config");
		// 2.获取连接
		Connection connection = cpds.getConnection();
		System.out.println(connection);
		// 3.关闭连接
		connection.close();
	}
}