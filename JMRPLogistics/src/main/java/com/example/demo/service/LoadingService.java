package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoadingDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entities.Loading;

@Service
public class LoadingService {
	
	
	@Autowired
	private LoadingDao loadingDao ;
	
	
	public ResponseEntity<ResponseStructure<Loading>> saveLoading(Loading loading)
	{
		loading.setLoadingDate(LocalDate.now());
		loading.setLoadingTime(LocalTime.now());
		Loading receivedLoading = loadingDao.saveLoading(loading);
		ResponseStructure<Loading> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedLoading);
		
		return new ResponseEntity<ResponseStructure<Loading>>(responseStructure , HttpStatus.CREATED);
		
	}
	
	
	public ResponseEntity<ResponseStructure<Loading>> findLoadingById(int id)
	{
		Loading receivedLoading = loadingDao.findLoadingById(id);
		
		ResponseStructure<Loading> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedLoading);
		
		return new ResponseEntity<ResponseStructure<Loading>>(responseStructure , HttpStatus.FOUND);
		
	}
	
	
	public ResponseEntity<ResponseStructure<Loading>> findAllLoading()
	{
		List<Loading> receivedLoading = loadingDao.findAllLoading();
		
		ResponseStructure<Loading> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Success");
		responseStructure.setListData(receivedLoading);
		
		return new ResponseEntity<ResponseStructure<Loading>>(responseStructure , HttpStatus.FOUND);
		
	}
	
	
	public ResponseEntity<ResponseStructure<Loading>> deleteLoadingById(int id)
	{
		Loading receivedLoading = loadingDao.deleteLoadingById(id);
		
		ResponseStructure<Loading> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedLoading);
		
		return new ResponseEntity<ResponseStructure<Loading>>(responseStructure , HttpStatus.NO_CONTENT);
		
	}
	
	
	

	public ResponseEntity<ResponseStructure<Loading>> updateLoadingById(Loading loading)
	{
		Loading receivedLoading = loadingDao.updateLoading(loading);
		
		ResponseStructure<Loading> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedLoading);
		
		return new ResponseEntity<ResponseStructure<Loading>>(responseStructure , HttpStatus.OK);
		
	}
	
	
	
	
	

}
