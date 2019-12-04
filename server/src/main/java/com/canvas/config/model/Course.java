package com.canvas.config.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


@Table(name = "course")
@Entity
public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Id
	@Column(name ="course_id")
	private String courseId;
	
	@Column(name ="course_name")
	private String courseName;
	
	@Column(name = "instructor_id")
	private String instructor_id;
	
	@Transient
	private List<Student> students;
    
	@OneToMany(mappedBy="course_id")
    private Set<Quiz> quiz;
	
	@OneToMany(mappedBy="course_id")
    private Set<Grade> grades;
	
	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	public Course() {
		super();
	}

	public Course(String courseName, String instructor_id) {
		super();
		this.courseName = courseName;
		this.instructor_id = instructor_id;
		
	}

	public String getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInstructorId() {
		return instructor_id;
	}

	public void setInstructorId(String instructor_id) {
		this.instructor_id = instructor_id;
	}
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Set<Quiz> getQuiz() {
		return quiz;
	}

	public void setQuiz(Set<Quiz> quiz) {
		this.quiz = quiz;
	}

	
}
