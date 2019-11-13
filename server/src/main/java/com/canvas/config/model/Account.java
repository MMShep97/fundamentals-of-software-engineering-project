//package com.canvas.config.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import org.springframework.stereotype.Component;
//
//@Component
//@Table(name = "Account")
//@Entity
//public class Account {
//
//   @Id
//   @GeneratedValue
//   @NotNull
//   @Column(name = "AccountID", updatable = false, nullable = false)
//   private Long accountId;
//   @NotNull
//   @Column(name="Category")
//   private String category;
//   @NotNull
//   @Column(name = "Username")
//   private String username;
//   @NotNull
//   @Column(name ="Password")
//   private String password;
//   
////   @OneToOne(mappedBy = "account")
////   private Student student;
//   
//   public Account() {
//	   super();
//   }
//   
//	
//	public Account(Long accountId, String category, String username, String password) {
//		super();
//		this.accountId = accountId;
//		this.category = category;
//		this.username = username;
//		this.password = password;
////		this.student = student;
////		this.student.setAccount(this);
//	   }
//	
//	public Long getAccountId() {
//		return accountId;
//	}
//	
//	public void setAccountId(Long accountId) {
//		this.accountId = accountId;
//	}
//	
//	public String getCategory() {
//		return category;
//	}
//	
//	public void setCategory(String category) {
//		this.category = category;
//	}
//	
//	public String getUsername() {
//		return username;
//	}
//	
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	
//	public String getPassword() {
//		return password;
//	}
//	
//	public void setPassword(String password) {
//		this.password = password;
//	}
////	public Student getStudent() {
////		return student;
////	}
////	
////	
////	public void setStudent(Student student) {
////		this.student = student;
////	}
//
//	
//}
