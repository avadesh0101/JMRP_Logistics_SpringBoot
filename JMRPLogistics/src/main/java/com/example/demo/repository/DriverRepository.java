package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Drivers;

public interface DriverRepository extends JpaRepository<Drivers,Integer> {

//	Drivers save(List<Drivers> driver);
	
//	@Query("UPDATE Drivers d SET d.carrier_id = ?1 WHERE d.id = ?2")
//	public void updateCarrierId(int carrierId, int driverId);

}
