package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.Account;
import fr.webank.webankmodels.AccountDto;

import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 23/11/2017.
 */
public interface IAccountService {
	
	List<AccountDto> getAll();
	
	Optional<AccountDto> getAccountById(String id);
	
	AccountDto create(AccountDto accountDto);
	
	void update(String id, AccountDto accountDto);
	
}
