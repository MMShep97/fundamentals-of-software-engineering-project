package com.canvas.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canvas.config.model.StudentCourse;
import com.canvas.config.services.StudentCourseService;

@RequestMapping("register/course")
@RestController
public class StudentCourseController {
	
	@Autowired
	StudentCourseService studentCourseService;
		
	@PostMapping
	public boolean registerForCourse(@RequestBody StudentCourse studentCourse) {
		System.out.println(studentCourse+" here is the student Course");
		boolean result = studentCourseService.isRegisteredForCourse(studentCourse);
		if(result)
			return true;
		return false;
	}
	
	@GetMapping(value = "getAll")
	public List<StudentCourse> allRegistered(){
		List<StudentCourse> allRegistered = studentCourseService.getAll();
		return allRegistered;
	}
	
	@DeleteMapping(value = "delete")
	public boolean isDeleted(@RequestBody StudentCourse sc) {
		boolean result = studentCourseService.isDropped(sc);
		if(result)
			return true;
		return false;
	}
	
	@GetMapping(value="exist")
	public boolean isExist(@RequestBody StudentCourse studentCourse) {
		boolean result = studentCourseService.isExist(studentCourse);
		if(result)
			return true;
		return false;
	}
	
}
