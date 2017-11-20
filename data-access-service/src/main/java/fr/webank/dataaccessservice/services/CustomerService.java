package fr.webank.dataaccessservice.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.webank.dataaccessservice.entities.Customer;
import fr.webank.dataaccessservice.repositories.CustomerRepository;
import fr.webank.webankmodels.CustomerDto;


@Service
public class CustomerService implements CustomerServiceInterface {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(
                        u -> CustomerDto.builder()
                                .id(String.valueOf(u.getId()))
                                .firstName(u.getFirstName())
                                .lastName(u.getLastName())
                                .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDto> getUserById(String id) {
        Customer customer = customerRepository.findOne(Long.parseLong(id));
        return (customer != null) ?
                Optional.of(
                		CustomerDto.builder()
                                .id(String.valueOf(customer.getId()))
                                .firstName(customer.getFirstName())
                                .lastName(customer.getLastName())
                                .build()
                )
                : Optional.empty();
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());

        Customer customer1 = customerRepository.save(customer);
        return CustomerDto.builder()
                .id(String.valueOf(customer1.getId()))
                .firstName(customer1.getFirstName())
                .lastName(customer1.getLastName())
                .build();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(String id, CustomerDto customerDto) {

    }
		
	}
