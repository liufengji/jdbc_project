package com.yinggu.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;

import com.yinggu.utils.JDBCUtils;

/**
 * 此类用于演示PreparedStatement和Statement的区别
 * 案例：登录验证
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 * 
 * Statement的不足：
 * 1、用+拼接字符串，语法不够简洁，容易出错
 * 2、容易导致sql注入
 * 
 * PreparedStatement的好处：  ★
 * 1、使用占位符方式，语法简洁，让正常的代码和变量部分实现了分离，提高了维护性
 * 2、有效得避免了sql注入
 * 3、使用了预编译功能，仅仅编译一次，提高了效率
 * 
 *
 */
public class TestLogin {
	
	Scanner input  = new Scanner(System.in);
	
	@Test
	public void testByPreparedStatement() throws Exception{
		
		System.out.println("Please input username:");
		
		String username = input.next();
		
		System.out.println("Please input password:");
		
		String password = input.next();
		
		//根据用户名和密码连接数据库，实现判断
		//1.获取连接
		Connection connection = JDBCUtils.getConnection();
		
		//2.执行增删改查
		//2-1.获取命令对象
		
		PreparedStatement statement = connection.prepareStatement(
				"select count(*) from admin where username= ? and password = ?");
		
		//2-2.设置占位符的参数值
		statement.setString(1, username);
		statement.setString(2, password);
		
		//2-3.执行
		ResultSet set = statement.executeQuery();
		
		if(set.next()){
			int count = set.getInt(1);
			System.out.println(count>0?"Login Success!":"Login Failure!");
		}
		
		//3.关闭连接
		JDBCUtils.closeConnection(set, statement, connection); 
	}
	
	@Test
	public void testByStatement() throws Exception{
		
		System.out.println("Please input username:");
		
		String username = input.next();
		
		System.out.println("Please input password:");
		
		String password = input.next();
		
		//根据用户名和密码连接数据库，实现判断
		//1.获取连接
		Connection connection = JDBCUtils.getConnection();
		
		//2.执行增删改查
		Statement statement = connection.createStatement();
		
		ResultSet set = statement.executeQuery(
				"SELECT COUNT(*) FROM admin WHERE username='"+username+"' AND PASSWORD='"+password+"'");
		
		if(set.next()){
			int count = set.getInt(1);
			System.out.println(count>0?"Login Success!":"Login Failure!");
		}
		
		//3.关闭
		JDBCUtils.closeConnection(set, statement, connection);
		
	}
}