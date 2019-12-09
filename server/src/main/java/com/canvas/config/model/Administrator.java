 package com.canvas.config.model;

 import java.io.Serializable;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.Id;
 import javax.persistence.Table;
 import javax.validation.constraints.NotNull;


 @Entity
 @Table(name = "administrator")
 public class Administrator implements Serializable{
	
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = 1L;
 	@NotNull
 	@Id
 	@Column(name = "administrator_id")
 	private String administratorId;
 	@NotNull
 	@Column(name = "first_name")
 	private String firstName;
 	@NotNull
 	@Column(name = "last_name")
 	private String lastName;
 	@NotNull
 	@Column(name = "password")
 	private String password;
 	@NotNull
 	@Column(name = "username")
 	private String username;
 	
 	public Administrator(String administratorId,String firstName,String lastName,
 			 String password, String username) {
 		super();
 		this.administratorId = administratorId;
 		this.firstName = firstName;
 		this.lastName = lastName;
 		this.password = password;
 		this.username = username;
 	}

 	public Administrator() {
 		super();
 	}
		
 	public String getAdministratorId() {
 		return administratorId;
 	}
 	public void setAdministratorId(String AdministratorId) {
 		this.administratorId = AdministratorId;
 	}
 	public String getFirstName() {
 		return firstName;
 	}
 	public void setFirstName(String firstName) {
 		this.firstName = firstName;
 	}
 	public String getLastName() {
 		return lastName;
 	}
 	public void setLastName(String lastName) {
 		this.lastName = lastName;
 	}
 	public String getPassword() {
 		return password;
 	}
 	public void setPassword(String password) {
 		this.password = password;
 	}
 	public String getUsername() {
 		return username;
 	}

 	public void setUsername(String username) {
 		this.username = username;
 	}

 	@Override
 	public String toString() {
 		return "Administrator [administratorId=" + administratorId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
 				+ password + ", username=" + username + "]";
 	}


	

}
