package com.canvas.config.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canvas.config.model.Grade;
import com.canvas.config.repo.GradeRepository;

@Service
public class GradeService {

	
	@Autowired
	GradeRepository repo;
	
	List<Grade> grades = new ArrayList<>();
	/***
	 * 
	 * @return
	 */
	public List<Grade> getAll(){
		grades = repo.findAll();
		if(grades == null)
			return new ArrayList<Grade>();
		return grades;
	}
	
	/***
	 * saving the grade in the database
	 * @param grade
	 * @return it returns true if the grade is saved properly
	 */
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
	/***
	 * 
	 * search with quiz id
	 * */
	public List<Grade> getByQuizId(String quizId){
		List<Grade> listAll = this.getAll().stream().filter(s -> s.getQuiz_id().equals(quizId)).collect(Collectors.toList());
		return listAll;
	}
	/*
	 * search with course_id
	 * */
	public List<Grade> getByCourseId(String course_id){
		List<Grade> listAll = this.getAll().stream().filter(s -> s.getCourse_id().equals(course_id)).collect(Collectors.toList());
		return listAll;
	}
	/*
	 * search with student_id
	 * */
	public List<Grade> getByStudentId(String student_id){
		List<Grade> listAll = this.getAll().stream().filter(s -> s.getStudent_id().equals(student_id)).collect(Collectors.toList());
		return listAll;
	}
}
