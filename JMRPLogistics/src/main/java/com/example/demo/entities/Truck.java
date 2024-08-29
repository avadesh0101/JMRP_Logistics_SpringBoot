package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Truck {

	@Id
	private int id;

	@NotBlank(message = "Name cannot be blank")
	@Size(min = 2 ,max = 100, message = "Name must be less than or equal to 100 characters")
	private String name;

	@NotNull(message = "Registered number cannot be null")
	@Min(value = 1, message = "Registered number must be a positive integer")
	private int registeredNumber;

	@NotNull(message = "Capacity cannot be null")
	@Min(value = 0, message = "Capacity must be a non-negative value")
	private double capacity;

	@NotBlank(message = "Status cannot be blank")
	@Size(min = 2 ,max = 50, message = "Status must be less than or equal to 50 characters")
	private String status;

	@NotNull(message = "Carrier ID cannot be null")
	@Min(value = 1, message = "Carrier ID must be a positive integer")
	private int carrierId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegisteredNumber() {
		return registeredNumber;
	}

	public void setRegisteredNumber(int registeredNumber) {
		this.registeredNumber = registeredNumber;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(int carrierId) {
		this.carrierId = carrierId;
	}

}
