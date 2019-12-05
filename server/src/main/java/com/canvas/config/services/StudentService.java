package com.canvas.config.services;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.canvas.config.model.Course;
import com.canvas.config.model.Student;
import com.canvas.config.repo.CourseRepository;
import com.canvas.config.repo.StudentRepository;

@Service
@Configuration
@EnableTransactionManagement
public class StudentService {

	@Autowired
	StudentRepository repo;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	EntityManager em;
	
	/*
	 * Getting list of courses for students from the database
	 * */
	@SuppressWarnings("unchecked")
	public List<Course> findCourse(String student_id){
		List<Course> courses = em.createNativeQuery("SELECT c.course_id ,course_name, instructor_id FROM course c INNER JOIN student_course s ON c.course_id = s.course_id WHERE s.student_id =:student_id")
		.setParameter("student_id", student_id)
		.getResultList();
		return courses;
	}
	
	/**Getting grades for students
	 * @param : It takes in the student id with which we can find the grades of the student*/
	/*
	 * Using repo to list all the students.
	 * */
	
	public List<Student> listAll(){
		return repo.findAll();
		
	}
	
	//saving a student 
	public boolean save(Student student) {
		 if(repo.save(student) != null) {
			 return true;
		 }
		return false;
	}
	
	//get a student by Student Id
	public Student getById(String studentId) {
		List<Student> students = this.listAll();
		Student student = students.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId)).findFirst().get();
		student.setCourses(this.findCourse(studentId));
		System.out.println("in here "+ student);
		return  student;
	}

	public Student getByUsername(String userName) {
		List<Student> students = this.listAll();
		Student student = students.stream().filter(s -> s.getUsername().equalsIgnoreCase(userName)).findFirst().get();
		student.setCourses(this.findCourse(userName));
		return student;
	}
	
	//delete a student by his student id
	public void delete(String studentId) {
		repo.deleteById(studentId);
	}
	
	/*
	 * Updating a student with a student object
	 * */
	public boolean update(Student student) {
		Student before = this.getById(student.getStudentId());
		if(student.getFirstName() == null || student.getLastName() == null|| student.getPassword() == null || student.getUsername() == null )
			return false;
		before.setFirstName(student.getFirstName());
		before.setCourses(student.getCourses());
		before.setLastName(student.getLastName());
		before.setPassword(student.getPassword());
		before.setUsername(student.getUsername());
		repo.save(before);
		return true;
	}
}
