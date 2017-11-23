package fr.webank.webankwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import fr.webank.webankmodels.AccountDto;

@Controller
@RequestMapping("/account")
public class AccountController {
		
		  @RequestMapping(value="/id",method = {RequestMethod.GET})
		    public ModelAndView getAccount() {
			  
		        ModelAndView mav = new ModelAndView("response2"); //param dans jsp qui est formation
		        RestTemplate restTemplate = new RestTemplate();
		        String url = "http://localhost:25000/data-access-service/account/1";
		        AccountDto accountDto = restTemplate.getForObject(url, AccountDto.class); 
		        mav.addObject("account", accountDto);
		        
		        System.out.println(accountDto.toString());
		        return mav;
		  }
 }

	


