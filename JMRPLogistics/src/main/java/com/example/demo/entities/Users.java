package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Users {

	@Id
	private int id;

	@NotBlank(message = "User name cannot be blank")
	@Size(min = 8 ,max = 50, message = "User name must be less than or equal to 50 characters")
	private String userName;

	@NotNull(message = "User phone number cannot be null")
	@Min(value = 1000000000, message = "User phone number must be at least 10 digits long") 																																													
	private int userPhoneNumber;

	@OneToOne
	private Address address;

	@NotBlank(message = "User role cannot be blank")
	@Size(min = 2 ,max = 20, message = "User role must be less than or equal to 20 characters")
	private String userRole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(int userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
