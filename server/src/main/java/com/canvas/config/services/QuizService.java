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
	
	/***
	 * This method returns the list of all quizes made.
	 * @return
	 */
	public List<Quiz> getAll(){
		quizes = repo.findAll();
		if(quizes == null)
			return new ArrayList<Quiz>();
		return quizes;
	}
	/***
	 * This returns an object of quiz 
	 * @param quizId
	 * @return object of quiz
	 */
	public Quiz getById(String quizId) {
		Quiz instructorCurrent = this.getAll().stream().filter(s -> s.getQuizId().equals(quizId)).findFirst().get();
		return instructorCurrent;
	}
	
	/***
	 * 
	 * @param quiz
	 * @return
	 */
	public boolean save(Quiz quiz) {
		
		if(repo.save(quiz) != null) {
			return true;
		}
		return false;
	}
	/****
	 * 
	 * @param quizId
	 */
	public void delete(String quizId) {
		repo.deleteById(quizId);
	}


}
