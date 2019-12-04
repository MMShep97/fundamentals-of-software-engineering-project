package com.canvas.config.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.canvas.config.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student , String> {

}
