package com.canvas.config.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.canvas.config.model.Student;
import com.canvas.config.services.StudentService;

@RequestMapping(value = "student")
@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping(value = "getAll")
	public List<Student> getAll(){
		return service.listAll();
	}
	
	@GetMapping(value = "id/{studentId}")
	public Student getById(@PathVariable("studentId") String studentId){
		Student student = service.getById(studentId);
		return student;
	}

	@GetMapping(value = "username/{userName}")
	public Student getByUsername(@PathVariable("userName") String userName) {
		Student student = service.getByUsername(userName);
		return student;
	}

	@PostMapping(value = "save")
	public boolean saveStudent(@RequestBody Student student){
		return service.save(student);
	}
	@PutMapping(value = "update")
	public boolean updateStudent(@RequestBody Student student) {
		return service.update(student);
	}
	@DeleteMapping(value = "delete/")
	public boolean deleteStudent(@RequestBody Student student) {
		if(student == null)
			return false;
		try{
			service.delete(student.getStudentId());
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
		
	}

}
