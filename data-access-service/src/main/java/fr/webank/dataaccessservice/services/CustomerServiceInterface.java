package fr.webank.dataaccessservice.services;

import java.util.List;
import java.util.Optional;

import fr.webank.webankmodels.CustomerDto;

public interface CustomerServiceInterface {
	
	    List<CustomerDto> getAll();
	    
	    Optional<CustomerDto> getUserById(String id);

	    CustomerDto create(CustomerDto customerDto);

	    void delete(String id);

	    void update(String id, CustomerDto customerDto);

}
	
	

