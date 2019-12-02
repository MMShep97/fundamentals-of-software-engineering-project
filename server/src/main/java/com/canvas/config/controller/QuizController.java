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
import com.canvas.config.model.Quiz;
import com.canvas.config.services.QuizService;

@RequestMapping(value="quiz")
@RestController
public class QuizController {

	@Autowired
	QuizService service;
	
	@GetMapping(value = "getAll")
	public List<Quiz> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value = "get/{quizId}")
	public Quiz getById(@PathVariable("quizId") String quizId){
		return service.getById(quizId);
	}
	@PostMapping(value = "save")
	public boolean saveStudent(@RequestBody Quiz quiz){
		return service.save(quiz);
	}
	@DeleteMapping(value = "delete")
	public boolean deleteQuiz(@RequestBody Quiz quiz) {
		if(quiz == null)
			return false;
		try{
			service.delete(quiz.getQuizId());
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
		
	}
}
