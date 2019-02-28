package com.yinggu.demo4;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.yinggu.utils.JDBCUtils;
 
/**
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 * 
 * 大数据  图片在数据库的上传和下载
 * 注意点
 *   （1）图片选小的
 *   （2）编码格式是不是utf-8
 *    (3) Stream 流别忘记关闭
 */
public class TestBlob {

	// 下载
	@Test
	public void testRead() throws Exception {

		// 1.获取连接
		Connection connection = JDBCUtils.getConnection();

		// 2.访问数据库
		PreparedStatement statement = connection.prepareStatement("select photo from beauty where id=?");
		statement.setInt(1, 5);
		ResultSet set = statement.executeQuery();

		if (set.next()) {
			// 方式一：getBlob
			// Blob blob = set.getBlob(1);
			// InputStream inputStream = blob.getBinaryStream();

			// 方式二：getBinaryStream
			InputStream inputStream = set.getBinaryStream(1);

			// 写入到指定的文件中——写入到src\copy.jpg
			FileOutputStream fos = new FileOutputStream("src\\copy.jpg");
			int len;
			byte[] b = new byte[1024];
			while ((len = inputStream.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			fos.close();
			inputStream.close();
		}
		// 3.关闭
		JDBCUtils.closeConnection(set, statement, connection);
	}

	// 上传
	@Test
	public void testSave() throws Exception {

		// 1.获取连接
		Connection connection = JDBCUtils.getConnection();

		// 2.执行
		PreparedStatement statement = connection.prepareStatement("update beauty set photo=? where id=?");
		InputStream inputStream = new FileInputStream("C:\\Users\\heihouzi\\Desktop\\beauty\\zdy.jpg");

		statement.setBlob(1, inputStream);
		statement.setInt(2, 5);

		int update = statement.executeUpdate();
		System.out.println(update > 0 ? "success" : "failure");

		// 3.关闭
		inputStream.close();
		JDBCUtils.closeConnection(null, statement, connection);
	}
	
	
}