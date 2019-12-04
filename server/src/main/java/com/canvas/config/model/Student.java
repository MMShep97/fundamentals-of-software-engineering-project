package com.canvas.config.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "student")
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Id
	@Column(name = "student_id")
	private String studentId;
	@NotNull
	@Column(name = "first")
	private String firstName;
	@NotNull
	@Column(name = "last")
	private String lastName;
	@NotNull
	@Column(name = "password")
	private String password;
	@NotNull
	@Column(name = "username")
	private String username;
	@Transient
    List<Course> courses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student_id")
    private List<Grade> grades;
	
	
	public Student(String studentId,String firstName,String lastName,
			 String password, String username) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
	}

	public Student() {
		super();
	}
		
	public void addCourses(Course course) {
		courses.add(course);
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", username=" + username + ", courses=" + courses + ", grades=" + grades + "]";
	}


	

}
