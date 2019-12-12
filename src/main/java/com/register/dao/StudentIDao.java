package com.register.dao;

import java.util.List;

import com.register.Student;

public interface StudentIDao {
	
	public void insertData(Student student);
	
	public List<Student> getStudentList();
	
	public void updateData(Student student);
	
	public void DeleteData(String id);
	
	public Student getStudent(String id);

	
}
