package com.canvas.config.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canvas.config.model.Instructor;
import com.canvas.config.repo.InstructorRepository;

@Service
public class InstructorService {

	@Autowired
	InstructorRepository repo;
	
	List<Instructor> instructors;
	
	public List<Instructor> getAll(){
		instructors = repo.findAll();
		if(instructors == null)
			return new ArrayList<Instructor>();
		return instructors;
	}
	
	public Instructor getById(String instructorId) {
		Instructor instructorCurrent = this.getAll().stream().filter(s -> s.getInstructorId().equals(instructorId)).findFirst().get();
		return instructorCurrent;
	}
	
	public boolean save(Instructor instructor) {
		
		if(repo.save(instructor) != null) {
			return true;
		}
		return false;
	}
	
	//delete a student by his student id
	public void delete(String studentId) {
		repo.deleteById(studentId);
	}

	
	
}
