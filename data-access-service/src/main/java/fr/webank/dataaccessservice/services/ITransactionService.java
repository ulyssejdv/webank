package fr.webank.dataaccessservice.services;

import fr.webank.webankmodels.TransactionDto;

import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 19/11/2017
 */
public interface ITransactionService{
	
	List<TransactionDto> getAll();
	
	Optional<TransactionDto> getTransactionById(String id);
	
	TransactionDto create(TransactionDto transactionDto);
	
	void delete(String id);
	
	void update(String id, TransactionDto transactionDto);

	List<TransactionDto> getAllTransactionOfAccount(String id) throws Exception;


}
