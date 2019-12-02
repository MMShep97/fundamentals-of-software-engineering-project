package com.canvas.config.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "student")
public class Student {
	
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
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "studentCourse", 
        joinColumns = @JoinColumn(name = "student_id") , 
        inverseJoinColumns =  @JoinColumn(name = "course_id"))
    Set<Course> courses = new HashSet<>();
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

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


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", username=" + username + "]";
	}
	

}
