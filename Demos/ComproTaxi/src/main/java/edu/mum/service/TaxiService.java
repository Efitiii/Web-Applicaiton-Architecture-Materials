package edu.mum.service;

import java.util.List;

import  edu.mum.domain.Taxi;

 

 public interface TaxiService   {
	
	public List<Taxi> getAll();
	
	public Taxi findByName(String name);
	
	
		   
}
 
