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
	/*
	 * Getting all the instructors from the database
	 * */
	public List<Instructor> getAll(){
		instructors = repo.findAll();
		if(instructors == null)
			return new ArrayList<Instructor>();
		return instructors;
	}
	/*
	 * getting a instructor by their id.
	 * */
	public Instructor getById(String instructorId) {
		Instructor instructorCurrent = this.getAll().stream().filter(s -> s.getInstructorId().equals(instructorId)).findFirst().get();
		return instructorCurrent;
	}
	/*
	 * saving a user or persisting a user in the database.
	 * */
	public boolean save(Instructor instructor) {
		if(repo.save(instructor) != null) {
			return true;
		}
		return false;
	}
	/*
	 * Deleting an instructor with their instructor id
	 * */
	public void delete(String instructorId) {
		repo.deleteById(instructorId);
	}
	/*
	 * Updating an instructor with a student object
	 * */
	public boolean update(Instructor instructor) {
		Instructor before = this.getById(instructor.getInstructorId());
		if(instructor.getFirstName() == null || instructor.getLastName() == null|| instructor.getPassword() == null || instructor.getUsername() == null )
			return false;
		before.setFirstName(instructor.getFirstName());
		before.setCourses(instructor.getCourses());
		before.setLastName(instructor.getLastName());
		before.setPassword(instructor.getPassword());
		before.setUsername(instructor.getUsername());
		repo.save(before);
		return true;
	}

	
	
}
