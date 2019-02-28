package com.yinggu.demo3;


import java.util.List;

import org.junit.Test;

import com.yinggu.bean.ExamStudent;
import com.yinggu.utils.MyCRUDUtils;
/**
 * 
 * @author:黑猴子的家
 * @博客 :https://www.jianshu.com/u/37fd8e2dff4c
 *
 */
public class TestCRUD {

	/**
	 * 查询单个
	 * @throws Exception
	 */
	@Test
	public void testSelectSingle() throws Exception {
		ExamStudent examstudent = MyCRUDUtils.querySingle("select * from examstudent where flowid = ? ",
				ExamStudent.class, 1);
		System.out.println(examstudent);
	}

	/**
	 * 查询多个
	 * @throws Exception
	 */
	@Test
	public void testSelectMulti() throws Exception {
		List<ExamStudent> list = MyCRUDUtils.queryMulti("select * from examstudent where flowid >= ? ", ExamStudent.class,1);
		for (ExamStudent examStudent : list) {
			System.out.println(examStudent);
		}
	}
}