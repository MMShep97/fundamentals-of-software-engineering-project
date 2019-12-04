package com.canvas.config.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="instructor")
public class Instructor {

	@NotNull
	@Id
	@Column(name="instructor_id")
	private String InstructorId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name ="password")
	private String password;
	
	@Column(name="first_name")
	private String  FirstName;
	
	@Column(name="last_name")
	private String  LastName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor_id")
    private List<Course> courses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor_id")
	private List<Grade> grades;
	
	public Instructor() {
		super();
	}

	public Instructor(String instructorId, String username, String password, String firstName,
			String lastName) {
		super();
		InstructorId = instructorId;
		this.username = username;
		this.password = password;
		FirstName = firstName;
		LastName = lastName;
	}

	public String getInstructorId() {
		return InstructorId;
	}

	public void setInstructorId(String instructorId) {
		InstructorId = instructorId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
//	public Set<Quiz> getQuiz() {
//		return quiz;
//	}
//
//	public void setQuiz(Set<Quiz> quiz) {
//		this.quiz = quiz;
//	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	
	
	
}