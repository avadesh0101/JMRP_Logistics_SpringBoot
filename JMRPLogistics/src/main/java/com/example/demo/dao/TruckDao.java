package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Truck;
import com.example.demo.repository.TruckRepository;

@Repository
public class TruckDao {
	
	@Autowired
	private TruckRepository truckRepository ;
	
	
	public Truck saveTruck(Truck truck)
	{
		return truckRepository.save(truck);
	}
	
	
	public Truck findTruckById(int id)
	{
		Optional<Truck> optional = truckRepository.findById(id);
		if(optional.isPresent())
		{
			Truck truck = optional.get();
			return truck;
		}
		else
		{
			return null;
		}
	}
	
	
	public List<Truck> findAllTruck()
	{
		return truckRepository.findAll();
	}
	
	
	public Truck deleteTruckById(int id)
	{
		Optional<Truck> optional = truckRepository.findById(id);
		if(optional.isPresent())
		{
			Truck truck = optional.get();
			truckRepository.delete(truck);
			return truck;
		}
		else
		{
			return null;
		}
	}
	
	public Truck updateTruckById(Truck truck)
	{
		return truckRepository.save(truck);
	}

}
