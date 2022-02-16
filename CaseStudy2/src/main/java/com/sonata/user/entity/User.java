package com.sonata.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                        // To Make 'UserEntity' Class as JPA Entity
@Table(name = "users")                        // To Provide Table Details
public class User {
	
	@Id                // To Set id as primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "First_Name")
	private String firstname;
	
	@Column(name = "Last_Name")
	private String lastname;
	
	@Column(name = "Email")
	private String email;
	
// Create Constructor
	public User () {
		
	}
	public User(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
// Create Getter and Setter to access Private Fields
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}

