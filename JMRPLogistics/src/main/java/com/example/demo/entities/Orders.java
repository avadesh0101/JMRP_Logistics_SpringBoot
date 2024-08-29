package com.example.demo.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Orders {

	@Id
	private int id;

	@NotNull(message = "Date of order cannot be null")
	private LocalDate dateOfOrder;

	@NotBlank(message = "Order status cannot be blank")
	@Size(min = 2 ,max = 50, message = "Order status must be less than or equal to 50 characters")
	private String orderStatus;

	@NotNull(message = "Freight cost cannot be null")
	@Min(value = 0, message = "Freight cost must be a non-negative value")
	private double freightCost;

	@Size(max = 255, message = "Additional info must be less than or equal to 255 characters")
	private String additionalInfo;

	@ManyToOne
	Carrier carrier;

	@OneToOne
	Cargo cargo;

	@OneToOne
	Loading loading;

	@OneToOne
	Unloading unloading;

	@ManyToMany
	List<Users> loadingUser;

	@ManyToMany
	List<Users> unloadingUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getFreightCost() {
		return freightCost;
	}

	public void setFreightCost(double freightCost) {
		this.freightCost = freightCost;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Loading getLoading() {
		return loading;
	}

	public void setLoading(Loading loading) {
		this.loading = loading;
	}

	public Unloading getUnloading() {
		return unloading;
	}

	public void setUnloading(Unloading unloading) {
		this.unloading = unloading;
	}

	public List<Users> getLoadingUser() {
		return loadingUser;
	}

	public void setLoadingUser(List<Users> loadingUser) {
		this.loadingUser = loadingUser;
	}

	public List<Users> getUnloadingUser() {
		return unloadingUser;
	}

	public void setUnloadingUser(List<Users> unloadingUser) {
		this.unloadingUser = unloadingUser;
	}

}
