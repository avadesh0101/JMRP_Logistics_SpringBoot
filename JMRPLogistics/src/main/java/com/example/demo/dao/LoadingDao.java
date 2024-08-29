package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Loading;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.LoadingsRepository;

@Repository
public class LoadingDao {
	
	@Autowired
	private LoadingsRepository loadingRepository ;
	
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	public Loading saveLoading(Loading loading)
	{
		addressRepository.save(loading.getAddress());
		return loadingRepository.save(loading);
	}
	
	  
	public Loading findLoadingById(int id)
	{
		Optional<Loading> optional = loadingRepository.findById(id);
		if(optional.isPresent())
		{
			Loading loading = optional.get();
			return loading ;
		}
		else
		{
			return null;
		}
	}
	
	
	public Loading deleteLoadingById(int id)
	{
		Optional<Loading> optional = loadingRepository.findById(id);
		if(optional.isPresent())
		{
			Loading loading = optional.get();
			loadingRepository.delete(loading);
			return loading;
		}
		else
		{
			return null;
		}
	}
	
	
	public List<Loading> findAllLoading()
	{
		return loadingRepository.findAll();
	}

	
	public Loading updateLoading(Loading loading)
	{
		return loadingRepository.save(loading);
	}
}
