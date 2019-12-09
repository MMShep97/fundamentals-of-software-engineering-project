package com.canvas.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "grade")
public class Grade {
	@NotNull
	@Column
	private String quiz_id;
	@NotNull
	@Column
	private String course_id;
	@NotNull
	@Column
	private String instructor_id;
	@NotNull
	@Column
	private String student_id;
	@NotNull
	@Column
	private Double grade_points;
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	public Grade() {
		
	}
	public Grade(@NotNull String quiz_id, @NotNull String course_id, @NotNull String instructor_id,
			@NotNull String student_id, @NotNull Double grade_points) {
		super();
		this.quiz_id = quiz_id;
		this.course_id = course_id;
		this.instructor_id = instructor_id;
		this.student_id = student_id;
		this.grade_points = grade_points;
	}
	
	public String getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(String quiz_id) {
		this.quiz_id = quiz_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(String instructor_id) {
		this.instructor_id = instructor_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public double getGrade_points() {
		return grade_points;
	}
	public void setGrade_points(double grade_points) {
		this.grade_points = grade_points;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
