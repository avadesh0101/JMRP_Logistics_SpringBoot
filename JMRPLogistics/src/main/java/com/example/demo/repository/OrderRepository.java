package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Orders;

public interface OrderRepository extends JpaRepository<Orders,Integer> {

}
