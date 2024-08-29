package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Carrier {

	@Id
	private int id;

	@NotBlank(message = "Carrier company name cannot be blank")
	@Size(max = 100, message = "Carrier company name must be less than or equal to 100 characters")
	private String carrierCompanyName;

	@NotNull(message = "Carrier contact cannot be null")
	@Min(value = 1000000000, message = "Carrier contact must be at least 10 digits long")																				
	private int carrierContact;

	@NotBlank(message = "Carrier email cannot be blank")
	@Email(message = "Carrier email must be a valid email address")
	@Size(max = 100, message = "Carrier email must be less than or equal to 100 characters")
	private String carrierEmail;
	
	@OneToMany(mappedBy = "carrier")
	List<Drivers> driver;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarrierCompanyName() {
		return carrierCompanyName;
	}

	public void setCarrierCompanyName(String carrierCompanyName) {
		this.carrierCompanyName = carrierCompanyName;
	}

	public int getCarrierContact() {
		return carrierContact;
	}

	public void setCarrierContact(int carrierContact) {
		this.carrierContact = carrierContact;
	}

	public String getCarrierEmail() {
		return carrierEmail;
	}

	public void setCarrierEmail(String carrierEmail) {
		this.carrierEmail = carrierEmail;
	}

	public List<Drivers> getDriver() {
		return driver;
	}

	public void setDriver(List<Drivers> driver) {
		this.driver = driver;
	}

}
