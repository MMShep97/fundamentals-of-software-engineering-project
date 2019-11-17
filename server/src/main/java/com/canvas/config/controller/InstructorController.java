package com.canvas.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canvas.config.model.Instructor;
import com.canvas.config.services.InstructorService;

@RequestMapping(value="instructor")
@RestController
public class InstructorController {

	@Autowired
	InstructorService service;
	
	@GetMapping(value = "getAll")
	public List<Instructor> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value = "get/{instructorId}")
	public Instructor getById(@PathVariable("instructorId") String instructorId){
		return service.getById(instructorId);
	}
	@PostMapping(value = "save")
	public boolean saveStudent(@RequestBody Instructor instructor){
		return service.save(instructor);
	}
	@DeleteMapping(value = "delete/")
	public boolean deleteStudent(@RequestBody Instructor instructor) {
		if(instructor == null)
			return false;
		try{
			service.delete(instructor.getInstructorId());
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
		
	}
}
