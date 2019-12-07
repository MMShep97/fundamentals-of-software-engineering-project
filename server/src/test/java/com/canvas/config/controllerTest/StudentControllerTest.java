package com.canvas.config.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.canvas.config.controller.StudentController;
import com.canvas.config.model.Course;
import com.canvas.config.model.Grade;
import com.canvas.config.model.Student;
import com.canvas.config.repo.CourseRepository;
import com.canvas.config.repo.StudentRepository;
import com.canvas.config.services.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

	@Mock
	StudentRepository repo;
	@Mock
	CourseRepository courseRepository;
	@Mock
	EntityManager em;
	
	@Mock
	private StudentService service;
	
	@InjectMocks
	private StudentController studentController;
	
	Student student = new Student();
	List<Student> students = new ArrayList<>();
	List<Course> courses = new ArrayList<>();
	
	@Before
	public void setup() {
		student.setFirstName("ABC");
		student.setLastName("DEF");
		student.setStudentId("ABC@GMAIL.com");
		student.setPassword("ABCDEF");
		student.setCourses(new ArrayList<Course>());
		student.setGrades(new ArrayList<Grade>());
		students.add(student);
	}
	@Test
	public void getByStudentIdTrue() {
		when(service.getById(student.getStudentId()))
				.thenReturn(student);
		assertEquals(student, service.getById(student.getStudentId()));
	}
	@Test
	public void getByStudentIdFalse() {
		this.setup();
		assertEquals(null, service.getById("studentId"));
	}
	@Test
	public void listAllStudents() {
		when(service.listAll())
		    .thenReturn(students);
		assertEquals(students, service.listAll());
	}
	@Test
	public void deleteStudent() {
		when(service.delete(student.getStudentId()))
				.thenReturn(true);
		assertEquals(service.delete(student.getStudentId()) , true);
	}
	@Test
	public void updateStudent() {
		when(service.update(student))
				.thenReturn(true);
		assertEquals(service.update(student) , true);
	}
	@Test
	public void getByUsername() {
		when(service.getByUsername(student.getUsername()))
				.thenReturn(student);
		assertEquals(service.getByUsername(student.getUsername()) , student);
		}
	
	
	
}
