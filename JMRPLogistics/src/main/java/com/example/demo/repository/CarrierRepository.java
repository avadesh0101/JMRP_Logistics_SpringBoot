package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Carrier;

public interface CarrierRepository extends JpaRepository<Carrier,Integer> {

	
	
	
}
