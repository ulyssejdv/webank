package fr.webank.dataaccessservice.repositories;

import fr.webank.dataaccessservice.entities.Balance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author RubenEdery on 23/11/2017
 */
public interface BalanceRepository extends CrudRepository<Balance, Long> {
	List<Balance> findAll();
}
