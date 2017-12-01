package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author RubenEdery on 19/11/2017.
 */
public interface TransactionRepository extends CrudRepository<Transaction, Long>  {
	List<Transaction> findAll();

	List<Transaction> findOrderByAccountFrom_AccountNumber(String id);
	
}
