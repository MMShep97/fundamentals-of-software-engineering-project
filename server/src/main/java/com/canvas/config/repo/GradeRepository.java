package com.canvas.config.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canvas.config.model.Grade;

public interface GradeRepository extends JpaRepository<Grade ,Integer>{

}
