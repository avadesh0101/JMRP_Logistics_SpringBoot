package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Truck;

public interface TruckRepository extends JpaRepository<Truck,Integer> {

}
