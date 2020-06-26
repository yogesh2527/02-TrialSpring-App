package com.assimilate.springboot.web.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.assimilate.springboot.web.security.dao.StudentDao;
import com.assimilate.springboot.web.security.model.Student;
import com.assimilate.springboot.web.security.services.*;




@Controller
public class StudentController {
	
	//injecting the studentService object
	
	@Autowired
	private StudentService studentService;
	
	
	
	@RequestMapping(value = {"/students/getAll","/"})
	public ModelAndView getAllStudents()
	{
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<Student>students=studentService.getStudent();
		
		modelAndView.setViewName("getAll");
		
		modelAndView.addObject("list", students);
		
		
		
		return modelAndView;
	}
	
	
	@RequestMapping("/students/home")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping(path="/students/createStudent")
	public String createStudent( Model model )
	{
			
			
		model.addAttribute("command", new Student());
		
		return "createStudent";
	}
	
	
	@RequestMapping(path="/students/save" , method=RequestMethod.POST)
	public String save(@ModelAttribute("stud") Student stud)
	{
		
		studentService.createStudent(stud);
		System.out.println("name : "+stud.getAddress());
		return "redirect:/students/getAll";
	}
	
	
	@RequestMapping(path="/students/deleteStudent/{id}" , method=RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") int id)
	{
		
			studentService.delete(id);
	
			return "redirect:/students/getAll";

	}
	
	@RequestMapping(path="/students/editStudent/{id}")
	public String showEditForm(@PathVariable ("id") int id , Model model)
	{
		
			Student	student =studentService.getStudentById(id);
			model.addAttribute("command",student);
				
				
		return "editStudent";
	}
	
	@RequestMapping(path="/students/edit" , method=RequestMethod.POST)
	public String updateStudent(@ModelAttribute("student") Student student)
	{
			studentService.updateStudent(student);
		
		return "redirect:/students/getAll";
	}
	
	
//	
//	@RequestMapping("/getAllStudent")
//	public List<Student> getAllStudent()
//	{
//		return studentService.getStudent();
//	}
//	
//	
//	@RequestMapping(path="/createStudent")
//	public String createStudent(@RequestBody Student student)
//	{
//		System.out.println("New Student Created");
//		
//		int i = studentService.createStudent(student); 
//		return "Student Inserted Successfully";
//	}
//	
//	@RequestMapping("/getById/{id}")
//	public Student getById(@PathVariable("id") int id)
//	{
//		System.out.println("Getting Student Details by Id =>  "+id);
//		
//		return studentService.getStudentById(id);
//	}
//	
//	@RequestMapping(path="/deleteStudent/{id}", method=RequestMethod.DELETE)
//	public String deleteStudent(@PathVariable("id") int id)
//	{
//		System.out.println("delete Student");
//		
//		 studentService.delete(id);
//		 return "Student deleted Successfully";
//	}
//	
//	
//	@RequestMapping("/updateStudent")
//	public String updateStudent(@RequestBody Student student)
//	{
//		
//		int i = studentService.updateStudent(student);
//		
//		return "Record Updated Successfully";
//	}
	
}
 