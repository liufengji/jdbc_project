package com.yinggu.demo5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.junit.Test;
import com.yinggu.utils.JDBCUtils;

/**
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 * 
 * 批处理 情况：
 *  一、多条sql语句的批量处理 适用于 sql语句各不一样，使用Statement命令对象执行 
 *  二、一条sql语句的批量传参
 * 适用于sql语句一样，仅仅是参数不同，使用PreparedStatement命令对象指向
 * 相关API 
 *  addBatch:添加命令到批处理包
 *  executeBatch：提交批处理包
 *  clearBatch：清空批处理包
 * 
 * 好处： 减少和数据库服务器连接的次数，减少执行的次数，提高效率
 */

public class TestBatch {
	
	// 使用了批处理
	// （1）使用批处理,首先选对驱动包，5.1.37是可以的，5.1.7 是不可以的
	// jar包不同，批处理支持的程度不同
	// （2）开启批处理
	//  #url=jdbc:mysql:///orcl?rewriteBatchedStatements=true&useServerPrepStmts=false
	@Test
	public void testUseBatch() throws Exception {

		// 1.获取连接
		Connection connection = JDBCUtils.getConnection();

		// 2.访问数据库
		PreparedStatement statement = connection.prepareStatement("insert into admin values(null,?,?)");
		for (int i = 1; i < 50000; i++) {
			statement.setString(1, "小花" + i);
			statement.setString(2, "8888");
			// 批处理
			statement.addBatch();// 将要执行的sql语句添加到批处理包（装篮子的操作）
			if (i % 1000 == 0) {
				statement.executeBatch();// 提交批处理的命令们（上楼运篮子的操作）
				statement.clearBatch();// 清空批处理包（卸篮子的操作）
			} else if (i > 49000) {
				statement.executeBatch();// 提交批处理的命令们（上楼运篮子的操作）
				statement.clearBatch();// 清空批处理包（卸篮子的操作）
			}
		}
		// 3.关闭
		JDBCUtils.closeConnection(null, statement, connection);
	}

	//没有使用批处理
	//select count(*) from admin;
	//truncate table admin;
	//mysql 数据库检查 插入速度
	@SuppressWarnings("unused")
	@Test
	public void testNoBatch() throws Exception {

		// 1.获取连接
		Connection connection = JDBCUtils.getConnection();

		// 2.访问数据库
		PreparedStatement statement = connection.prepareStatement("insert into admin values(null,?,?)");

		for (int i = 1; i <= 50000; i++) {
			statement.setString(1, "小花" + i);
			statement.setString(2, "0000");
			int update = statement.executeUpdate();
		}

		// 3.关闭
		JDBCUtils.closeConnection(null, statement, connection);
	}
}
