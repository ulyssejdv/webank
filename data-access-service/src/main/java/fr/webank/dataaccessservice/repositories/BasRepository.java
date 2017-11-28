package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.BasEntity;
import fr.webank.dataaccessservice.entities.Customer;
import fr.webank.dataaccessservice.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ulysse on 28/11/2017.
 */
public interface BasRepository extends CrudRepository<BasEntity, Long> {

    List<BasEntity> findBasEntitiesByCustomer(CustomerEntity customer);
}
