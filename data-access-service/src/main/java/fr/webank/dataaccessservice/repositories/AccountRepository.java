package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.Account;
import fr.webank.dataaccessservice.entities.Balance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author RubenEdery on 23/11/2017.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
	List<Account> findAll();
}
