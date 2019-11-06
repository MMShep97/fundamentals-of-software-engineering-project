package com.canvas.config.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canvas.config.model.Course;
import com.canvas.config.repo.CourseRepository;

@Service
public class CourseService {
	
	
	@Autowired
	private CourseRepository courseRepo;
	
	public List<Course> getCourses(){
		List <Course> courses= new ArrayList<>();
		courseRepo.findAll()
		.forEach(courses::add);
		return courses;
	}

	public Optional<Course> getCoursebyID(Integer id) {
		
		return courseRepo.findById(id);
	}
	
	public void AddCourse(Course course) {
		courseRepo.save(course);
	}
	
	public void updateCourse(Integer id, Course course ) {
		courseRepo.save(course);
	}
	
	public void deleteCourse(Integer id) {
		courseRepo.deleteById(id);
	}
}
