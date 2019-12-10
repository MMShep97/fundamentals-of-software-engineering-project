package com.canvas.config.services;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.canvas.config.model.Course;
import com.canvas.config.model.Student;
import com.canvas.config.model.StudentCourse;
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
	@Autowired
	StudentCourseService service;

	/***
	 * It returns the list of courses with student id
	 * 
	 * @param student_id
	 * @return List<Course>
	 */
	@SuppressWarnings("unchecked")
	public List<Course> findCourse(String student_id) {
		List<Course> courses = em.createNativeQuery(
				"SELECT c.course_id ,course_name, instructor_id, cost, course_description FROM course c INNER JOIN student_course s ON c.course_id = s.course_id WHERE s.student_id =:student_id", Course.class)
				.setParameter("student_id", student_id).getResultList();
		return courses;
	}

	/**
	 * Getting grades for students
	 * 
	 * @param : It takes in the student id with which we can find the grades of the
	 *          student
	 * @return: It returns a list of students Using repository to list all the
	 *          students.
	 */

	public List<Student> listAll() {
		List<Student> students = repo.findAll();

		for (Student s : students) {
			s.setCourses(this.findCourse(s.getStudentId()));
		}
		System.out.println(students);
		return students;
	}

	/***
	 * This method saves the student if it doesn't exist
	 * 
	 * @param student
	 * @return true if the student is saved
	 */
	public boolean save(Student student) {
		if (repo.existsById(student.getStudentId()) == true)
			return false;
		if (repo.save(student) != null) {
			List<Course> courses = student.getCourses();
			StudentCourse sc = new StudentCourse();
			Boolean result = true;
			if(courses != null) {
				for (Course c : courses) {
					
						sc.setCourse_id(c.getCourseId());
						sc.setStudent_id(student.getStudentId());
						// check if s has already registered for course c
						result = service.isExist(sc);
						if (result == false) {
							// registers for the course
							service.isRegisteredForCourse(sc);
						}
			}
			
			}
			return true;
		}
		return true;
	}

	/***
	 * This method is used to get a student by id
	 * 
	 * @param studentId
	 * @return it returns a student
	 */
	public Student getById(String studentId) {

		Student student = repo.findById(studentId).get();
		student.setCourses(this.findCourse(studentId));
		return student;
	}

	/**
	 * @param user name
	 * @return student object is returned if the student the student is found.
	 */
	public Student getByUsername(String userName) {
		List<Student> students = this.listAll();

		Student student = students.stream().filter(s -> s.getUsername().equalsIgnoreCase(userName)).findFirst().get();
		student.setCourses(this.findCourse(userName));

		return student;
	}

	/***
	 * delete a student by his student id
	 * 
	 * @param studentId
	 * @return it returns true if the student is not found and false if the student
	 *         is found again.
	 */
	public boolean delete(String studentId) {
		repo.deleteById(studentId);
		if (repo.existsById(studentId))
			return false;
		return true;
	}

	/**
	 * Updating a student with a student object
	 * 
	 * @param student object
	 * @return boolean true if the student is updated
	 */
	public boolean update(Student student) {
		if (repo.existsById(student.getStudentId()) == false)
			return false;

		Student before = this.getById(student.getStudentId());

		if (student.getFirstName() != null)
			before.setFirstName(student.getFirstName());
		if (student.getCourses() != null)
			before.setCourses(student.getCourses());
		if (student.getLastName() != null)
			before.setLastName(student.getLastName());
		if (student.getPassword() != null)
			before.setPassword(student.getPassword());
		if (student.getUsername() != null)
			before.setUsername(student.getUsername());
		List<Course> courses = student.getCourses();
		StudentCourse sc = new StudentCourse();
		Boolean result = true;
		if(courses !=null) {
			for (Course c : courses) {
				
					sc.setCourse_id(c.getCourseId());
					sc.setStudent_id(student.getStudentId());
					// check if s has already registered for course c
					result = service.isExist(sc);
					if (result == false) {
						// registers for the course
						service.isRegisteredForCourse(sc);
					}
				
		}
		
			
		}
		repo.save(before);
		return true;
	}
}
