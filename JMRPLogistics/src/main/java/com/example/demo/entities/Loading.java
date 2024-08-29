package com.example.demo.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Loading {

	@Id
	private int id;

	@NotBlank(message = "Company name cannot be blank")
	@Size(min=2 ,max = 100, message = "Company name must be less than or equal to 100 characters")
	private String companyName;

	@NotNull(message = "Address cannot be null")
	@OneToOne
	private Address address;

	@NotNull(message = "Loading date cannot be null")
	private LocalDate loadingDate;

	@NotNull(message = "Loading time cannot be null")
	private LocalTime loadingTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDate getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(LocalDate loadingDate) {
		this.loadingDate = loadingDate;
	}

	public LocalTime getLoadingTime() {
		return loadingTime;
	}

	public void setLoadingTime(LocalTime loadingTime) {
		this.loadingTime = loadingTime;
	}

}
