package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Address;
import com.example.demo.repository.AddressRepository;

@Repository
public class AddressDao {
	
	@Autowired
	private AddressRepository addressRepository ;
	
	
	public Address saveAddress(Address address)
	{
		return addressRepository.save(address);
	}

	
	public Address findAddressById(int id)
	{
		Optional<Address> optional = addressRepository.findById(id);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
		{
			return null ;
		}
	}
	
	
	public List<Address> findAllAddress()
	{
		return addressRepository.findAll();
	}
	
	
	public Address deleteAddress(int id)
	{
		Optional<Address> optional = addressRepository.findById(id);
		if(optional.isPresent())
		{
			Address address = optional.get();
		    addressRepository.delete(address);
		    return address;
		}
		else
		{
			return null;
		}
	}
	
	
	public Address updateAddress(Address address)
	{
		return addressRepository.save(address);
	}
	
}
