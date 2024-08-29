package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Address {

	@Id
	private int id;

	@NotBlank(message = "Street name cannot be blank")
	@Size(min = 2 , max = 100, message = "Street name must be less than or equal to 100 characters")
	private String streetName;

	@NotNull(message = "House number cannot be null")
	@Min(value = 1, message = "House number must be greater than 0")
	private int houseNumber;

	@NotNull(message = "Area pin code cannot be null")
	@Min(value = 100000, message = "Area pin code must be at least 6 digits long") 																				
	private int areaPinCode;

	@NotBlank(message = "District cannot be blank")
	@Size(min = 2 ,max = 50, message = "District name must be less than or equal to 50 characters")
	private String district;

	@NotBlank(message = "State cannot be blank")
	@Size(min = 2 ,max = 50, message = "State name must be less than or equal to 50 characters")
	private String state;

	@NotBlank(message = "Country cannot be blank")
	@Size(min=2 ,max = 50, message = "Country name must be less than or equal to 50 characters")
	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public int getAreaPinCode() {
		return areaPinCode;
	}

	public void setAreaPinCode(int areaPinCode) {
		this.areaPinCode = areaPinCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
