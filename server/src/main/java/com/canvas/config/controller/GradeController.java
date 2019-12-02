package com.canvas.config.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.canvas.config.model.Grade;
import com.canvas.config.services.GradeService;

@RequestMapping(value="grade")
@RestController
public class GradeController {
	@Autowired
	GradeService service;
	
	@GetMapping(value= "getAll")  
	public List<Grade> getAll(){
		return service.getAll();
	}  
	 
	@PostMapping(value="save")
	public boolean save(@RequestBody Grade grade) {
		return service.save(grade);
	}
	
	@GetMapping("get/{id}")
	public Grade getGrades(@PathVariable("id") Double id  ) {
		 return service.getById(id);
	}
	
	
//	@PutMapping(value="/course/{id}")
//	public void udpdateCourse(@RequestBody Course course, @PathVariable String CourseId) {
//		service.updateCourse(CourseId, course);	
//	}
	
	@DeleteMapping(value="delete/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		service.delete(id);
	}
}
