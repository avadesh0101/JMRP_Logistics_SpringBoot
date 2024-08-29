package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Cargo {

	@Id
	private int id;

	@NotBlank(message = "Cargo name cannot be blank")
	@Size(min = 2 ,max = 100, message = "Cargo name must be less than or equal to 100 characters")
	private String cargoName;

	@Size(min = 2 ,max = 255, message = "Cargo description must be less than or equal to 255 characters")
	private String cargoDescription;

	@NotNull(message = "Cargo weight cannot be null")
	@Min(value = 0, message = "Cargo weight must be a positive value")
	private double cargoWeight;

	@NotNull(message = "Cargo count cannot be null")
	@Min(value = 0, message = "Cargo count must be a non-negative integer")
	private int cargoCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargoName() {
		return cargoName;
	}

	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}

	public String getCargoDescription() {
		return cargoDescription;
	}

	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}

	public double getCargoWeight() {
		return cargoWeight;
	}

	public void setCargoWeight(double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

	public int getCargoCount() {
		return cargoCount;
	}

	public void setCargoCount(int cargoCount) {
		this.cargoCount = cargoCount;
	}

}
