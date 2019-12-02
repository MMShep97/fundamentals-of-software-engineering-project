package com.canvas.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "quiz")
public class Quiz {
	@NotNull
	@Id
	@Column(name ="quizId")
	private String quizId;
	@NotNull
	@Column(name ="quiz_name")
	private String quiz_name;
	@NotNull
	@Column(name ="quiz_point")
	private String quiz_point;
	@NotNull
	@Column(name ="quiz_date")
	private String quiz_date;
	@NotNull
	@Column(name ="instructor_id")
    private String instructor_id;
	@NotNull
    @Column(name="course_id")
    private String course_id;
	public Quiz() {
		super();
	}
	public Quiz(String quizId, String quiz_name, String quiz_point, String quiz_date) {
		super();
		this.quizId = quizId;
		this.quiz_name = quiz_name;
		this.quiz_point = quiz_point;
		this.quiz_date = quiz_date;
	}
	
	
	public String getQuizId() {
		return quizId;
	}
	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}
	public String getQuiz_name() {
		return quiz_name;
	}
	public void setQuiz_name(String quiz_name) {
		this.quiz_name = quiz_name;
	}
	public String getQuiz_point() {
		return quiz_point;
	}
	public void setQuiz_point(String quiz_point) {
		this.quiz_point = quiz_point;
	}
	public String getQuiz_date() {
		return quiz_date;
	}
	public void setQuiz_date(String quiz_date) {
		this.quiz_date = quiz_date;
	}
	public String getInstructor_id() {
		return instructor_id;
	}


	public void setInstructor_id(String instructor_id) {
		this.instructor_id = instructor_id;
	}


	public String getCourse_id() {
		return course_id;
	}


	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	
}
