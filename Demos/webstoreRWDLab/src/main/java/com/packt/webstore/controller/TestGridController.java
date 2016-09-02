package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 

@Controller
public class TestGridController {
	
	// Exercise Bootstrap Grid layout for varying device sizes

	@RequestMapping(value = "/testGrid", method = RequestMethod.GET)
 	public String getAddNewMemberForm() {
		
		return "testGrid";
	}
	   
 
  
}
