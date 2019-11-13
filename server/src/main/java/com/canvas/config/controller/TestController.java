//package com.canvas.config.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.canvas.config.model.User;
//import com.canvas.config.services.UserService;
//
//@RestController
//public class TestController {
//	@Autowired
//	private UserService service;
//		
//	@RequestMapping(value = "/print", method = RequestMethod.GET)
//	public String helloWorld() {
//		return "hello world";
//	}
//	
//	@GetMapping(value = "/getAll")
//	public List<User> getAll(){
//		return service.listAll();
//	}
//	
//	/*@GetMapping(value = "/get/{email_id}")
//	public User getById(@PathVariable("email_id") String email_id){
//		
//	return service.getById(email_id);
//	}*/
//	@PostMapping(value = "/save")
//	public boolean save(@RequestBody User user){
//		return service.save(user);
//	}
//	
//	@DeleteMapping(value = "/delete/{email_id}")
//	public void delete(@PathVariable("email_id") String email_id){
//		service.delete(email_id);
//	}
//	
//	
//}
