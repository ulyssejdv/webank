package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.TransactionType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author RubenEdery on 23/11/2017.
 */
public interface TransactionTypeRepository extends CrudRepository<TransactionType, Long> {
	List<TransactionType> findAll();
}