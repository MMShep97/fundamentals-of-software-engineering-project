//package com.canvas.config.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import org.springframework.stereotype.Component;
//
//
//@Component
//@Table(name = "Course")
//@Entity
//public class Course {
//	@NotNull
//	@GeneratedValue
//	@Id
//	@Column(name ="CourseID")
//	private Integer Courseid;
//	
//	@Column(name ="CourseName")
//	private String CourseName;
//	
//	@Column(name= "Instructorid")
//	private Integer Instructorid;
//	
//	
//	
//	
//	public Course() {
//		super();
//	
//	}
//	
//	
//	public Course(Integer courseid, String courseName, Integer instructorid) {
//		super();
//		Courseid = courseid;
//		CourseName = courseName;
//		Instructorid = instructorid;
//	}
//	public Integer getCourseid() {
//		return Courseid;
//	}
//	public void setCourseid(Integer courseid) {
//		Courseid = courseid;
//	}
//	public String getCourseName() {
//		return CourseName;
//	}
//	public void setCourseName(String courseName) {
//		CourseName = courseName;
//	}
//	public Integer getInstructorid() {
//		return Instructorid;
//	}
//	public void setInstructorid(Integer instructorid) {
//		Instructorid = instructorid;
//	}
//	
//	
//
//}
