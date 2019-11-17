package com.canvas.config.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canvas.config.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, String>{

	
}
