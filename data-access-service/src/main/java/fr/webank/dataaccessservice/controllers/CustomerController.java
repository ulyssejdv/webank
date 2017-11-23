package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.CustomerService;
import fr.webank.webankmodels.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 23/11/2017.
 */
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
	
	
	private final CustomerService customerService;
	
	/**
	 * Initialize constructor
	 * @param customerService
	 */
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	/**
	 * To get one transaction
	 * @param id
	 * @return JSON Transaction
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerDto> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") String id) {
		final Optional<CustomerDto> dtoOpt = customerService.getCustomerById(id);
		return (dtoOpt.isPresent()) ?
					   new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Get all transactions
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/getallcustomers", method = RequestMethod.GET)
	public ResponseEntity getCustomer() throws Exception {
		
		final List<CustomerDto> customerDtoList;
		try {
			customerDtoList = customerService.getAll();
			return (!customerDtoList.isEmpty()) ?
						   new ResponseEntity(customerDtoList, HttpStatus.OK) : new ResponseEntity(HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
	}
	
	/**
	 * Create a transaction
	 * @param customerDto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
		return new ResponseEntity<>(customerService.create(customerDto), HttpStatus.OK);
	}
	
}
