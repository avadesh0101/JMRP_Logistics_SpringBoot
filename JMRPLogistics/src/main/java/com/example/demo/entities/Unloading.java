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
public class Unloading {

	@Id
	private int id;

	@NotBlank(message = "Company name cannot be blank")
	@Size(min=2 , max = 100, message = "Company name must be less than or equal to 100 characters")
	private String companyName;

	@NotNull(message = "Unloading date cannot be null")
	private LocalDate unloadingDate;

	@NotNull(message = "Unloading time cannot be null")
	private LocalTime unloadingTime;

	@OneToOne
	Address address;

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

	public LocalDate getUnloadingdate() {
		return unloadingDate;
	}

	public void setUnloadingdate(LocalDate unloadingDate) {
		this.unloadingDate = unloadingDate;
	}

	public LocalTime getUnloadingTime() {
		return unloadingTime;
	}

	public void setUnloadingTime(LocalTime unloadingTime) {
		this.unloadingTime = unloadingTime;
	}

}
