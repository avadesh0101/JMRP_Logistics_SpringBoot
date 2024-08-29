package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UnloadingDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Unloading;

@Service
public class UnloadingService {
	
	
	@Autowired
	private UnloadingDao unloadingDao ;
	
	
	public ResponseEntity<ResponseStructure<Unloading>> saveUnloading(Unloading unloading)
	{
		unloading.setUnloadingdate(LocalDate.now());
		unloading.setUnloadingTime(LocalTime.now());
		Unloading receivedUnloading = unloadingDao.saveUnloading(unloading);
		
		ResponseStructure<Unloading> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedUnloading);
		
		return new ResponseEntity<ResponseStructure<Unloading>>(responseStructure,HttpStatus.CREATED);
		
	}

}
