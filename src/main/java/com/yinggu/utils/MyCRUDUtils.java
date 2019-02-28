package com.yinggu.utils;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 此类用于演示封装通用的增删改查工具方法
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 * 
 * 功能： 1、封装通用的增删改 
 *              ①适合任何的增删改sql语句 
 *              ②适合任何表
 *       2、通用的查询 
 *             ①适合任何的查询sql语句
 *             ②适合任何表
 */
public class MyCRUDUtils {
	/**
	 * 功能：通用的查询多条记录
	 * 
	 * @param sql
	 *            待查询的sql
	 * @param clazz
	 *            class对象
	 * @param objects
	 *            占位符
	 * @return 单条对象
	 * @throws Exception
	 */

	public static <T> List<T> queryMulti(String sql, Class<T> clazz, Object... objects) throws Exception {

		// 1.获取连接
		Connection connection = JDBCUtils.getConnection();

		// 2.执行sql
		// 2-1 获取预编译命令对象
		PreparedStatement statement = connection.prepareStatement(sql);
		// 2-2 设置占位符
		for (int i = 0; i < objects.length; i++) {
			statement.setObject(i + 1, objects[i]);
		}
		// 2-3 执行
		ResultSet set = statement.executeQuery();

		// 获取元数据结果集对象
		ResultSetMetaData metaData = set.getMetaData();

		List<T> list = new ArrayList<>();
		while (set.next()) {
			// 1.通过反射创建对应类型的对象
			T t = clazz.newInstance();
			/*
			 * 需求： 封装该条记录的对象，并为该位对象的属性赋值，然后返回 反射的步骤： 1.通过反射创建对应类型的对象 T t =
			 * clazz.newInstance();
			 * 
			 * 2.为属性赋值 遍历里面每一个属性：?列数、列名
			 * 
			 * 假如，知道每一个列名（属性名） for(int i=1;i<=列数;i++){ //获取列名？
			 * 
			 * Field field = clazz.getDeclaredFiled(属性名);
			 * field.setAccessible(true); field.set(t,set.get(列索引或列名)); }
			 * 
			 * 3.返回该对象 return t;
			 * 
			 */

			// 获取结果集的列数
			int columnCount = metaData.getColumnCount();

			for (int i = 1; i <= columnCount; i++) {// 遍历每个列（每个属性）
				// 2.为属性赋值
				// 获取列名？
				String columnName = metaData.getColumnLabel(i);
				Field field = clazz.getDeclaredField(columnName);
				field.setAccessible(true);
				field.set(t, set.getObject(columnName));
			}
			list.add(t);
		}
		JDBCUtils.closeConnection(set, statement, connection);
		return list;

	}

	/**
	 * 功能：通用的查询单条记录
	 * orm  ->  object  relation  mapping
	 * 对象关系映射
	 * 
	 * 表的设计  ->  java 中类的设计
	 * 表中的每一条记录，相当于java中的一个对象
	 * 表中的每一个字段，相当于java中的每一个属性
	 * 
	 * 需求
	 * 封装查询的单条记录的对象，并为该对象的属性赋值，然后返回
	 * 
	 * @param sql
	 *            待查询的sql
	 * @param clazz
	 *            class对象
	 * @param objects
	 *            占位符
	 *            
	 * <T> T  泛型
	 * @return 单条对象
	 * @throws Exception
	 */

	public static <T> T querySingle(String sql, Class<T> clazz, Object... objects) throws Exception {

		// 1.获取连接
		Connection connection = JDBCUtils.getConnection();

		// 2.执行sql
		// 2-1 获取预编译命令对象
		PreparedStatement statement = connection.prepareStatement(sql);
		
		// 2-2 设置占位符
		for (int i = 0; i < objects.length; i++) {
			statement.setObject(i + 1, objects[i]);
		}
		
		// 2-3 执行
		ResultSet set = statement.executeQuery();

		// 获取元数据结果集对象
		ResultSetMetaData metaData = set.getMetaData();
		
		// 1.通过反射,创建对应类型的对象
		T t = clazz.newInstance();
		if (set.next()) {

			/*
			 * 反射的步骤
			 * 需求： 封装该条记录的对象，并为该位对象的属性赋值，然后返回 反射的步骤：
			 * 1.通过反射创建对应类型的对象 
			 * T t = clazz.newInstance();
			 * 
			 * 2.为属性赋值 遍历里面每一个属性：?列数、列名
			 * 假如，知道每一个列名（属性名） for(int i=1;i<=列数;i++){ //获取列名？
			 * 
			 * Field field = clazz.getDeclaredFiled(属性名);
			 * field.setAccessible(true); 
			 * field.set(t,set.get(列索引或列名)); }
			 * 
			 * 3.返回该对象 return t;
			 * 
			 */

			// 获取结果集的列数
			int columnCount = metaData.getColumnCount();

			for (int i = 1; i <= columnCount; i++) {// 遍历每个列（每个属性）
				// 2.为属性赋值
				// 获取列名或者属性名
				String columnName = metaData.getColumnLabel(i);
				Field field = clazz.getDeclaredField(columnName);
				//得到or激活
				field.setAccessible(true);
				//赋值
				field.set(t, set.getObject(columnName));
			}
		}
		JDBCUtils.closeConnection(set, statement, connection);
		return t;

	}

	/**
	 * 功能：通用的增删改 注意：连接不用关闭, 应用于事务模块功能演示 
	 * 
	 * @param connection
	 *            使用的连接对象
	 * @param sql
	 *            待执行的sql语句
	 * @param objects
	 *            占位符的参数列表
	 * @return 受影响的行数
	 * @throws Exception
	 */

	public static int update(Connection connection, String sql, Object... objects) throws Exception {

		// 2.执行
		// 2-1.获取预编译命令对象
		PreparedStatement statement = connection.prepareStatement(sql);
		// 2-2.设置占位符
		for (int i = 0; i < objects.length; i++) {
			statement.setObject(i + 1, objects[i]);
		}
		// 2-3.执行
		int update = statement.executeUpdate();

		// 3.关闭
		JDBCUtils.closeConnection(null, statement, null);

		return update;

	}

	/**
	 * 功能：通用的增删改
	 * 
	 * @param sql
	 *            待执行的sql语句
	 * @param objects
	 *            占位符的参数列表
	 * @return 受影响的行数
	 * @throws Exception
	 */

	public static int update(String sql, Object... objects) throws Exception {

		// 1.获取连接
		Connection connection = JDBCUtils.getConnection();

		// 2.执行
		// 2-1.获取预编译命令对象
		PreparedStatement statement = connection.prepareStatement(sql);
		// 2-2.设置占位符
		for (int i = 0; i < objects.length; i++) {
			statement.setObject(i + 1, objects[i]);
		}
		// 2-3.执行
		int update = statement.executeUpdate();

		// 3.关闭
		JDBCUtils.closeConnection(null, statement, connection);

		return update;

	}

}
