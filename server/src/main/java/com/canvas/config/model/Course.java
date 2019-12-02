package com.canvas.config.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Table(name = "course")
@Entity
public class Course{
	@NotNull
	@Id
	@Column(name ="course_id")
	private String courseId;
	
	@Column(name ="course_name")
	private String courseName;
	
	@Column(name = "instructor_id")
	private String instructor_id;
	
	@ManyToMany(mappedBy = "courses")
	private Set<Student> students = new HashSet<>();
	
	@OneToMany(mappedBy="course_id")
    private Set<Quiz> quiz;
	
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
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Quiz> getQuiz() {
		return quiz;
	}

	public void setQuiz(Set<Quiz> quiz) {
		this.quiz = quiz;
	}

	
}
