package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Users;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao ;
	
	
	public ResponseEntity<ResponseStructure<Users>> saveUser(Users user)
	{
		Users receivedUser = userDao.saveUser(user);
		
		ResponseStructure<Users> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedUser);
		
		return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<Users>> getUserById(int id)
	{
		Users receivedUser = userDao.findById(id);
		
		ResponseStructure<Users> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedUser);
		
		return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.FOUND);
		
	}
	
	
	public ResponseEntity<ResponseStructure<Users>> deleteUser(int id)
	{
		Users receivedUser = userDao.deleteUserById(id);
		
		ResponseStructure<Users> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedUser);
		
		return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.NO_CONTENT); 
		
	}
	
	
	public ResponseEntity<ResponseStructure<Users>> findall()
	{
		List<Users> users = userDao.findAll();
		
		ResponseStructure<Users> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Success");
		responseStructure.setListData(users);
		
		return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.FOUND);
	}
	
	
	public ResponseEntity<ResponseStructure<Users>> updateUser(Users user)
	{
		Users userReceived = userDao.saveUser(user);
		
		ResponseStructure<Users> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("OK");
		responseStructure.setData(userReceived);
		
		return new ResponseEntity<ResponseStructure<Users>>(responseStructure , HttpStatus.OK);
	}

}
