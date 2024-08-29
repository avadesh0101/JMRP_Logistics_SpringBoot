package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Unloading;

public interface UnloadingRepository extends JpaRepository<Unloading,Integer> {

}
