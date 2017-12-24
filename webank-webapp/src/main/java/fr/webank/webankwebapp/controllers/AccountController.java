package fr.webank.webankwebapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import fr.webank.webankmodels.AccountDto;
import fr.webank.webankmodels.CustomerDto;
import fr.webank.webankmodels.NotificationDTO;
import fr.webank.webankmodels.StockDto;
import fr.webank.webankmodels.StockPriceDto;
import fr.webank.webankmodels.TransactionDto;

@Controller
@RequestMapping("/account")
public class AccountController {
		
		  @RequestMapping(value="/id",method = {RequestMethod.GET})
		    public ModelAndView getAccountForDemo() {
			  
		        ModelAndView mav = new ModelAndView("Notifier/accountById");
		        RestTemplate restTemplate = new RestTemplate();
		        String url = "http://10.168.1.4:25000/data-access-service/account/1";
		        AccountDto accountDto = restTemplate.getForObject(url, AccountDto.class); 
		        mav.addObject("account", accountDto);
		        
		        System.out.println(accountDto.toString());
		        return mav;
		  }
		  
		  @RequestMapping(value="/id/accueilClient",method = {RequestMethod.GET})
		    public ModelAndView getAccountHomePage() {
			  
		        ModelAndView mav = new ModelAndView("Notifier/PersonalAccountHomePage");
		        RestTemplate restTemplate = new RestTemplate();
		        String url = "http://10.168.1.4:25000/data-access-service/account/1";
		        AccountDto accountDto = restTemplate.getForObject(url, AccountDto.class); 
		        mav.addObject("account", accountDto);
		        
		        List<NotificationDTO> notificationDto = new ArrayList<NotificationDTO>();
		        
		        RestTemplate restTemplate2 = new RestTemplate();
		        ResponseEntity<List> responseEntity = restTemplate2.getForEntity("http://localhost:25000/data-access-service/notifications/1",List.class);

		        notificationDto = responseEntity.getBody();

		        mav.addObject("notification", notificationDto);
		        
		        System.out.println(accountDto.toString());
		        return mav;
		  }
		  
		  @RequestMapping(value="/id/monCompte",method = {RequestMethod.GET})
		    public ModelAndView getAccount() {
			  
		        ModelAndView mav = new ModelAndView("Notifier/PersonalAccount");
		        RestTemplate restTemplate = new RestTemplate();
		        String url = "http://10.168.1.4:25000/data-access-service/account/1";
		        AccountDto accountDto = restTemplate.getForObject(url, AccountDto.class); 

		        List<NotificationDTO> notificationDto = new ArrayList<NotificationDTO>();

		        RestTemplate restTemplate2 = new RestTemplate();
		        ResponseEntity<List> responseEntity = restTemplate2.getForEntity("http://10.168.1.4:25000/data-access-service/notifications/1",List.class);

		        notificationDto = responseEntity.getBody();

		        mav.addObject("notification", notificationDto);

		        System.out.println(notificationDto.toString());
		        mav.addObject("account", accountDto);
		        
		  
		        
		        System.out.println(accountDto.toString());
		        return mav;
		  }
		  
}


