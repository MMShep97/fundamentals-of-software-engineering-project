package com.canvas.config.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.canvas.config.model.User;

public interface UserRepositoryStructure extends JpaRepository<User, String>{

	
}
