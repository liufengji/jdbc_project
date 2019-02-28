package com.yinggu.demo3;

import java.util.Scanner;

import org.junit.Test;

import com.yinggu.bean.ExamStudent;
import com.yinggu.utils.MyCRUDUtils;

/**
 * 使用PreparedStatement实现增删改查 使用MyCRUDUtils
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 *
 */
public class TestPreparedStatementByUtils {

	Scanner input = new Scanner(System.in);

	/*
	 * 此方法未使用 不用看， 看最后边两个方法
	 */
	@Test
	public void testSelect() throws Exception {
		System.out.println("请选择要输入的类型");
		System.out.print("a、身份证号");
		System.out.print("b、准考证号");
		char key = input.next().charAt(0);

		switch (key) {
		case 'a':
			selectByIdCard();
			break;
		case 'b':
			selectByExamCard();
			break;
		default:
			break;
		}

	}

	/**
	 * 按准考证查询
	 * 
	 * @throws Exception
	 */
	private void selectByExamCard() throws Exception {
		System.out.println("请输入准考证号：");
		String examCard = input.next();
		String sql = "select * from examstudent where examCard=?";
		ExamStudent student = MyCRUDUtils.querySingle(sql, ExamStudent.class, examCard);
		System.out.println(student);
	}

	/**
	 * 按身份证号查询 使用 了 MyCRUDUtils
	 * 
	 * @throws Exception
	 */
	private void selectByIdCard() throws Exception {
		System.out.println("请输入身份证号：");
		String idCard = input.next();
		// ------------------------以下为连接数据库的步骤-------------------
		String sql = "select * from examstudent where idcard=?";
		ExamStudent student = MyCRUDUtils.querySingle(sql, ExamStudent.class, idCard);
		System.out.println(student);
	}

	/**
	 * 使用了MyCRUDUtils
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsert() throws Exception {

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

		String sql = "insert into examstudent values(null,?,?,?,?,?,?)";
		int update = MyCRUDUtils.update(sql, type, idCard, examCard, studentName, location, grade);
		System.out.println(update > 0 ? "succss" : "failure");
	}
}