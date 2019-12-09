package com.canvas.config.services;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canvas.config.model.StudentCourse;

@Service
public class StudentCourseService {
		
	@Autowired
	EntityManager em;
	
	/***
	 * This method registers a course for a student
	 * @param studentCourse
	 * @return true or false depending on whether the execution was correct or not
	 */
	@Transactional
	public boolean isRegisteredForCourse(StudentCourse studentCourse) {
		String student_id = studentCourse.getStudent_id();
		String course_id = studentCourse.getCourse_id();
		try{
			em.createNativeQuery("INSERT into student_course(course_id,student_id) values(:course_id , :student_id)")
							.setParameter("course_id", course_id)
							.setParameter("student_id", student_id)
							.executeUpdate();
		}catch(SQLGrammarException ex) {
			System.out.println("Something wrong in the statement"+ex);
			return false;
		}
		return true;
		
	}
	/***
	 * This method gets all the users from the student course table and 
	 * displays them.
	 * @return List of student course
	 */
	public List<StudentCourse> getAll(){
		@SuppressWarnings("unchecked")
		List<StudentCourse> allRegistered = em.createNativeQuery("SELECT * FROM student_course").getResultList();
		return allRegistered;
	}
	
	/***
	 * Drop a course.
	 * @param : It takes in the object of student course.
	 * @return : returns true if the object gets deleted else false.
	 * 
	 */
	@Transactional
	public boolean isDropped(StudentCourse studentCourse) {
		try {
			if(isExist(studentCourse)) {
				em.createNativeQuery("DELETE from student_course WHERE student_id =:id AND course_id = :c_id")
				.setParameter("id", studentCourse.getStudent_id())
				.setParameter("c_id", studentCourse.getCourse_id())
				.executeUpdate();
			}
		}catch(SQLGrammarException e) {
			System.out.println(" something is wrong try again " + e);
			return false;
		}
		
		return true;
	}
	/***
	 * It checks whether the given record exists in the table or not.
	 * @param sc
	 * @return true if record exists/ false if record is not found.
	 */
	public boolean isExist(StudentCourse sc) {
		@SuppressWarnings("unchecked")
		List<String> list = em.createNativeQuery("SELECT course_id FROM student_course WHERE student_id =:id")
													.setParameter("id", sc.getStudent_id())
													.getResultList();
		for(String c : list) {
			if(c.equalsIgnoreCase(sc.getCourse_id()))
				return true;
		}
		return false;
		
	}
}
