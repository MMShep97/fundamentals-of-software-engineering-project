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
	public User(@NotNull String name, String email_id) {
		super();
		this.name = name;
		this.email_id = email_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	@NotNull
	@Column
	private String name;
	
	@Id
	@Column(name = "email_id")
	private String email_id;

	public User() {
		super();
	}
	
}
