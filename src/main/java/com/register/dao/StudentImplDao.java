package com.register.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.register.Student;

@Repository
public class StudentImplDao implements StudentIDao {

	@Autowired
	DataSource dataSource;
	
	@Override
	public void insertData(Student student) {
		
		String sql = "INSERT into student" + "( id, name ) values(?, ?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql,new Object[] { student.getId(),student.getName() });
	}



	
	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		
		List<Student> studentList = new ArrayList<Student>();

		String sql = "select id, name from student";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		studentList = jdbcTemplate.query(sql, new StudentRowMapper());
		return studentList;

	}

	@Override
	public void updateData(Student student) {
		// TODO Auto-generated method stub
		

		String sql = "UPDATE student set name = ? where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, new Object[] { student.getName(), student.getId() });

	}

	@Override
	public void DeleteData(String id) {
		// TODO Auto-generated method stub
		
		String sql = "delete from student where id=" + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	@Override
	public Student getStudent(String id) {

		List<Student> studentList = new ArrayList<Student>();
		String sql = "select id, name from student where id= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		studentList = jdbcTemplate.query(sql, new StudentRowMapper());
		return studentList.get(0);
		
	}

}
