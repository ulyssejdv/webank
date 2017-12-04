package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author RubenEdery on 23/11/2017
 */
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
	List<CustomerEntity> findAll();
}
