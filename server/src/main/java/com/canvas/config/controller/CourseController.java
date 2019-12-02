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
import com.canvas.config.model.Course;
import com.canvas.config.services.CourseService;

@RequestMapping(value="course")
@RestController
public class CourseController {
	@Autowired
	private	CourseService courseServ;
  
	@GetMapping(value= "getcourse")  
	public List<Course> getAllcourses(){
		return courseServ.getCourses();
	}  
	 
	@PostMapping(value="save")
	public boolean saveCourse(@RequestBody Course course) {
		return courseServ.save(course);
	}
	
	@GetMapping("get/{id}")
	public Course getCoursebyID(@PathVariable("id") String id){
		 return courseServ.getById(id);
	}
	
	
	@PutMapping(value="/course/{id}")
	public void udpdateCourse(@RequestBody Course course, @PathVariable String CourseId) {
	courseServ.updateCourse(CourseId, course);	
	}
	
	@DeleteMapping(value="delete/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseServ.delete(id);
	}
}
