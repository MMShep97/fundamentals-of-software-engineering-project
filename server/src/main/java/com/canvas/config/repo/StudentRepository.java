package com.canvas.config.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canvas.config.model.Student;

public interface StudentRepository extends JpaRepository<Student , Integer> {

}
