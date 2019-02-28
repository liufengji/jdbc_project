package com.yinggu.demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.junit.Test;

import com.yinggu.utils.JDBCUtils;

/**
 * 使用PreparedStatement实现增删改查
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 *
 */
public class TestPreparedStatement {

	Scanner input = new Scanner(System.in);

	@Test
	public void testSelect() {
		System.out.println("请选择要输入的类型");

		System.out.print("a、身份证号");
		System.out.print("b、准考证号");
		char key = input.next().charAt(0);

		switch (key) {
		case 'a':
			// 按身份证号查询
			selectByIdCard();
			break;
		case 'b':
			// 按准考证查询
			selectByExamCard();
			break;
		default:
			break;
		}

	}

	/**
	 * 按准考证查询
	 */
	private void selectByExamCard() {
		System.out.println("请输入准考证号：");
		String examCard = input.next();
		// ------------------------以下为连接数据库的步骤-------------------
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			// 1.获取连接
			connection = JDBCUtils.getConnection();

			// 2.获取命令并执行增删改查
			// 2-1 获取命令对象
			statement = connection.prepareStatement("select * from examstudent where examCard=?");
			// 2-2 设置占位符
			statement.setString(1, examCard);

			// 2-3 执行
			set = statement.executeQuery();

			if (set.next()) {
				int flowId = set.getInt(1);
				int type = set.getInt(2);
				String idCard = set.getString(3);
				String studentName = set.getString(5);
				String location = set.getString(6);
				int grade = set.getInt(7);
				System.out.println(flowId);
				System.out.println(type);
				System.out.println(idCard);
				System.out.println(examCard);
				System.out.println(studentName);
				System.out.println(location);
				System.out.println(grade);

			} else {
				System.out.println("查无此人");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				JDBCUtils.closeConnection(set, statement, connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 按身份证号查询
	 */
	private void selectByIdCard() {
		System.out.println("请输入身份证号：");
		String idCard = input.next();
		// ------------------------以下为连接数据库的步骤-------------------
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;

		try {
			// 1.获取连接
			connection = JDBCUtils.getConnection();

			// 2.获取命令并执行增删改查
			// 2-1 获取命令对象
			statement = connection.prepareStatement("select * from examstudent where idcard=?");
			// 2-2 设置占位符
			statement.setString(1, idCard);

			// 2-3 执行
			set = statement.executeQuery();

			if (set.next()) {
				int flowId = set.getInt(1);
				int type = set.getInt(2);
				String examCard = set.getString(4);
				String studentName = set.getString(5);
				String location = set.getString(6);
				int grade = set.getInt(7);
				System.out.println(flowId);
				System.out.println(type);
				System.out.println(idCard);

				System.out.println(examCard);
				System.out.println(studentName);
				System.out.println(location);
				System.out.println(grade);

			} else {
				System.out.println("查无此人");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				JDBCUtils.closeConnection(set, statement, connection);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 向学生表插入数据
	 */
	@Test
	public void testInsert() {

		System.out.println("请输入考生的详细信息");

		System.out.print("Type:");
		int type = input.nextInt();

		System.out.print("IDCard:");
		String idCard = input.next();

		System.out.print("ExamCard:");
		String examCard = input.next();

		System.out.print("StudentName:");
		String studentName = input.next();

		System.out.print("location:");
		String location = input.next();

		System.out.print("Grade:");
		int grade = input.nextInt();

		// ------------------------以下为连接数据库的步骤-------------------
		try (
				// 放在try（）里面实现资源自动管理，不需要再写finally 去关闭 资源了
				// 1.获取连接
				Connection connection = JDBCUtils.getConnection();
				// 2.访问数据库，执行操作
				PreparedStatement statement = connection
						.prepareStatement("insert into examstudent values(null,?,?,?,?,?,?)")

		) {
			statement.setInt(1, type);
			statement.setString(2, idCard);
			statement.setString(3, examCard);
			statement.setString(4, studentName);
			statement.setString(5, location);
			statement.setInt(6, grade);

			int update = statement.executeUpdate();
			System.out.println(update > 0 ? "success" : "failure");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
