package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.TransactionTypeService;
import fr.webank.webankmodels.TypeTransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

/**
 * @author RubenEdery on 23/11/2017.
 */

@RestController
@RequestMapping(path = "/transactiontype")
public class TransactionTypeController {
	
	
	private final TransactionTypeService transactionTypeService;
	
	/**
	 * Initialize constructor
	 * @param transactionTypeService
	 */
	@Autowired
	public TransactionTypeController(TransactionTypeService transactionTypeService) {
		this.transactionTypeService = transactionTypeService;
	}
	
	/**
	 * To get one transaction
	 * @param id
	 * @return JSON Transaction
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TypeTransactionDto> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") String id) {
		final Optional<TypeTransactionDto> dtoOpt = transactionTypeService.getTypeTransacById(id);
		return (dtoOpt.isPresent()) ?
					   new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Get all transactions
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/getalltransactionTypes", method = RequestMethod.GET)
	public ResponseEntity getTransactionType() throws Exception {
		
		final List<TypeTransactionDto> transactionTypeDtoList;
		try {
			transactionTypeDtoList = transactionTypeService.getAll();
			return (!transactionTypeDtoList.isEmpty()) ?
						   new ResponseEntity(transactionTypeDtoList, HttpStatus.OK) : new ResponseEntity(HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
	}
	
	/**
	 * Create a transaction
	 * @param transactionTypeDto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TypeTransactionDto> createTransactionType(@RequestBody TypeTransactionDto transactionTypeDto) {
		return new ResponseEntity<>(transactionTypeService.create(transactionTypeDto), HttpStatus.OK);
	}
	
	
	
	
}
