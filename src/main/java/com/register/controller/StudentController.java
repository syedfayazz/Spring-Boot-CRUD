package com.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.register.Student;
import com.register.service.StudentIService;


@RestController
public class StudentController {

	@Autowired
	StudentIService studentService;

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@RequestParam String id, @RequestParam String name) throws NullPointerException {

		System.out.println(id);
		System.out.println(name);

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		studentService.insertData(student);
		return "Inserted";
	}

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam String id) {
		System.out.println("id = " + id);
		studentService.DeleteData(id);
		return "Deleted";
	}

	@RequestMapping("/update")
	public String updateStudent(@RequestParam String id, @RequestParam String name) throws NullPointerException {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		studentService.updateData(student);
		return "Updated";
	}

	@RequestMapping("/getList")
	public List<Student> studentList() {
		List<Student> studentList = studentService.getStudentList();
		System.out.println(studentList);
		return studentList;
	}

	@RequestMapping("/getStudent")
	public Student studentDetail(@RequestParam String id) {
		Student student = studentService.getStudent(id);
		return student;
	}
}