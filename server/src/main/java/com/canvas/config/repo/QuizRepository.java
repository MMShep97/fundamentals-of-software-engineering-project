package com.canvas.config.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.canvas.config.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, String> {
	
}
