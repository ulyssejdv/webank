package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.CustomerEntity;
import fr.webank.dataaccessservice.repositories.CustomerRepository;
import fr.webank.webankmodels.CustomerDto;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author RubenEdery on 23/11/2017
 */
@Service
public class CustomerService implements ICustomerService {
	
	private final CustomerRepository customerRepository;
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	/**
	 * Get all customer
	 * @return List Customers
	 */
	@Override
	public List<CustomerDto> getAll() {
		return customerRepository.findAll()
					   .stream()
					   .map(
							   u -> mapper.map(u, CustomerDto.class)
					   )
					   .collect(Collectors.toList());	}


	/**
	 * get customer by his id
	 * @param id
	 * @return One customer
	 */
	@Override
	public Optional<CustomerDto> getCustomerById(String id) {
		CustomerEntity customer = customerRepository.findOne(Long.parseLong(id));
		return (customer != null) ?
					   Optional.of(
							   mapper.map(customer, CustomerDto.class)
					   )
					   : Optional.empty();
	}

	/**
	 * Create new customer
	 * @param customerDto
	 * @return new customers
	 */
	@Override
	public CustomerDto create(CustomerDto customerDto) {
		CustomerEntity customerEntity = customerRepository.save(mapper.map(customerDto,CustomerEntity.class));
		return mapper.map(customerEntity, CustomerDto.class);
	}

	/**
	 * Update a customer
	 * Need to use put, patch or delete method
	 * @param id
	 * @param customerDto
	 */
	@Override
	public void update(String id, CustomerDto customerDto) {
		
	}
}
