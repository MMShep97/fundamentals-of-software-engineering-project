package com.canvas.config.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canvas.config.model.Account;
import com.canvas.config.model.Student;
import com.canvas.config.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repo;
	
//	private Student student;
	
	private List<Student> listStudents;
	
	public List<Student> listAll(){
		listStudents = repo.findAll();
		return listStudents;
		
	}
	
	//saving a student 
	public boolean save(Student student) {
		 if(repo.save(student) != null) {
			 return true;
		 }
		return false;
	}
	
	// searching in a list of students by their account id.
//	public Student getByAccountId(Account account) {
//		if(listStudents ==  null)
//		this.listAll();
//		student = repo.findAll().stream().filter(s -> s.getAccount() == account).findFirst().get();
//		return student;
//	}
	
	//get a student by Student Id
	public Student getById(Long studentId) {
		Student student  = repo.findAll().stream().filter(s -> s.getStudentId() == studentId).findFirst().get();
		return  student;
	}
	
	//delete a student by his student id
	public void delete(int studentId) {
		repo.deleteById(studentId);
	}
}
