package com.canvas.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.canvas.config.model.User;
import com.canvas.config.services.UserService;

@RestController
public class TestController {
	@Autowired
	private UserService service;
		
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String helloWorld() {
		return "hello world";
	}
	
	@GetMapping(value = "/getAll")
	public List<User> getAll(){
		return service.listAll();
	}
	
	
	
}
