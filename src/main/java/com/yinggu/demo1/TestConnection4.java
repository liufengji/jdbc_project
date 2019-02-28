package com.yinggu.demo1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.yinggu.utils.JDBCUtils;

/**
 * 此类用于演示访问数据库，执行增删改查操作，使用JDBCUtils
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 *
 */
public class TestConnection4 {

	/*
	 * 执行查询
	 */
	@Test
	public void testQuery() throws Exception {

		// 1.获取连接
		Connection connection = JDBCUtils.getConnection();

		// 2.访问数据库，执行查询
		// 2-1.获取命令对象
		Statement statement = connection.createStatement();

		// 2-2.执行查询
		ResultSet set = statement.executeQuery("select * from beauty");

		// set.afterLast();
		while (set.next()) {
			// 方式一：根据列索引获取该列的值
			int id = set.getInt(1);// 获取该1列的值
			String name = set.getString(2);// 获取该2列的值

			String sex = set.getString("sex");
			// 方式二：根据列名获取该列的值
			int id2 = set.getInt("id");
			String name2 = set.getString("Name");

			// 方式三：根据列名获取该列的值，返回Object类型
			Object id3 = set.getObject("id");
			Object name3 = set.getObject("Name");

			System.out.println(id + "\t" + name + "\t" + sex);
		}

		// 3.关闭连接
		JDBCUtils.closeConnection(set, statement, connection);
	}

	/*
	 * 执行增删改
	 */
	@Test
	public void testUpdate() throws Exception {

		// 1.获取连接
		Connection connection = JDBCUtils.getConnection();

		// 3.访问数据库，执行增删改的操作 ★
		// 3-1. 获取命令对象
		Statement statement = connection.createStatement();

		// 3-2.执行sql命令并返回
		// statement.execute(sql);//执行任何sql语句，返回是否结果为结果集
		// statement.executeQuery(sql);//执行查询语句，返回结果集对象
		int update = statement.executeUpdate("update beauty set sex='女' where name='小明明'");// 执行增删改语句，返回受影响的行数

		// 3-3.处理结果
		System.out.println(update);

		// 4.关闭连接
		JDBCUtils.closeConnection(null, statement, connection);

	}

}
