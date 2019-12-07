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
	
	@GetMapping("get/course_id/{course_id}")
	public List<Grade> getGradesByQuiz(@PathVariable("id") String course_id) {
		List<Grade> listAll = service.getByCourseId(course_id);
		return listAll;
	}
	@DeleteMapping(value="delete/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		service.delete(id);
	}
}
