package com.canvas.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Table(name = "course")
@Entity
public class Course {
	@NotNull
	@GeneratedValue
	@Id
	@Column(name ="course_id")
	private int courseId;
	
	@Column(name ="course_name")
	private String courseName;
	
	@Column(name = "instructor_id")
	private String instructor_id;

	public Course() {
		super();
	}

	public Course(String courseName, String instructor_id) {
		super();
		this.courseName = courseName;
		this.instructor_id = instructor_id;
		
	}

	public int getCourseId() {
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
	
}
