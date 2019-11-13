package com.canvas.config.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canvas.config.model.Student;
import com.canvas.config.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repo;
	
	public List<Student> listAll(){
		System.out.println(repo.findAll());
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
		//Student student  = repo.findAll().stream().filter(s -> s.getStudentId() == studentId).findFirst().get();
		Student student = students.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId)).findFirst().get();
		System.out.println("in here "+ student);
		return  student;
	}
	
	//delete a student by his student id
	public void delete(String studentId) {
		repo.deleteById(studentId);
	}
}
