package com.canvas.config.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Table(name = "Account")
@Entity
public class Account {

   @Id
   @GeneratedValue
   @Column(name = "AccountID", updatable = false, nullable = false)
   @NotNull
   private Long accountId;
   @NotNull
   @Column
   private String category;
   @NotNull
   @Column
   private String username;
   @NotNull
   @Column
   private String password;
   
   public Account() {
	   super();
   }
   
   
//   public Account(@NotNull String category, @NotNull String username, @NotNull String password) {
//	super();
//	this.category = category;
//	this.username = username;
//	this.password = password;
//}


public Account(Long accountId, String category, String username, String password) {
	super();
	this.accountId = accountId;
	this.category = category;
	this.username = username;
	this.password = password;
   }

public Long getAccountId() {
	return accountId;
}

public void setAccountId(Long accountId) {
	this.accountId = accountId;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
   
	
}
