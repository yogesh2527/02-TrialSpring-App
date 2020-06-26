package com.assimilate.springboot.web.security.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.validator.cfg.context.ReturnValueConstraintMappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.assimilate.springboot.web.security.model.Student;



@Component
public class StudentDaoImplementation implements StudentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public int save(Student student) {
		
		String sqlQuery ="insert into school(name,subject,marks,address)" + " values(?,?,?,?)";
		int i = jdbcTemplate.update(sqlQuery,student.getName(),student.getSubject(),student.getMarks(),student.getAddress());
		return i;
	}


	@Override
	public List<Student> getAllStudent() {
		
		System.out.println("In Student Dao Implenentation Class");
		
		String sqlQuery="Select * from school";
		
		  List<Student> students =  jdbcTemplate.query(sqlQuery,new RowMapper () {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setSubject(rs.getString("subject"));
				student.setMarks(rs.getInt("marks"));
				student.setAddress(rs.getString("address"));
				
				return student;
			}
			   
		
			   
		   });
		  return students;
		  
	}


	@Override
	public Student getByIdStudent(int id) {
	
		System.out.println("----------------Executing getByID() in Student Dao ----------");
		
		String sqlQuery="Select * from school where id= '"+id+"'";

		List<Student> student = jdbcTemplate.query(sqlQuery, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stud = new Student();
				
				stud.setId(rs.getInt("id"));
				stud.setName(rs.getString("name"));
				stud.setSubject(rs.getString("subject"));
				stud.setMarks(rs.getInt("marks"));
				stud.setAddress(rs.getString("address"));
				
				return stud;
			}
			
			
		});
		
		return student.get(0);
	}


	@Override
	public int deleteStud(int id) {
		
		System.out.println("in StudentDao Delete()");
		String query="delete from school where id=?";
		
		int i =jdbcTemplate.update(query,id);
		
		
		return i;
	}


	@Override
	public int update(Student student) {
		
		System.out.println("in StudentDao Update() ");
		
		String query="update school set name=? , subject=? , marks=?, address=? where id=?";
		
		int i= jdbcTemplate.update(query,student.getName(),
		student.getSubject(),
		student.getMarks(),
		student.getAddress(),
		student.getId()		
				);
		
		
		return i;
	}


	

}
