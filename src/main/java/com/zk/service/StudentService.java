package com.zk.service;

import java.util.List;

import com.zk.domain.Student;

public interface StudentService {
	public List<Student> queryStudent();
	public int addStudent(Student student);
}
