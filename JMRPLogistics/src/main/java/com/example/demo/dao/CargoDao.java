package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Cargo;
import com.example.demo.repository.CargoRepository;

@Repository
public class CargoDao {
	
	
	@Autowired
	private CargoRepository cargoRepository;
	
	
	public Cargo saveCargo(Cargo cargo)
	{
		return cargoRepository.save(cargo);
	}
	
	
	public Cargo findById(int id)
	{
		Optional<Cargo> optional = cargoRepository.findById(id);
		if(optional.isPresent())
		{
			Cargo cargo = optional.get();
			return cargo ;
		}
		else
		{
			return null;
		}
		
	}
	
	
	public List<Cargo> findAllCargo()
	{
		return cargoRepository.findAll();
	}
	
	
	public Cargo deleteById(int id)
	{
		Optional<Cargo> optional = cargoRepository.findById(id);
		if(optional.isPresent())
		{
			Cargo cargo = optional.get();
			cargoRepository.delete(cargo);
			return cargo;
		}
		else
		{
			return null ;
		}
	
	}
	
	
	public Cargo updateById(Cargo cargo)
	{
		return cargoRepository.save(cargo);
	}

}
