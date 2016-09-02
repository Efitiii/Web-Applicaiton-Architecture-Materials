package edu.mum.repository.impl;

import java.util.List;

import edu.mum.domain.Taxi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.data.Database;
import edu.mum.repository.TaxiRepository;

 
@Repository
 public class TaxiRepositoryImpl implements TaxiRepository {

	@Autowired
	Database data;
 
	@Override
	public List<Taxi> getAll() {
		return (List<Taxi>) data.taxis;
	}
	
 
	@Override
	public Taxi findByName(String name) {
		for (Taxi taxi:data.taxis ) {
			if (taxi.getName().equals(name))  			
				return taxi;
		}
		return null;
	}
	
	
		   
}
 
