package fr.webank.dataaccessservice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.webank.dataaccessservice.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
}

