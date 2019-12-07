package com.canvas.config.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canvas.config.model.Course;
import com.canvas.config.model.Student;
import com.canvas.config.repo.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repo;
			
	private Course course;
	
	@Autowired
	public EntityManager em;
	
	/**
	 * 
	 * This method gets all the courses from the database
	 * @return it returns a list of course
	 * */
	public List<Course> getCourses(){
		List<Course> list = repo.findAll();
		if(list == null) {
			return new ArrayList<>();
		}
		return list;
	}
	/**
	 * to get users linked with a particular course we will use
	 * this method.
	 * 
	 *@param : it takes in the course id of a particular course to receive.
	 *@return : it returns the list of students which are enrolled in that particular course.
	 * */
	@SuppressWarnings("unchecked")
	public List<Student> getStudentsForCourse(String courseId){
		List<Student> students= em.createNativeQuery("SELECT s.student_id FROM student s INNER JOIN student_course sc ON s.student_id = sc.student_id WHERE sc.course_id =:courseId")
								.setParameter("courseId", courseId)
								.getResultList();
		return students;
	}
	/**
	 * it returns a single course by getting the course_id
	 * @param: it takes in the id of the course
	 * @return : it returns the course objects.
	 * */
	public Course getById(String course_id) {
		course = repo.findById(course_id).get();
		course.setStudents(this.getStudentsForCourse(course_id));
		if(course == null)
			return null;
		return course;
	}
	/***
	 *
	 * It is used to save the the course or make a new course.
	 * @param course
	 * @return it returns true if the saved is true and false if the save fails
	 */
	public boolean save(Course course) {
		course = repo.save(course);
		if(course != null)
			return true;
		return false;
	}
	/***
	 * It is used to update a course and it takes in the course object.
	 * 
	 * @param course
	 * @return it returns boolean true if the course is saved successfully and 
	 */
	public boolean updateCourse(Course course ) {
		if(course.getCourseId() == null || course.getCourseName() == null || course.getInstructorId() == null)
			return false;
		Course before = repo.findById(course.getCourseId()).get();
		
		before.setCourseName(course.getCourseName());
		before.setInstructorId(course.getInstructorId());
		Course after = repo.save(before);
		if(after == null)
			return false;
		return true;
		
	}
	/**
	 * 
	 * @param courseid
	 * @return void
	 * */
	public void delete(String course_id) {
		repo.deleteById(course_id);
	}
}
