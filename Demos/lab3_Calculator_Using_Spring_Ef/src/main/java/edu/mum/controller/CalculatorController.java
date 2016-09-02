package edu.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculatorController {
	
	@RequestMapping (value={"/"}, method=RequestMethod.GET)
	public String inputCalc(){
		return "CalculatorFrom";
	}
	
}
