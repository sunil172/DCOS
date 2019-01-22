package com.dcos.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.dcos.validation.PasswordMatches;

@Entity
@PasswordMatches
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id; 
	
	@NotEmpty(message = "First Name is required")
	private String fname; 
	
	@NotEmpty(message = "Last Name is required")
	private String lname; 
	
	@Email
	@NotEmpty(message = "Email is required")
	private String email;
	
	@NotEmpty(message = "Password is required")
	private String password;
	
	@Transient
	@NotEmpty(message= "Password confirmation is required")
	private String confirmPassword; 
	
	private Calendar created = Calendar.getInstance();

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", created=" + created + "]";
	}
	
}
