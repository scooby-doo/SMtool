package com.endava.portlet.entity;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;


/**
 * The UserInput.java.
 *
 * @author tmoldovan
 *
 */
@Component(value="input")
public class UserInput implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	private String userName;

	@NotEmpty
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
	private String password;

	@NotEmpty
	@Email
	private String email;

	@NotNull
	@Min(13)
	@Max(30)
	private Integer age;


	public UserInput(){

	}

	public UserInput(UserInput userInput){
		this.firstName = userInput.getFirstName();
		this.lastName = userInput.getLastName();
		this.userName = userInput.getUserName();
		this.password = userInput.getPassword();
		this.email = userInput.getEmail();
		this.age = userInput.getAge();
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


}