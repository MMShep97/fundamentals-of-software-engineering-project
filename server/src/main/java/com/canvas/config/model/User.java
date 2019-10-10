package com.canvas.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
@Table(name = "user")
@Entity
public class User {
	

	@NotNull
	@Column(name = "username")
	private String username;
	
	@Id
	@Column(name = "email_id")
	private String email_id;
	
	@NotNull
	@Column(name = "password")
	private String password;

	public User() {
		super();
	}
	
	public User(@NotNull String username, String email_id , String password) {
		super();
		this.username = username;
		this.email_id = email_id;
		this.password = password;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
