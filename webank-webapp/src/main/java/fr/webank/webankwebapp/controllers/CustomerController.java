package fr.webank.webankwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import fr.webank.webankmodels.CustomerDto;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	  @RequestMapping(value="/id",method = {RequestMethod.GET})
	    public ModelAndView getCustomer() {
		  
	        ModelAndView mav = new ModelAndView("response");
	        RestTemplate restTemplate = new RestTemplate();
	        String url = "http://data-access-service:25000/data-access-service/customer/1";
	        CustomerDto customerDto = restTemplate.getForObject(url, CustomerDto.class); 
	        mav.addObject("customer", customerDto);
	        
	        System.out.println(customerDto.toString());
	        return mav;
	        
	  }

}
