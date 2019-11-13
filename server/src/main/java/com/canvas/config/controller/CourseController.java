//package com.canvas.config.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.canvas.config.model.Course;
//import com.canvas.config.services.CourseService;
//
//@RequestMapping(value="course" )
//@RestController
//public class CourseController {
//
//  private	CourseService courseServ;
//  
//@GetMapping(value= "getcourse")  
//public List<Course> getAllcourses(){
//	return courseServ.getCourses();
//}  
// 
//
//@RequestMapping("/course/{id}")
//public Optional<Course> getCoursebyID(@PathVariable Integer CourseId  ) {
//	 return courseServ.getCoursebyID(CourseId);
//}
//
//
//@RequestMapping(method=RequestMethod.PUT, value="/course/{id}")
//public void udpdateCourse(@RequestBody Course course, @PathVariable Integer CourseId) {
//courseServ.updateCourse(CourseId, course);	
//}
//
//@RequestMapping(method=RequestMethod.DELETE, value="course/{id}")
//public void deleteCourse(@PathVariable Integer CourseId) {
//	courseServ.deleteCourse(CourseId);
//}
//}
