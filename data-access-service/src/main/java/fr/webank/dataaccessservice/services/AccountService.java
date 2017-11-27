package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.Account;
import fr.webank.dataaccessservice.repositories.AccountRepository;
import fr.webank.webankmodels.AccountDto;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author RubenEdery on 23/11/2017.
 */
@Service
public class AccountService implements IAccountService {
	
	private final AccountRepository accountRepository;
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	
	@Override
	public List<AccountDto> getAll() {
		return accountRepository.findAll()
					   .stream()
					   .map(
							   u -> mapper.map(u, AccountDto.class)
					   )
					   .collect(Collectors.toList());
	}
	
	
	@Override
	public Optional<AccountDto> getAccountById(String id) {
		Account balance = accountRepository.findOne(Long.parseLong(id));
		return (balance != null) ?
					   Optional.of(
							   mapper.map(balance, AccountDto.class)
					   )
					   : Optional.empty();	}
	
	@Override
	public AccountDto create(AccountDto accountDto) {
		Account customerEntity = accountRepository.save(mapper.map(accountDto,Account.class));
		return mapper.map(customerEntity, AccountDto.class);
	}
	
	
	@Override
	public void update(String id, AccountDto accountDto) {
		
	}
	
	
}
