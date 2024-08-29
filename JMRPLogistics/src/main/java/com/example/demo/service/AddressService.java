package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddressDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Address;

@Service
public class AddressService {
	
	
	@Autowired
	private AddressDao addressDao ;
	
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address)
	{
		Address receivedAddress = addressDao.saveAddress(address);
		
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Address Saved");
		responseStructure.setData(receivedAddress);
		
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure , HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id)
	{
		Address receivedAddress = addressDao.deleteAddress(id);
		
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
		responseStructure.setMessage("Address Deleted");
		responseStructure.setData(receivedAddress);
		
		
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure , HttpStatus.NO_CONTENT);
		
	}

}
