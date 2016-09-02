package edu.mum.repository;

import java.util.List;

import edu.mum.domain.Taxi;

 public interface TaxiRepository   {
	
	public List<Taxi> getAll();
	
	public Taxi findByName(String name);
	
	
		   
}
 
