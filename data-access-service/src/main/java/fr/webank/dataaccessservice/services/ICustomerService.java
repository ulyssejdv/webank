package fr.webank.dataaccessservice.services;

import fr.webank.webankmodels.CustomerDto;

import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 23/11/2017
 */
public interface ICustomerService {
	
	
	List<CustomerDto> getAll();
	
	Optional<CustomerDto> getCustomerById(String id);
	
	CustomerDto create(CustomerDto customerDto);
	
	void update(String id, CustomerDto customerDto);
	
	
}
