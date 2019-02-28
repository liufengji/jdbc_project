package com.yinggu.demo6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.yinggu.utils.JDBCUtils;
import com.yinggu.utils.MyCRUDUtils;

/**
 * 此类用于演示事务
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 * 
 * 场景： Account: 张三丰 1000 郭襄 1000 转账：张三丰给郭襄转账 500
 * 
 *         事务的使用步骤： 1.取消自动提交 set autocommit=0;
 * 
 *         2.开启事务【可选】 start transaction
 * 
 *         3.事务的操作
 * 
 *         4.提交或回滚 commit或rollback
 * 
 *         注意： 开启事务的连接对象和事务执行语句的连接对象必须是同一个！！！！
 */
public class TestTransaction {

	// 使用事务2
	/**
	 * 明明开始 事务， 却没有达到事务数据的一直性 原因是，使用工具类，开始连接事务的连接和执行语句的连接不是一个连接
	 */
	@Test
	public void testUseTransaction2() {
		// 1.获取连接
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();

			// 2.访问
			// 事务使用步骤1：开启事务
			connection.setAutoCommit(false);

			// 事务的操作1：更新张三丰
			MyCRUDUtils.update(connection, "update account set balance = ? where username=?", 500, "张三丰");
			// MyCRUDUtils.update( "update account set balance = ? where
			// username=?", 500, "张三丰");
			// 模拟异常
			int i = 1 / 0;
			// 事务的操作1：更新郭襄
			MyCRUDUtils.update(connection, "update account set balance = ? where username=?", 1500, "郭襄");

			// 事务使用步骤2：提交
			connection.commit();
		} catch (Exception e) {
			// 事务使用步骤3：回滚
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				// 3.关闭
				JDBCUtils.closeConnection(null, null, connection);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	// 使用事务1
	@Test
	public void testUseTransaction1() {
		// 1.获取连接
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JDBCUtils.getConnection();

			// 2.访问
			// 事务使用步骤1：开启事务
			connection.setAutoCommit(false);

			statement = connection.prepareStatement("update account set balance = ? where username=?");

			// 更新张三丰的余额
			statement.setFloat(1, 500);
			statement.setString(2, "张三丰");
			statement.executeUpdate();

			// 演示异常
			// int i = 1 / 1;
			int i = 1 / 0;

			// 更新郭襄的余额
			statement.setFloat(1, 1500);
			statement.setString(2, "郭襄");
			statement.executeUpdate();

			// 事务使用步骤2：提交
			connection.commit();
		} catch (Exception e) {
			// 事务使用步骤3：回滚
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				// 3.关闭
				JDBCUtils.closeConnection(null, statement, connection);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	// 没有使用事务
	@Test
	public void testNoTransaction() throws Exception {

		// 1.获取连接
		Connection connection = JDBCUtils.getConnection();

		// 2.访问
		PreparedStatement statement = connection.prepareStatement("update account set balance = ? where username=?");

		// 更新张三丰的余额
		statement.setFloat(1, 500);
		statement.setString(2, "张三丰");
		statement.executeUpdate();

		// 演示异常
		int i = 1 / 0;

		// 更新郭襄的余额
		statement.setFloat(1, 1500);
		statement.setString(2, "郭襄");
		statement.executeUpdate();

		// 3.关闭
		JDBCUtils.closeConnection(null, statement, connection);
	}
}