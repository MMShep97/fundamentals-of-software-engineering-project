package com.canvas.config.model;

import org.springframework.stereotype.Component;

@Component
public class StudentCourse {
	
	@Override
	public String toString() {
		return "StudentCourse [student_id=" + student_id + ", course_id=" + course_id + "]";
	}
	String student_id;
	String course_id;
	public StudentCourse() {
		super();
	}
	
	public StudentCourse(String student_id, String course_id) {
		super();
		this.student_id = student_id;
		this.course_id = course_id;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course_id == null) ? 0 : course_id.hashCode());
		result = prime * result + ((student_id == null) ? 0 : student_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCourse other = (StudentCourse) obj;
		if (course_id == null) {
			if (other.course_id != null)
				return false;
		} else if (!course_id.equals(other.course_id))
			return false;
		if (student_id == null) {
			if (other.student_id != null)
				return false;
		} else if (!student_id.equals(other.student_id))
			return false;
		return true;
	}
	
}
