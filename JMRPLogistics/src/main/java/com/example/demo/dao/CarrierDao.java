package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Carrier;
import com.example.demo.entities.Drivers;
import com.example.demo.repository.CarrierRepository;
import com.example.demo.repository.DriverRepository;

@Repository
public class CarrierDao {
	
	
	@Autowired
	private CarrierRepository carrierRepository ;
	
	
	@Autowired
	private DriverRepository driverRepository;
	
	public Carrier saveCarrier(Carrier carrier)
	{
		
		driverRepository.save(carrier.getDriver().get(0));
		
		return carrierRepository.save(carrier);
	}
	
	
	public Carrier findCarrierById(int id)
	{
		Optional<Carrier> optional = carrierRepository.findById(id);
	    if(optional.isPresent())
	    {
	    	Carrier carrier = optional.get();
	    	return carrier;
	    }
	    else
	    {
	    	return null;
	    }
	}
	
	
	public List<Carrier> findAllCarrier()
	{
		return carrierRepository.findAll();
	}
	
	
	public Carrier deleteCarrierById(int id)
	{
		Optional<Carrier> optional = carrierRepository.findById(id);
		if(optional.isPresent())
		{
			Carrier carrier = optional.get();
			carrierRepository.delete(carrier);
			return carrier;
		}
		else
		{
			return null;
		}
	}
	
	
	public Carrier updateCarrier(Carrier carrier)
	{
		return carrierRepository.save(carrier);
	}

}
