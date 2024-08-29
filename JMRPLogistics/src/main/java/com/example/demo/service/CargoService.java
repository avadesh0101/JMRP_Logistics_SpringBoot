package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CargoDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Cargo;

@Service
public class CargoService {
	
	@Autowired
	private CargoDao cargoDao ;
	
	
	public ResponseEntity<ResponseStructure<Cargo>> saveCargo(Cargo cargo)
	{
		Cargo receivedCargo = cargoDao.saveCargo(cargo);
		
		ResponseStructure<Cargo> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedCargo);
		
		return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure , HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<Cargo>> findAllCargo()
	{
		List<Cargo> receivedCargo = cargoDao.findAllCargo();
		
		ResponseStructure<Cargo> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Found");
		responseStructure.setListData(receivedCargo);
		
		return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure , HttpStatus.FOUND);
	}
	
	
	public ResponseEntity<ResponseStructure<Cargo>> findCargoById(int id)
	{
		Cargo receivedCargo = cargoDao.findById(id);
		
		ResponseStructure<Cargo> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Found");
		responseStructure.setData(receivedCargo);
		
		return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure , HttpStatus.FOUND);
	}
	
	
	public ResponseEntity<ResponseStructure<Cargo>> deleteCargoById(int id)
	{
		Cargo receivedCargo = cargoDao.deleteById(id);
		
		ResponseStructure<Cargo> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(receivedCargo);
		
		return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure , HttpStatus.FOUND);
	}
	
	
	public ResponseEntity<ResponseStructure<Cargo>> updateCargo(Cargo cargo)
	{
		Cargo receivedCargo = cargoDao.saveCargo(cargo);
		
		ResponseStructure<Cargo> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(receivedCargo);
		
		return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure , HttpStatus.FOUND);
		
		
	}

}
