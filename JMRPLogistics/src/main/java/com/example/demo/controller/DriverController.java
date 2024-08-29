package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Drivers;
import com.example.demo.service.DriverService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	//controller to update personal information of the driver
	@PutMapping
	public ResponseEntity<ResponseStructure<Drivers>> updateDriver(@Valid @RequestBody Drivers driver , @CookieValue String userRole )
	{
		if(userRole.equals("DRIVER")) {
			return driverService.saveDriver(driver);	
		}
		
		return new ResponseEntity<ResponseStructure<Drivers>>(HttpStatus.FORBIDDEN);
	}

}
