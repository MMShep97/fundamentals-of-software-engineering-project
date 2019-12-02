//package com.canvas.config.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.canvas.config.model.Account;
//import com.canvas.config.services.AccountService;
//
//@RequestMapping(value = "account/")
//@RestController
//public class AccountController {
//	
//	@Autowired
//	AccountService service;
//	
//	@GetMapping(value = "getAll")
//	public List<Account> getAll(){
//		return service.listAll();
//	}
//	
////	@GetMapping(value = "get/{accountId}")
////	public Account getById(@PathVariable("accountId") Long accountId){
////		
////		return service.getById(accountId);
////	}
//	@PostMapping(value = "save")
//	public boolean saveAccount(@RequestBody Account account){
//		return service.save(account);
//	}
//	
//	@DeleteMapping(value = "delete/{username}")
//	public void delete(@PathVariable("username") Long accountId){
//		service.delete(accountId);
//	}
//	@GetMapping(value = "get/{username}")
//	public Account getByUsername(@PathVariable("username") String username){
//		
//		return service.getByUsername(username);
//	}
//	
//
//}
