package com.canvas.config.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canvas.config.model.User;
import com.canvas.config.repo.UserRepositoryStructure;

@Service
public class UserService{

	@Autowired
	UserRepositoryStructure repo;
	
	ArrayList<User> users = new ArrayList<User>();
	
	public List<User> listAll(){
		return repo.findAll();
		
	}
	
	public boolean save(User user) {
		 if(repo.save(user) != null) {
			 return true;
		 }
		return false;
	}
	
	public User getById(String email_id) {
		User user  = repo.findAll().stream().filter(u -> u.getEmail_id().equalsIgnoreCase(email_id)).findFirst().get();
		return  user;
	}
	
	public void delete(String email_id) {
		repo.deleteById(email_id);
	}
	
}
