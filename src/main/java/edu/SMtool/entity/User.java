package edu.SMtool.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Users", uniqueConstraints = {
		@UniqueConstraint(columnNames="email"),
		@UniqueConstraint(columnNames="username")})
public class User implements Serializable {

	private static final long serialVersionUID = 1539254004434512493L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name  = "idUser")
	private int id;
	
	@NotEmpty(message="first name is empty")
	@Column(name = "firstName")
	private String firstName;
	
	@NotEmpty(message="last name is missing")
	@Column(name = "lastName")
	private String lastName;
	
	@NotEmpty
	@Column(name = "userName", unique=true)
	private String userName;
	
	@NotEmpty
	@Pattern(message="password must contain at least: one digit, one lower case character, one upper case character and one special @#$%. Password length must be between 6 and 20 characters", regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
	@Column(name = "ppassword")
	private String password;
	
	
	@Email
	@Column(name = "email", unique=true)
	private String email;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	}
