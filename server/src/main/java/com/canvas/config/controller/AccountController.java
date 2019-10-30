package com.canvas.config.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.canvas.config.model.Account;
import com.canvas.config.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@GetMapping(value = "account/getAll")
	public List<Account> getAll(){
		return service.listAll();
	}
	
	@GetMapping(value = "account/get/{accountId}")
	public Account getById(@PathVariable("accountId") Long accountId){
		
		return service.getById(accountId);
	}
	@PostMapping(value = "account/save")
	public boolean saveAccount(@RequestBody Account account){
		return service.save(account);
	}
	
	@DeleteMapping(value = "account/delete/{username}")
	public void delete(@PathVariable("username") Long accountId){
		service.delete(accountId);
	}
	
	

}
