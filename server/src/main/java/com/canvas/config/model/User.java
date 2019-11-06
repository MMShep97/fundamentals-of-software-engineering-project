package com.canvas.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

@Component
@Table(name = "user")
@Entity
public class User {
	

	@NotNull
	@Column(name = "FirstName")
	private String firstname;
	
	@NotNull
	@Column(name = "LastName")
	private String LastName;
	
	@Id
	@Column(name = "StudentID")
	private String email_id;
	
	@NotNull
	@Column(name = "password")
	private String password;

	public User() {
		super();
	}
	
	public User(@NotNull String firstname, String email_id , String password) {
		super();
		this.firstname = firstname;
		this.email_id = email_id;
		this.password = password;
	}

	public String getName() {
		return firstname;
	}

	public void setName(String firstname) {
		this.firstname = firstname;
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
