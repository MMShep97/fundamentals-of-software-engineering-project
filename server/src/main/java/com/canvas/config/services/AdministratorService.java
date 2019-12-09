// package com.canvas.config.services;

// import java.util.List;
// import javax.persistence.EntityManager;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.EnableTransactionManagement;

// import com.canvas.config.model.Course;
// import com.canvas.config.model.Administrator;
// import com.canvas.config.repo.CourseRepository;
// import com.canvas.config.repo.AdministratorRepository;

// @Service
// @Configuration
// @EnableTransactionManagement
// public class AdministratorService {

// 	@Autowired
// 	AdministratorRepository repo;
// 	@Autowired
// 	CourseRepository courseRepository;
// 	@Autowired
// 	EntityManager em;
	
	
// 	/***
// 	 * It returns the list of courses with administrator id
// 	 * @param administrator_id
// 	 * @return List<Course>
// 	 */
// 	@SuppressWarnings("unchecked")
// 	public List<Course> findCourse(String administrator_id){
// 		List<Course> courses = em.createNativeQuery("SELECT c.course_id ,course_name, instructor_id FROM course c INNER JOIN administrator_course s ON c.course_id = s.course_id WHERE s.administrator_id =:administrator_id")
// 		.setParameter("administrator_id", administrator_id)
// 		.getResultList();
// 		return courses;
// 	}
	
// 	/**Getting grades for administrators
// 	 * @param : It takes in the administrator id with which we can find the grades of the administrator
// 	 * @return: It returns a list of administrators
// 	 * Using repository to list all the administrators.
// 	 * */
	
// 	public List<Administrator> listAll(){
// 		return repo.findAll();
		
// 	}
	
// 	/***
// 	 * This method saves the administrator if it doesn't exist 
// 	 * @param administrator
// 	 * @return true if the administrator is saved
// 	 */
// 	public boolean save(Administrator administrator) {
// 		if(repo.existsById(administrator.getAdministratorId()) == true)
// 			return false;
// 		 if(repo.save(administrator) != null) {
// 			 return true;
// 		 }
// 		return true;
// 	}
	
// 	/***
// 	 * This method is used to get a administrator by id
// 	 * @param administratorId
// 	 * @return it returns a administrator 
// 	 */
// 	public Administrator getById(String administratorId) {
		
// 		Administrator administrator = repo.findById(administratorId).get();
// 		administrator.setCourses(this.findCourse(administratorId));
// 		return  administrator;
// 	}
// 	/**
// 	 * @param user name 
// 	 * @return administrator object is returned if the administrator the administrator is found.  
// 	 * */
// 	public Administrator getByUsername(String userName) {
// 		List<Administrator> administrators = this.listAll();
		
// 		Administrator administrator = administrators.stream().filter(s -> s.getUsername().equalsIgnoreCase(userName)).findFirst().get();
// 		administrator.setCourses(this.findCourse(userName));
		
// 		return administrator;
// 	}
	
// 	/***
// 	 * delete a administrator by his administrator id
// 	 * @param administratorId
// 	 * @return it returns true if the administrator is not found and false if the administrator is found again.
// 	 */
// 	public boolean delete(String administratorId) {
// 		repo.deleteById(administratorId);
// 			if(repo.existsById(administratorId))
// 				return false;
// 			return true;
// 	}
	
// 	/**
// 	 * Updating a administrator with a administrator object
// 	 * @param administrator object
// 	 * @return boolean true if the administrator is updated
// 	 * */
// 	public boolean update(Administrator administrator) {
// 			if(repo.existsById(administrator.getAdministratorId()) ==  false)
// 				return false;
				
// 		Administrator before = this.getById(administrator.getAdministratorId());
		
// 		if (administrator.getFirstName() != null) before.setFirstName(administrator.getFirstName());
// 		if (administrator.getCourses() != null) before.setCourses(administrator.getCourses());
// 		if (administrator.getLastName() != null) before.setLastName(administrator.getLastName());
// 		if (administrator.getPassword() != null) before.setPassword(administrator.getPassword());
// 		if (administrator.getUsername() != null) before.setUsername(administrator.getUsername());
// 		repo.save(before);
// 		return true;
// 	}
// }
