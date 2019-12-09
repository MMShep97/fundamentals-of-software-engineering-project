// package com.canvas.config.controller;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.canvas.config.model.Administrator;
// import com.canvas.config.services.AdministratorService;

// @RequestMapping(value = "administrator")
// @RestController
// public class AdministratorController {
	
// 	@Autowired
// 	AdministratorService service;
// 	/**
// 	 * This method gets all the values of administrators from the
// 	 * database
// 	 * @return a list of administrators
// 	 */
// 	@GetMapping(value = "getAll")
// 	public ResponseEntity<List<Administrator>> getAll(){
// 		List<Administrator> administrators = service.listAll();
// 		return new ResponseEntity<List<Administrator>>(administrators , HttpStatus.OK);
// 		//return service.listAll();
// 	}
// 	/***
// 	 * this function gets a custom object of administrator from the back end
// 	 * @param administratorId
// 	 * @return
// 	 */
// 	@GetMapping(value = "id/{email:.+}/")
// 	public Administrator getById(@PathVariable("email") String administratorId){
// 		System.out.println("administrator id is  "+ administratorId);
// 		Administrator administrator = service.getById(administratorId);
// 		return administrator;
// 	}
// 	/***
// 	 * This function gets a administrator by his user name 
// 	 * @param userName
// 	 * @return it returns the administrator object if the user is found else null
// 	 */
// 	@GetMapping(value = "username/{userName}")
// 	public Administrator getByUsername(@PathVariable("userName") String userName) {
// 		Administrator administrator = service.getByUsername(userName);
// 		return administrator;
// 	}
// 	/***
// 	 * This function saves a administrator by taking in the administrator object as
// 	 * a parameter
// 	 * @param administrator
// 	 * @return it returns true if saving is successful and false if it isn't successful
// 	 */
// 	@PostMapping(value = "save")
// 	public boolean saveAdministrator(@RequestBody Administrator administrator){
// 		return service.save(administrator);
// 	}
// 	/***
// 	 * it takes in the administrator object and updates all the values for it.
// 	 * @param administrator
// 	 * @return
// 	 */
// 	@PutMapping(value = "update")
// 	public boolean updateAdministrator(@RequestBody Administrator administrator) {
// 		if(administrator == null || administrator.getFirstName() == null || administrator.getLastName() == null || administrator.getPassword() == null|| administrator.getAdministratorId() == null)
// 			return false;
// 		boolean result = service.update(administrator);
// 		return result;
// 	}
// 	@DeleteMapping(value = "delete/")
// 	public boolean deleteAdministrator(@RequestBody Administrator administrator) {
// 		if(administrator == null)
// 			return false;
// 		try{
// 			service.delete(administrator.getAdministratorId());
// 		}catch(Exception ex) {
// 			ex.printStackTrace();
// 			return false;
// 		}
// 		return true;
		
// 	}

// }
