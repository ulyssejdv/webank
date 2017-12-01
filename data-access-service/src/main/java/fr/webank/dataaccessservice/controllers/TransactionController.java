package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.TransactionService;
import fr.webank.webankmodels.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 19/11/2017.
 */
@RestController
@RequestMapping(path = "/transaction")
public class TransactionController {
	
	private final TransactionService transactionService;
	
	/**
	 * Initialize constructor
	 * @param transactionService
	 */
	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	/**
	 * To get one transaction
	 * @param id
	 * @return JSON Transaction
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TransactionDto> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") String id) {
		final Optional<TransactionDto> dtoOpt = transactionService.getTransactionById(id);
		return (dtoOpt.isPresent()) ?
					   new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Get all transactions
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/getalltransactions", method = RequestMethod.GET)
	public ResponseEntity getTransaction() throws Exception {
		
		final List<TransactionDto> transactionDtoList;
		try {
			transactionDtoList = transactionService.getAll();
			return (!transactionDtoList.isEmpty()) ?
		   			new ResponseEntity(transactionDtoList, HttpStatus.OK) : new ResponseEntity(HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
	}
	
	/**
	 * Create a transaction
	 * @param transactionDto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
		return new ResponseEntity<>(transactionService.create(transactionDto), HttpStatus.OK);
	}


	/**
	 * Get all transactions by account id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/gettransactionsbyaccount/{id}" , method = RequestMethod.GET)
	public ResponseEntity getTransactionByAccount(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") String id) throws Exception {
		try {
			List<TransactionDto> accountDtoList =transactionService.getAllTransactionOfAccount(id);
			return (!accountDtoList.isEmpty()) ?
					new ResponseEntity(accountDtoList, HttpStatus.OK) : new ResponseEntity(HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
	}
	
}
