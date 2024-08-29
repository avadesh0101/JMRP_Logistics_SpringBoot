package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Loading;
import com.example.demo.entities.Orders;
import com.example.demo.entities.Unloading;
import com.example.demo.service.LoadingService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UnloadingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private LoadingService loadingService;
	
	@Autowired
	private UnloadingService unloadingService;
	
	
	//controller to add orders by the user
	@PostMapping
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(@Valid @RequestBody Orders order , @CookieValue String userRole)
	{
		if(userRole.equals("USER")) {
			return orderService.saveOrder(order);
		}
		
		return new ResponseEntity<ResponseStructure<Orders>>(HttpStatus.FORBIDDEN);
	}
	
	
	//controller to update loading point by user
	@PutMapping
	public ResponseEntity<ResponseStructure<Loading>> updateOrder(@Valid @RequestBody Loading loading , @CookieValue String userRole)
	{
		if(userRole.equals("USER")) {
			return loadingService.saveLoading(loading);
		}
		
		return new ResponseEntity<ResponseStructure<Loading>>(HttpStatus.FORBIDDEN);
	}
	
	
	//controller to update unloading points by the user
	@PutMapping("/unloading")
    public ResponseEntity<ResponseStructure<Unloading>> updateUnloading(@Valid @RequestBody Unloading loading , @CookieValue String userRole)
    {
		if(userRole.equals("USER"))
		{
			return unloadingService.saveUnloading(loading);
		}
		
		return new ResponseEntity<ResponseStructure<Unloading>>(HttpStatus.FORBIDDEN);
    }
	
	
	//controller to add order consisting of cargo and carrier
	@PostMapping("/order")
	public ResponseEntity<ResponseStructure<Orders>> saveOrderConsistingOfCargoAndCarrier(@Valid @RequestBody Orders order , @CookieValue String userRole)
	{
		if(userRole.equals("USER"))
		{
			return orderService.saveOrder(order);
		}
		
		return new ResponseEntity<ResponseStructure<Orders>>(HttpStatus.FORBIDDEN);
	}
	
	
	//controller to modify the order by the user
	@PutMapping("/updateOrderByUser")
	public ResponseEntity<ResponseStructure<Orders>> updateOrderByUser(@Valid @RequestBody Orders order , @CookieValue String userRole)
	{
		if(userRole.equals("USER"))
		{
			return orderService.saveOrder(order);
		}
		
		return orderService.saveOrder(order);
	}
}
