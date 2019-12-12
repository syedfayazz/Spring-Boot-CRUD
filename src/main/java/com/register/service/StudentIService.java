package com.register.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.register.Student;

@Service
public interface StudentIService {

	public void insertData(Student student);
	
	public List<Student> getStudentList();
	
	public void updateData(Student student);
	
	public void DeleteData(String id);
	
	public Student getStudent(String id);

}
