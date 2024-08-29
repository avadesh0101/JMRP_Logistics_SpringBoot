package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DriverDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Drivers;

@Service
public class DriverService {
	
	@Autowired
	private DriverDao driverDao ;
	
	
	public ResponseEntity<ResponseStructure<Drivers>> saveDriver(Drivers driver)
	{
		Drivers receivedDriver = driverDao.saveDriver(driver);
		
		ResponseStructure<Drivers> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Sucess");
		responseStructure.setData(receivedDriver);
		
		return new ResponseEntity<ResponseStructure<Drivers>>(responseStructure , HttpStatus.CREATED);
	}
	
	
//	public ResponseEntity<ResponseStructure<String>> updateById(int cid,int did)
//	{
//	   driverDao.updateCarrierId(cid,did);
//		
//		ResponseStructure<String> responseStructure = new ResponseStructure<>();
//		responseStructure.setStatusCode(HttpStatus.CREATED.value());
//		responseStructure.setMessage("Updated");
//		responseStructure.setData("Update is successfully done");
//		
//		return new ResponseEntity<ResponseStructure<String>>(responseStructure , HttpStatus.CREATED);
//	}

}
