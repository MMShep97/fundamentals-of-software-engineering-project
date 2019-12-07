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
  
	/***
	 * 
	 * @return
	 */
	@GetMapping(value= "getcourse")  
	public List<Course> getAllcourses(){
		return courseServ.getCourses();
	}  
	 /****
	  * 
	  * @param course
	  * @return
	  */
	@PostMapping(value="save")
	public boolean saveCourse(@RequestBody Course course) {
		if(course == null || course.getCourseId() == null || course.getCourseName() == null || course.getInstructorId() == null)
			return false;
		boolean result = courseServ.save(course);
		return result;
	}
	/***
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("get/{id}")
	public Course getCoursebyID(@PathVariable("id") String id){
		if(id == null)
			return null;
		
		 return courseServ.getById(id);
	}
	
	/***
	 * 
	 * @param course
	 * @return
	 */
	@PutMapping(value="/course/{id}")
	public boolean udpdateCourse(@RequestBody Course course) {
		if(course == null || course.getCourseId() == null || course.getCourseName() == null || course.getInstructorId() == null)
			return false;
	boolean result = courseServ.updateCourse(course);	
	if(result == false)
		return false;
	return true;
	}
	/***
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="delete/{id}")
	public boolean deleteCourse(@PathVariable String id) {
		if(id == null)
			return false;
		boolean result = courseServ.delete(id);
		if(result == false)
			return false;
		return true;
	}
}
