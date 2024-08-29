package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Orders;
import com.example.demo.entities.Truck;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao ;
	
	
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(Orders order)
	{
		order.setDateOfOrder(LocalDate.now());
		Orders receivedOrder = orderDao.saveOrder(order);
		
		ResponseStructure<Orders> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value()); 
		responseStructure.setMessage("Saved");
		responseStructure.setData(receivedOrder);
		
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure , HttpStatus.CREATED);
		
	}
	
	
	public ResponseEntity<ResponseStructure<Orders>> findOrderById(int id)
	{
		Orders receivedOrder = orderDao.findOrderById(id);
		
		ResponseStructure<Orders> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value()); 
		responseStructure.setMessage("Found");
		responseStructure.setData(receivedOrder);
		
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure , HttpStatus.FOUND);
		
	}
	
	
	
	public ResponseEntity<ResponseStructure<Orders>> findAllOrders()
	{
		List<Orders> receivedOrder = orderDao.findAll();
		
		ResponseStructure<Orders> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value()); 
		responseStructure.setMessage("Found");
		responseStructure.setListData(receivedOrder);;
		
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure , HttpStatus.FOUND);
		
	}
	
	
	public ResponseEntity<ResponseStructure<Orders>> updateOrder(Orders order)
	{
		Orders receivedOrder = orderDao.updateOrder(order);
		
		ResponseStructure<Orders> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value()); 
		responseStructure.setMessage("Updated");
		responseStructure.setData(receivedOrder);
		
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure , HttpStatus.OK);
		
	}
	
	
	public ResponseEntity<ResponseStructure<Orders>> deleteOrder(int id)
	{
		Orders receivedOrder = orderDao.deleteById(id);
		
		ResponseStructure<Orders> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value()); 
		responseStructure.setMessage("Deleted");
		responseStructure.setData(receivedOrder);
		
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure , HttpStatus.NO_CONTENT);
		
	}
	
}
