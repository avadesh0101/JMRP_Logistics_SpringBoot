package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Unloading;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UnloadingRepository;

@Repository
public class UnloadingDao {

	@Autowired
	private UnloadingRepository unloadingRepository ;
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	public Unloading saveUnloading(Unloading unloading)
	{
		addressRepository.save(unloading.getAddress());
		return unloadingRepository.save(unloading);
	}
	
	
}
