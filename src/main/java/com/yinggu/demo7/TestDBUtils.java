package com.yinggu.demo7;


import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yinggu.bean.ExamStudent;
import com.yinggu.utils.JDBCUtils;

/**
 * 开源框架的使用步骤：
 * 1、导入jar包
 * 2、看API
 * 3、使用
 * 
 * DBUtils的相关API：
 * 一、QueryRunner
 * query
 * 		connection
 * 		sql
 * 		ResultSetHandler
 * 		objects
 * update
 * 		connection
 * 		sql
 * 		objects
 * 
 * 二、ResultSetHandler接口
 * 	实现类：
 * 	BeanHandler 将结果集数据转换成一个对象
 * 	BeanListHandler 将结果集数据转换成list集合
 * 	ScalarHandler 将将结果集数据的 第一行第一列转换成对象返回
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 * 
 */

public class TestDBUtils {
	
	QueryRunner qr;
	Connection connection;

	@Before
	public void testBefore() throws Exception {
		// 1.创建QueryRunner对象
		qr = new QueryRunner();
		connection = JDBCUtils.getConnection();
	}

	// 测试query方法3
	//返回 获取单个值
	@Test
	public void testScalar() throws Exception {
		Object query = qr.query(connection, "select name from users where id=?", new ScalarHandler(),2);
		System.out.println(query);
	}

	// 测试query方法2  返回一个集合
	@Test
	public void testQueryList() throws Exception {

		List<ExamStudent> list = qr.query(connection, "select * from examstudent where flowid>?",
				new BeanListHandler<ExamStudent>(ExamStudent.class), 2);

		for (ExamStudent examStudent : list) {
			System.out.println(examStudent);
		}
	}

	// 测试query方法1  BeanHandler 返回一个对象
	@Test
	public void testQueryBean() throws Exception {

		ExamStudent account = qr.query(connection, "select * from examstudent where flowid=?",
				new BeanHandler<ExamStudent>(ExamStudent.class), 1);
		System.out.println(account);
	}

	// 测试update方法
	@Test
	public void testUpdate() throws Exception {
		// 调用update
		int update = qr.update(connection, "update account set username=? where id=?", "张无忌", 1);
		System.out.println(update > 0 ? "success" : "failure");
	}

	@After
	public void testAfter() throws Exception {
		JDBCUtils.closeConnection(null, null, connection);
	}

}