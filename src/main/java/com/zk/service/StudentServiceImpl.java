package com.zk.service;

import java.util.List;

import com.zk.dao.IStudentDao;
import com.zk.domain.Student;
import com.zk.utils.SqlSessionUtil;

public class StudentServiceImpl implements StudentService {
	private IStudentDao dao = SqlSessionUtil.getSqlSession().getMapper(IStudentDao.class);
	
	@Override
	public List<Student> queryStudent() {
		List<Student> students = dao.selectStudents();
		return students;
	}

	@Override
	public int addStudent(Student student) {
		int count = dao.insertStudent(student);
		return count;
	}

}
