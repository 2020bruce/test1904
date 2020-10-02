package com.zk;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zk.dao.IStudentDao;
import com.zk.domain.Student;
import com.zk.service.StudentService;
import com.zk.service.StudentServiceImpl;
import com.zk.utils.ServiceFactory;
import com.zk.utils.SqlSessionUtil;

public class TestStudent {
	@Test
	public void testQuery() {
		StudentService proxy = (StudentService)ServiceFactory.getProxy(new StudentServiceImpl());
		proxy.queryStudent();
		
		
		
	}
	@Test
	public void testInsert() {
		StudentService proxy = (StudentService)ServiceFactory.getProxy(new StudentServiceImpl());
		Student student = new Student();
		student.setAge(18);
		student.setName("Œ‚”√");
		proxy.addStudent(student);
		
		
		
	}
	
	@Test
	public void testSelectStudentById() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		IStudentDao dao = sqlSession.getMapper(IStudentDao.class);
		dao.selectStudentById(1);
		sqlSession.close();
	}
	
	@Test
	public void testSelectStudentReturnMap() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		IStudentDao dao = sqlSession.getMapper(IStudentDao.class);
		List<Map<String, Object>> maps = dao.selectStudentSReturnMap();
		for(Map<String, Object> map : maps) {
			Set<String> set = map.keySet();
			for(String key : set) {
				Object value = map.get(key);
				System.out.println(value);
			}
			System.out.println();
		}
		
		sqlSession.close();
	}
	
	@Test
	public void testSelectStudentsByInput() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		IStudentDao dao = sqlSession.getMapper(IStudentDao.class);
		Student student = new Student();
		student.setAge(18);
		List<Student> students = dao.selectStudentsByInput(student);
		System.out.println(students);
	}
	
	@Test
	public void testSelectStudentsIn() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		IStudentDao dao = sqlSession.getMapper(IStudentDao.class);
		Integer[] integers = {1, 2, 3, 4};
		List<Student> students = dao.selectStudentsIn(integers);
		for(Student student : students) {
			System.out.println(student);
			
		}
		sqlSession.close();
	}
	
	@Test
	public void testSelectStudentNameAndClass() {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		IStudentDao dao = sqlSession.getMapper(IStudentDao.class);
		List<Map<String,Object>> list = dao.selectStudentNameAndClass();
		for(Map<String, Object> map : list) {
			Set<String> set = map.keySet();
			for(String key : set) {
				System.out.println("key:" + key);
				System.out.println("value:" + map.get(key));
			}
			System.out.println();
		}
		sqlSession.close();
	}
	
}





