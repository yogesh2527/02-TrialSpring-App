package com.assimilate.springboot.web.security.services;

import com.assimilate.springboot.web.security.model.*;
import com.assimilate.springboot.web.security.services.*;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface StudentService {

	public int createStudent(Student student);

	

	public List<Student> getStudent();



	public Student getStudentById(int id);



	public int delete(int id);



	public int updateStudent(Student student);



	

	

	

}
