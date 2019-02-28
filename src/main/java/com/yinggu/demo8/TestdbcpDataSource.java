package com.yinggu.demo8;

import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

/**
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 * 
 *     数据库连接池的引入： 传统模式的连接存在以下不足: 
 *     1.每次连接耗时较长，效率低 
 *     2.每次使用完需要关闭连接，数据库连接对象没有得到重复利用
 *     3.每次使用用完如果不关闭连接，则容易导致内存泄漏 数据库
 * 
 *     连接池的好处： 
 *     1、采用缓冲池的思想，效率提高 
 *     2、连接得到重复利用 3、统一的资源管理和分配
 */
public class TestdbcpDataSource {

	// 使用dpcp方式一
	@Test
	public void testDBCP_1() throws Exception {

		// 1.创建连接池对象
		BasicDataSource bds = new BasicDataSource();
		
		// 2.设置连接参数
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/test");
		bds.setUsername("root");
		bds.setPassword("root");

		// 3.设置配置参数
		bds.setInitialSize(5);// 初始连接数
		bds.setMinIdle(3);// 最小空闲连接数
		bds.setMaxIdle(10);// 最大空闲连接数

		// 4.获取连接
		Connection connection = bds.getConnection();

		System.out.println(connection);

		// 5.关闭连接，仅仅放回连接池中，并没有断开和数据库的连接
		connection.close();

	}

	// 使用dpcp方式二
	@Test  
	public void testDBCP_2() throws Exception {

		Properties pro = new Properties();
		pro.load(this.getClass().getClassLoader().getResourceAsStream("dbcp.properties"));

		// 1.创建连接池对象
		BasicDataSource bds = (BasicDataSource) BasicDataSourceFactory.createDataSource(pro);

		// 2.获取连接
		Connection connection = bds.getConnection();
		System.out.println(connection);
		// 3.关闭连接
		connection.close();
	}

}
