package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Drivers;
import com.example.demo.repository.CarrierRepository;
import com.example.demo.repository.DriverRepository;

@Repository
public class DriverDao {

	@Autowired
	private DriverRepository driverRepository ;
	
	@Autowired
	private CarrierRepository carrierRepository;
	
	
	public Drivers saveDriver(Drivers driver)
	{
		carrierRepository.save(driver.getCarrier());
		return driverRepository.save(driver);
	}
	
	
	public List<Drivers> saveAllDriver()
	{
		return driverRepository.findAll();
	}
	
	
	public Drivers updateDriver(Drivers driver)
	{
		return driverRepository.save(driver);
	}
	
	
	public Drivers deleteDriver(int id)
	{
		Optional<Drivers> optional = driverRepository.findById(id);
		if(optional.isPresent())
		{
			Drivers driver = optional.get();
			driverRepository.delete(driver);
			return driver;
		}
		else
		{
			return null;
		}
	}
	
	
	public Drivers findById(int id)
	{
		Optional<Drivers> optional = driverRepository.findById(id);
		if(optional.isPresent())
		{
			Drivers driver = optional.get();
			return driver;
		}
		else
		{
			return null;
		}
	}
	
//	public void updateCarrierId(int cid , int did)
//	{
//		driverRepository.updateCarrierId(cid,did);
//	}
}
