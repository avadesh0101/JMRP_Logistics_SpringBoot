package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Users;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository userRepository ;
	@Autowired
	private AddressRepository addressRepository ;
	@Autowired
	private AddressDao addressDao ;
	
	public Users saveUser(Users user)
	{
		addressRepository.save(user.getAddress());
		return userRepository.save(user);
	}
	
	
	public Users findById(int id)
	{
		Optional<Users> user = userRepository.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		else
		{
			return null;
		}
	}
	
	
	public List<Users> findAll()
	{
		return userRepository.findAll();
	}
	
	
	public Users deleteUserById(int id)
	{
		Optional<Users> optional = userRepository.findById(id);
		if(optional.isPresent())
		{
			Users user = optional.get();
			int aid = user.getAddress().getId();
			userRepository.delete(user);
			addressDao.deleteAddress(aid);
			return user ;
		}
		else
		{
			return null ;
		}
		
	}
	
	public Users updateUser(Users employee)
	{
		return userRepository.save(employee);
	}

}
