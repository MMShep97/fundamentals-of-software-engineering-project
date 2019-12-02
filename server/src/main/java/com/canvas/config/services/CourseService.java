package com.canvas.config.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canvas.config.model.Course;
import com.canvas.config.repo.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repo;
	
	private Course course;
	
	public List<Course> getCourses(){
		List<Course> list = repo.findAll();
		if(list == null) {
			return new ArrayList<>();
		}
		return list;
	}

	public Course getById(String id) {
		course = repo.findById(id).get();
		if(course == null)
			return null;
		return course;
	}
	
	public boolean save(Course course) {
		course = repo.save(course);
		if(course != null)
			return true;
		return false;
	}
	
	public void updateCourse(String id, Course course ) {
		repo.save(course);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
}
