package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Drivers {

	@Id
	private int id;

	@NotBlank(message = "Driver name cannot be blank")
	@Size(max = 100, message = "Driver name must be less than or equal to 100 characters")
	private String driverName;

	@NotNull(message = "Driver phone number cannot be null")
	@Min(value = 1000000000, message = "Driver phone number must be at least 10 digits long") 
	private int driverPhoneNumber;

	@NotNull(message = "Truck registered number cannot be null")
	@Min(value = 1, message = "Truck registered number must be a positive integer")
	private int truckRegisteredNumber;
	
	@ManyToOne
	@JoinColumn
	Carrier carrier;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public int getDriverPhoneNumber() {
		return driverPhoneNumber;
	}

	public void setDriverPhoneNumber(int driverPhoneNumber) {
		this.driverPhoneNumber = driverPhoneNumber;
	}

	public int getTruckRegisteredNumber() {
		return truckRegisteredNumber;
	}

	public void setTruckRegisteredNumber(int truckRegisteredNumber) {
		this.truckRegisteredNumber = truckRegisteredNumber;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

}
