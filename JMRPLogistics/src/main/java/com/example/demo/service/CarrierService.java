package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.CarrierDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Carrier;

@Repository
public class CarrierService {
	
	
	@Autowired
    private CarrierDao carrierDao ;
	
	
	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(Carrier carrier)
	{
		Carrier receivedCarrier = carrierDao.saveCarrier(carrier);
		
		ResponseStructure<Carrier> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Sucess");
		responseStructure.setData(receivedCarrier);
		
		return new ResponseEntity<ResponseStructure<Carrier>>(responseStructure , HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<Carrier>> findCarrierbyId(int id)
	{
		Carrier receivedCarrier = carrierDao.findCarrierById(id);
		
		ResponseStructure<Carrier> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Found");
		responseStructure.setData(receivedCarrier);
		
		return new ResponseEntity<ResponseStructure<Carrier>>(responseStructure , HttpStatus.FOUND);
	}
	
	
	public ResponseEntity<ResponseStructure<Carrier>> findAllCarrier()
	{
		List<Carrier> receivedCarrier = carrierDao.findAllCarrier();
		
		ResponseStructure<Carrier> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Found");
		responseStructure.setListData(receivedCarrier);
		
		return new ResponseEntity<ResponseStructure<Carrier>>(responseStructure , HttpStatus.FOUND);
	}
	
	
	public ResponseEntity<ResponseStructure<Carrier>> deletedCarrierById(int id)
	{
		Carrier receivedCarrier = carrierDao.deleteCarrierById(id);
		
		ResponseStructure<Carrier> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(receivedCarrier);
		
		return new ResponseEntity<ResponseStructure<Carrier>>(responseStructure , HttpStatus.NO_CONTENT);
	}
	
	
	public ResponseEntity<ResponseStructure<Carrier>> updateCarrier(Carrier carrier)
	{
		Carrier receivedCarrier = carrierDao.updateCarrier(carrier);
		
		ResponseStructure<Carrier> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(receivedCarrier);
		
		return new ResponseEntity<ResponseStructure<Carrier>>(responseStructure , HttpStatus.OK);
	}
	
	
	
}
