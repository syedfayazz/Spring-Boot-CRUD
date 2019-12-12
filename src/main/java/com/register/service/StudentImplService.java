package com.register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.Student;
import com.register.dao.StudentIDao;

@Service
public class StudentImplService implements StudentIService {

	@Autowired
	StudentIDao studentDao;
	
	@Override
	public List<Student> getStudentList() {
		return studentDao.getStudentList();
	}

	@Override
	public void updateData(Student student) {
		studentDao.updateData(student);
	}

	@Override
	public void DeleteData(String id) {
		studentDao.DeleteData(id);

	}

	@Override
	public Student getStudent(String id) {
		return studentDao.getStudent(id);
	}

	@Override
	public void insertData(Student student) {
		// TODO Auto-generated method stub
		studentDao.insertData(student);
	}

}
