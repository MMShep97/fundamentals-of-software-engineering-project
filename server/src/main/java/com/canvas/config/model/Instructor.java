//package com.canvas.config.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import org.springframework.stereotype.Component;
//
//@Component
//@Entity
//@Table(name="Instructor")
//public class Instructor {
//
//	@NotNull
//	@Id
//	@Column(name="InstructorID")
//	private Integer InstructorId;
//	
//	@Column(name="FirstName")
//	private String  FirstName;
//	
//	@Column(name="LastName")
//	private String  LastName;
//	
//	@Column(name="AccountID")
//	private Long  AccountId;
//	
//	
//	public Instructor() {
//		super();
//	}
//	
//	public Instructor(Integer instructorId, String firstName, String lastName, Long accountId) {
//		super();
//		InstructorId = instructorId;
//		FirstName = firstName;
//		LastName = lastName;
//		AccountId = accountId;
//	}
//	public Integer getInstructorId() {
//		return InstructorId;
//	}
//	public void setInstructorId(Integer instructorId) {
//		InstructorId = instructorId;
//	}
//	public String getFirstName() {
//		return FirstName;
//	}
//	public void setFirstName(String firstName) {
//		FirstName = firstName;
//	}
//	public String getLastName() {
//		return LastName;
//	}
//	public void setLastName(String lastName) {
//		LastName = lastName;
//	}
//	public Long getAccountId() {
//		return AccountId;
//	}
//	public void setAccountId(Long accountId) {
//		AccountId = accountId;
//	}
// 	
//	
//	
//}
