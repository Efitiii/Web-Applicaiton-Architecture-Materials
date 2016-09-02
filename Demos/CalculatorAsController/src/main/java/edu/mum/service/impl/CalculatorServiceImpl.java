package edu.mum.service.impl;

import org.springframework.stereotype.Service;

import edu.mum.domain.Calculator;
import edu.mum.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService  {

	
	public void add(Calculator calculator){
		calculator.add();
		
		/*
		  if calculator.getSum() <= 0
		  	register debit
		  	notify debit processor
		 */
		return ;
	}
	
	public void mult(Calculator calculator){
		calculator.mult();
		
		/*
		  if calculator.getProduct() >  maxLimit
		  	register over budget
		  	notify overflow processor
		 */

		
		return ;
	}

}
