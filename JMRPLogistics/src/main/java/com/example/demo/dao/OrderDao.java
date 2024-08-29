package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Orders;
import com.example.demo.repository.CargoRepository;
import com.example.demo.repository.CarrierRepository;
import com.example.demo.repository.LoadingsRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.UnloadingRepository;
import com.example.demo.repository.UserRepository;

@Repository
public class OrderDao {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CargoRepository cargoRepository ;
	
	@Autowired
	private CarrierRepository carrierRepository;
	
	@Autowired
	private LoadingsRepository loadingRepository;
	
	@Autowired 
	private UnloadingRepository unloadingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public Orders saveOrder(Orders order)
	{  	
	   return orderRepository.save(order);
	}
	
	
	public Orders findOrderById(int id)
	{
		Optional<Orders> optional = orderRepository.findById(id);
		
		if(optional.isPresent())
		{
			Orders order = optional.get();
			return order;
		}
		else
		{
			return null;
		}
	}
	
	
	public List<Orders> findAll()
	{
		return orderRepository.findAll();
	}
	
	
	public Orders deleteById(int id)
	{
		Optional<Orders> optional = orderRepository.findById(id);
		
		if(optional.isPresent())
		{
			Orders order = optional.get();
			orderRepository.delete(order);
			return order;
		}
		else
		{
			return null;
		}
	}
	
	
	public Orders updateOrder(Orders order)
	{
		return orderRepository.save(order);
	}
	
	

}
