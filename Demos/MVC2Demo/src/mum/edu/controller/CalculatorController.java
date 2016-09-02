package mum.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.domain.Calculate;
import mum.edu.domain.Product;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.annotation.RequestMapping;
import mum.edu.framework.annotation.Controller;
import mum.edu.validator.ProductValidator;

@Controller
public class CalculatorController implements mum.edu.framework.controller.Controller {

/*@AutoWired	
 ProductValidator productValidator;*/
	
@RequestMapping(value={"/","/calculator"})
 	public String inputCalc(HttpServletRequest request, 
			HttpServletResponse response) {
	
		return "/WEB-INF/jsp/index.jsp";
	}

@RequestMapping(value="/calculate")
public String calculate(Calculate calculate, HttpServletRequest request,
		HttpServletResponse response){
	String sum="";
	try{
		Integer a1=Integer.parseInt(calculate.getAdd1());
		Integer a2=Integer.parseInt(calculate.getAdd2());
		sum=""+(a1+a2);
		calculate.setSum(sum);
	} catch(NumberFormatException e){
		if (calculate.getAdd1().isEmpty()) calculate.setAdd1("");
		if (calculate.getAdd2().isEmpty()) calculate.setAdd2("");
		calculate.setSum("");
	}
	try {
		Integer m1 = Integer.parseInt(calculate.getMult1());
		Integer m2 = Integer.parseInt(calculate.getMult2());
		calculate.setProduct("" + (m1 * m2));
		
	} catch(NumberFormatException e) {
		if (calculate.getMult1().isEmpty()) calculate.setMult1("");
		if (calculate.getMult2().isEmpty()) calculate.setMult2("");
		calculate.setProduct("");
	}
	
	//request.setAttribute("errors", calcValidator.validate(calculate));
	 request.setAttribute("calculate", calculate);
	 return "WEB-INF/jsp/calculator.jsp";
}

}
