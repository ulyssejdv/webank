package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.AccountService;
import fr.webank.webankmodels.AccountDto;
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
@RequestMapping(path = "/account")
public class AccountController {
	
	private final AccountService accountService;
	
	/**
	 * Initialize constructor
	 * @param accountService
	 */
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	/**
	 * To get one transaction
	 * @param id
	 * @return JSON Transaction
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AccountDto> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") String id) {
		final Optional<AccountDto> dtoOpt = accountService.getAccountById(id);
		return (dtoOpt.isPresent()) ?
					   new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Get all transactions
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/getallaccounts", method = RequestMethod.GET)
	public ResponseEntity getAccount() throws Exception {
		
		final List<AccountDto> accountDtoList;
		try {
			accountDtoList = accountService.getAll();
			return (!accountDtoList.isEmpty()) ?
						   new ResponseEntity(accountDtoList, HttpStatus.OK) : new ResponseEntity(HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
	}
	
	/**
	 * Create a transaction
	 * @param accountDto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
		return new ResponseEntity<>(accountService.create(accountDto), HttpStatus.OK);
	}
	
}
