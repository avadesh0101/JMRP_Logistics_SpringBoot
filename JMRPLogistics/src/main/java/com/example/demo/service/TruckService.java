package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TruckDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Truck;

@Service
public class TruckService {
	
	@Autowired
	private TruckDao truckDao ;
	
	public ResponseEntity<ResponseStructure<Truck>> saveTruck(Truck truck)
	{
		Truck receivedTruck = truckDao.saveTruck(truck);
		
		ResponseStructure<Truck> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value()); 
		responseStructure.setMessage("Saved");
		responseStructure.setData(receivedTruck);
		
		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure , HttpStatus.CREATED);
		
	}
	
	
	public ResponseEntity<ResponseStructure<Truck>> findTruckById(int id)
	{
		Truck receivedTruck = truckDao.findTruckById(id);
		
		ResponseStructure<Truck> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value()); 
		responseStructure.setMessage("Found");
		responseStructure.setData(receivedTruck);
		
		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure , HttpStatus.FOUND);
		
	}  
	
	
	
	public ResponseEntity<ResponseStructure<Truck>> deleteTruckById(int id)
	{
		Truck receivedTruck = truckDao.deleteTruckById(id);
		
		ResponseStructure<Truck> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value()); 
		responseStructure.setMessage("Deleted");
		responseStructure.setData(receivedTruck);
		
		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure , HttpStatus.NO_CONTENT);
		
	}  
	
	
	public ResponseEntity<ResponseStructure<Truck>> findAllTruck()
	{
		List<Truck> receivedTruck = truckDao.findAllTruck();
		
		ResponseStructure<Truck> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value()); 
		responseStructure.setMessage("Found");
		responseStructure.setListData(receivedTruck);
		
		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure , HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<Truck>> updateTruckById(Truck truck)
	{
		Truck receivedTruck = truckDao.saveTruck(truck);
		
		ResponseStructure<Truck> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value()); 
		responseStructure.setMessage("Updated");
		responseStructure.setData(receivedTruck);
		
		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure , HttpStatus.OK);
	}
    

}
