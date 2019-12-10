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
import javax.validation.constraints.NotEmpty;


@Table(name = "course")
@Entity
public class Course implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="course name cannot be empty")
	@Id
	@Column(name ="course_id")
	private String courseId;

	@NotEmpty(message="course name cannot be empty")
	@Column(name ="course_name")
	private String courseName;
	

	@NotEmpty(message="instructor id cannot be empty")
	@Column(name = "instructor_id")
	private String instructor_id;
	@Column
	private Double cost;
	

	@Column
	private String courseDescription;
	
	

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

	public Course(String courseName, String instructor_id, Double cost, String courseDescription) {
		super();
		this.courseName = courseName;
		this.instructor_id = instructor_id;
		this.cost = cost;
		this.courseDescription = courseDescription;
		
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

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}public String getInstructor_id() {
		return instructor_id;
	}

	public void setInstructor_id(String instructor_id) {
		this.instructor_id = instructor_id;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", instructor_id=" + instructor_id
				+ ", cost=" + cost + ", courseDescription=" + courseDescription + ", students=" + students + ", quiz="
				+ quiz + ", grades=" + grades + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((courseDescription == null) ? 0 : courseDescription.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((grades == null) ? 0 : grades.hashCode());
		result = prime * result + ((instructor_id == null) ? 0 : instructor_id.hashCode());
		result = prime * result + ((quiz == null) ? 0 : quiz.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
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
		Course other = (Course) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (courseDescription == null) {
			if (other.courseDescription != null)
				return false;
		} else if (!courseDescription.equals(other.courseDescription))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (grades == null) {
			if (other.grades != null)
				return false;
		} else if (!grades.equals(other.grades))
			return false;
		if (instructor_id == null) {
			if (other.instructor_id != null)
				return false;
		} else if (!instructor_id.equals(other.instructor_id))
			return false;
		if (quiz == null) {
			if (other.quiz != null)
				return false;
		} else if (!quiz.equals(other.quiz))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

	
}
