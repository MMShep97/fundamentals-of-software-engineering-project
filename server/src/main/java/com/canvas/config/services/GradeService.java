package com.canvas.config.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canvas.config.model.Grade;
import com.canvas.config.repo.GradeRepository;

@Service
public class GradeService {

	@Autowired
	GradeRepository repo;
	
	List<Grade> grades = new ArrayList<>();
	public List<Grade> getAll(){
		grades = repo.findAll();
		if(grades == null)
			return new ArrayList<Grade>();
		return grades;
	}
	
	public Grade getById(Double id) {
		Grade currentGrade = this.getAll().stream().filter(s -> s.getId().equals(id)).findFirst().get();
		return currentGrade;
	}
	
	public boolean save(Grade grade) {
		if(repo.save(grade) != null) {
			return true;
		}
		return false;
	}
	
	public void delete(Integer grade_id) {
		repo.deleteById(grade_id);
	}
	public boolean editGrade(Grade grade) {
		Grade inGrade = this.getAll().stream().filter(s -> s.getQuiz_id().equals(grade.getQuiz_id())).findFirst().get();
		if(inGrade != null) {
			inGrade.setGrade_points(grade.getGrade_points());
			return true;
		}else {
			return false;
		}
	}
}
