package fr.webank.dataaccessservice.services;

import fr.webank.webankmodels.BalanceDto;

import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 23/11/2017.
 */
public interface IBalanceService {
	
	List<BalanceDto> getAll();
	
	Optional<BalanceDto> getBalanceById(String id);
	
	BalanceDto create(BalanceDto balanceDto);
	
	void update(String id, BalanceDto balanceDto);
	
}
