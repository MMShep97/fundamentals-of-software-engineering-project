package com.canvas.config.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canvas.config.model.Course;
import com.canvas.config.model.Student;
import com.canvas.config.model.StudentCourse;
import com.canvas.config.repo.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repo;
	
	@Autowired
	public EntityManager em;
	@Autowired
	public StudentCourseService serv;
	
    private Course course;
	
	/**
	 * 
	 * This method gets all the courses from the database
	 * @return it returns a list of course
	 * */
	public List<Course> getCourses(){
		List<Course> list = repo.findAll();
		for(Course c : list) {
			c.setStudents(this.getStudentsForCourse(c.getCourseId()));
		}
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
		List<Student> students= em.createNativeQuery("SELECT s.student_id, s.first , s.last, s.username, s.password FROM student s INNER JOIN student_course sc ON s.student_id = sc.student_id WHERE sc.course_id =:courseId", Student.class)
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
		if(course == null) {
			return null;
		}
			
		return course;
	}
	/***
	 * This method lets you get courses for a particular instructor
	 * @param instructor_id
	 * @return list of courses for a instructor
	 */
	public List<Course> getByInstructorId(String instructor_id){
		List<Course> courses = this.getCourses().stream().filter(c -> c.getInstructorId().equalsIgnoreCase(instructor_id))
								.collect(Collectors.toList());
		return courses;
	}	
	/***
	 *
	 * It is used to save the the course or make a new course.
	 * @param course
	 * @return it returns true if the saved is true and false if the save fails
	 */
	public boolean save(Course course) {
		if(course.getCourseId() == null)
			return false;
		course = repo.save(course);
		List<Student> students = course.getStudents();
		 StudentCourse sc = new StudentCourse();
		 Boolean result = true;
		 if(students != null) {
			 for(Student s : students) {
					
				 sc.setCourse_id(course.getCourseId());
				 sc.setStudent_id(s.getStudentId());
				 //check if course already has the student registered
				 result = serv.isExist(sc);
				 
				 if(result == false) {
					 //registers for the course
					 serv.isRegisteredForCourse(sc);
				 }
			 
			 
		 }
		 }
		 
		return true;
	}
	/***
	 * It is used to update a course and it takes in the course object.
	 * 
	 * @param course
	 * @return it returns boolean true if the course is saved successfully and 
	 */
	public boolean updateCourse(Course course ) {
		if(repo.existsById(course.getCourseId()) == false)
			return false;
		Course before = repo.findById(course.getCourseId()).get();
		before.setCourseName(course.getCourseName());
		before.setInstructorId(course.getInstructorId());
		Course after = repo.save(before);
		List<Student> students = course.getStudents();
		 StudentCourse sc = new StudentCourse();
		 Boolean result = true;
		 if(students != null) {
			 for(Student s : students) {
				 
				 sc.setCourse_id(course.getCourseId());
				 sc.setStudent_id(s.getStudentId());
				 //check if course already has the student registered
				 result = serv.isExist(sc);
				 
				 if(result == false) {
					 //registers for the course
					 serv.isRegisteredForCourse(sc);
				 }
			 }
		 }
		
		if(after == null)
			return false;
		return true;
		
	}
	/**
	 * This function takes in the course_id and deletes from that course id
	 * in the course table , that entity.
	 * @param courseid
	 * @return boolean
	 * */
	public boolean delete(String course_id) {
		repo.deleteById(course_id);
		if(repo.existsById(course_id) == true)
			return false;
		return true;
	}
}
