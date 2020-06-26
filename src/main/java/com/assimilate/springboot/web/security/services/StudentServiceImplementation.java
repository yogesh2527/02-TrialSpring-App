package com.assimilate.springboot.web.security.services;


import com.assimilate.springboot.web.security.dao.StudentDao;
import com.assimilate.springboot.web.security.model.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImplementation implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public int createStudent(Student student) {
		
		return studentDao.save(student);
	}

	@Override
	public List<Student> getStudent() {
		
		System.out.println("Getting All the Students");
		
		return studentDao.getAllStudent();
	}

	@Override
	public Student getStudentById(int id) {
		
		return studentDao.getByIdStudent(id);
	}

	@Override
	public int delete(int id) {
		
		return studentDao.deleteStud(id);
	}

	@Override
	public int updateStudent(Student student) {
		
		return studentDao.update(student);
	}

	

	
}
