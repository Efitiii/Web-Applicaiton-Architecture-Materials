package edu.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.domain.User;

@Controller
@SessionAttributes("userName")
public class LoginController {
	
	@RequestMapping(value= {"/","login"}, method = RequestMethod.GET)
	public String login() {
 
		return "login";
	}
	
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(User user, Model model) {
		
		// Session Attribute
		model.addAttribute("userName", user.getName());
 
		return "redirect:product_input.action";
	}
	
	
	@RequestMapping(value="logout")
	public String logout(SessionStatus status) {
		
		status.setComplete();
 
		return "redirect:login";
	}
	
	

}
