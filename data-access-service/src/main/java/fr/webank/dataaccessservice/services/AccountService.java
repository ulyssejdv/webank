package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.Account;
import fr.webank.dataaccessservice.repositories.AccountRepository;
import fr.webank.webankmodels.AccountDto;
import fr.webank.webankmodels.CustomerDto;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author RubenEdery on 23/11/2017.
 */
@Service
public class AccountService implements IAccountService {
	
	private final AccountRepository accountRepository;
	private final CustomerService customerService;
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	public AccountService(AccountRepository accountRepository, CustomerService customerService) {
		this.accountRepository = accountRepository;
		this.customerService = customerService;
	}

    /**
     * Get all account
     * @return Account List
     */
	@Override
	public List<AccountDto> getAll() {
		return accountRepository.findAll()
					   .stream()
					   .map(
							   u -> mapper.map(u, AccountDto.class)
					   )
					   .collect(Collectors.toList());
	}

    /**
     * Get account by id
     * @param id
     * @return List account by id
     */
	@Override
	public Optional<AccountDto> getAccountById(String id) {
		Account balance = accountRepository.findOne(Long.parseLong(id));
		return (balance != null) ?
					   Optional.of(
							   mapper.map(balance, AccountDto.class)
					   )
					   : Optional.empty();	}

    /**
     * Create account
     * @param accountDto
     * @return
     */
    @Override
    public AccountDto create(AccountDto accountDto) {
		Account customerEntity = accountRepository.save(mapper.map(accountDto,Account.class));
		return mapper.map(customerEntity, AccountDto.class);
	}

    /**
     * Update acccount
     * Need to use PUT method or POST method
     * @param id
     * @param accountDto
     */
	@Override
	public void update(String id, AccountDto accountDto) {
		
	}

    /**
     * Get all account of one user
     * @param id
     * @return List Account
     * @throws Exception
     */
    @Override
    public List<AccountDto> getAllAccountOfUser(String id) throws Exception {
        try{
            Optional<CustomerDto> customerDto = customerService.getCustomerById(id);
            List<Account> accountEntityList = accountRepository.findOrderByCustomer_IdCustomer(Long.parseLong(id));
            List<AccountDto> accountDtoList = new ArrayList<AccountDto>();
            for(int i=0 ; i<accountEntityList.size() ; i++) {
                accountDtoList.add(mapper.map(accountEntityList.get(i), AccountDto.class));
                accountDtoList.get(i).setCustomer(mapper.map(accountEntityList.get(i).getCustomer(), CustomerDto.class));
            }
            return accountDtoList;
        }
        catch (Exception exception){
            throw new Exception("Unknown User");
        }

    }


}
