package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.entities.Transaction;
import fr.webank.dataaccessservice.repositories.TransactionRepository;
import fr.webank.webankmodels.AccountDto;
import fr.webank.webankmodels.TransactionDto;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author RubenEdery on 19/11/2017
 */
@Service
public class TransactionService implements ITransactionService {
	
	private final TransactionRepository transactionRepository;
	private final AccountService accountService;
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	public TransactionService(TransactionRepository transactionRepository, AccountService accountService) {
		this.transactionRepository = transactionRepository;
		this.accountService = accountService;
	}
	
	/**
	 * List all transactions
	 * @return
	 */
	@Override
	public List<TransactionDto> getAll() {
		return transactionRepository.findAll()
					   .stream()
					   .map(
							   u -> mapper.map(u, TransactionDto.class)
					   )
					   .collect(Collectors.toList());
	}
	
	
	/**
	 * Get all transaction by one client
	 * @param id
	 * @return
	 */
	@Override
	public Optional<TransactionDto> getTransactionById(String id) {
		Transaction transaction = transactionRepository.findOne(Long.parseLong(id));
		return (transaction != null) ?
					   Optional.of(
							   mapper.map(transaction, TransactionDto.class)
					   )
					   : Optional.empty();
	}
	
	
	/**
	 * Create a transaction
	 * @param transactionDto
	 * @return
	 */
	@Override
	public TransactionDto create(TransactionDto transactionDto) {
		Transaction transactionEntity = transactionRepository.save(mapper.map(transactionDto,Transaction.class));
		return mapper.map(transactionEntity, TransactionDto.class);
	
	}
	
	
	/**
	 * Delete a transaction
	 * @param id
	 */
	@Override
	public void delete(String id) {
		transactionRepository.delete(Long.parseLong(id));
	}

    /**
     * Update method
     * @param id
     * @param transactionDto
     */
	@Override
	public void update(String id, TransactionDto transactionDto) {
		
	}

    /**
     * Get all transaction by account id
     * @param id
     * @return List of transactions
     * @throws Exception
     */
	@Override
	public List<TransactionDto> getAllTransactionOfAccount(String id) throws Exception {
		try{
			//Customer of the account
		    Optional<AccountDto> customerDto = accountService.getAccountById(id);
			List<Transaction> transactionEntityList = transactionRepository.findOrderByAccountFrom_AccountNumber((id));
			List<TransactionDto> transactionDtoList = new ArrayList<TransactionDto>();
			for(int i=0 ; i<transactionEntityList.size() ; i++) {
				transactionDtoList.add(mapper.map(transactionEntityList.get(i), TransactionDto.class));
				transactionDtoList.get(i).setAccountTo(mapper.map(transactionEntityList.get(i).getAccountTo(), AccountDto.class));
			}
			return transactionDtoList;
		}
		catch (Exception exception){
			throw new Exception("Utilisateur inconnu.");
		}

	}


}
