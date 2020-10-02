package com.zk.dao;

import java.util.List;
import java.util.Map;

import com.zk.domain.Student;

public interface IStudentDao {
	List<Student> selectStudents();
	int insertStudent(Student student);
	Student selectStudentById(int id);
	List<Map<String, Object>> selectStudentSReturnMap();
	List<Student> selectStudentsByInput(Student student);
	List<Student> selectStudentsIn(Integer[] integers);
	List<Map<String, Object>> selectStudentNameAndClass();
}
