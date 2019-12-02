package com.canvas.config.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canvas.config.model.Quiz;
import com.canvas.config.repo.QuizRepository;
@Service
public class QuizService {
	@Autowired
	QuizRepository repo;
	
	List<Quiz> quizes = new ArrayList<>();
	public List<Quiz> getAll(){
		quizes = repo.findAll();
		if(quizes == null)
			return new ArrayList<Quiz>();
		return quizes;
	}
	
	public Quiz getById(String quizId) {
		Quiz instructorCurrent = this.getAll().stream().filter(s -> s.getQuizId().equals(quizId)).findFirst().get();
		return instructorCurrent;
	}
	
	public boolean save(Quiz instructor) {
		
		if(repo.save(instructor) != null) {
			return true;
		}
		return false;
	}
	
	public void delete(String instructorId) {
		repo.deleteById(instructorId);
	}


}
