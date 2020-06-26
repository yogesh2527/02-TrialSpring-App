package com.assimilate.springboot.web.security.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.assimilate.springboot.web.security.model.Student;



@Repository
public interface StudentDao {

	int save(Student student);

	List<Student> getAllStudent();

	Student getByIdStudent(int id);

	int deleteStud(int id);

	int update(Student student);
	
}
