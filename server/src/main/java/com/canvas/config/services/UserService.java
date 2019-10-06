package com.canvas.config.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canvas.config.model.User;
import com.canvas.config.repo.UserRepositoryStructure;

@Service
public class UserService{

	@Autowired
	UserRepositoryStructure repo;
	
	public List<User> listAll(){
		return repo.findAll();
		
	}
	
	public boolean save(User user) {
		 if(repo.save(user) != null) {
			 return true;
		 }
		return false;
	}
	
	public User getById(String id) {
		return repo.getOne(id);
	}
	
}
