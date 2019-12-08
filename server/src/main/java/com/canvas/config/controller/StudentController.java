package com.canvas.config.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.canvas.config.model.Student;
import com.canvas.config.services.StudentService;

@RequestMapping(value = "student")
@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	/**
	 * This method gets all the values of students from the
	 * database
	 * @return a list of Students
	 */
	@GetMapping(value = "getAll")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> students = service.listAll();
		return new ResponseEntity<List<Student>>(students , HttpStatus.OK);
		//return service.listAll();
	}
	/***
	 * this function gets a custom object of student from the back end
	 * @param studentId
	 * @return
	 */
	@GetMapping(value = "id/{email:.+}/")
	public Student getById(@PathVariable("email") String studentId){
		System.out.println("student id is  "+ studentId);
		Student student = service.getById(studentId);
		return student;
	}
	/***
	 * This function gets a student by his user name 
	 * @param userName
	 * @return it returns the student object if the user is found else null
	 */
	@GetMapping(value = "username/{userName}")
	public Student getByUsername(@PathVariable("userName") String userName) {
		Student student = service.getByUsername(userName);
		return student;
	}
	/***
	 * This function saves a student by taking in the student object as
	 * a parameter
	 * @param student
	 * @return it returns true if saving is successful and false if it isn't successful
	 */
	@PostMapping(value = "save")
	public boolean saveStudent(@RequestBody Student student){
		return service.save(student);
	}
	/***
	 * it takes in the student object and updates all the values for it.
	 * @param student
	 * @return
	 */
	@PutMapping(value = "update")
	public boolean updateStudent(@RequestBody Student student) {
		if(student == null || student.getFirstName() == null || student.getLastName() == null || student.getPassword() == null|| student.getStudentId() == null)
			return false;
		boolean result = service.update(student);
		return result;
	}
	@DeleteMapping(value = "delete/")
	public boolean deleteStudent(@RequestBody Student student) {
		if(student == null)
			return false;
		try{
			service.delete(student.getStudentId());
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
		
	}

}
