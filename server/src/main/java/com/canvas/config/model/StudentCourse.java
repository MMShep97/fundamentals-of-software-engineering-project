//package com.canvas.config.model;
//
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "studentCourse")
//public class StudentCourse {
//	@EmbeddedId
//	private StudentCourseId studentCourseId;
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((studentCourseId == null) ? 0 : studentCourseId.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		StudentCourse other = (StudentCourse) obj;
//		if (studentCourseId == null) {
//			if (other.studentCourseId != null)
//				return false;
//		} else if (!studentCourseId.equals(other.studentCourseId))
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "StudentCourse [studentCourseId=" + studentCourseId + "]";
//	}
//
//	public StudentCourse(StudentCourseId studentCourseId) {
//		super();
//		this.studentCourseId = studentCourseId;
//	}
//
//	public StudentCourseId getStudentCourseId() {
//		return studentCourseId;
//	}
//
//	public void setStudentCourseId(StudentCourseId studentCourseId) {
//		this.studentCourseId = studentCourseId;
//	}
//}
