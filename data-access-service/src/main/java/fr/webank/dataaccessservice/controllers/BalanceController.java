package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.BalanceService;
import fr.webank.webankmodels.BalanceDto;
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
@RequestMapping(path = "/balance")
public class BalanceController {
	
	
	
	private final BalanceService balanceService;
	
	/**
	 * Initialize constructor
	 * @param balanceService
	 */
	@Autowired
	public BalanceController(BalanceService balanceService) {
		this.balanceService = balanceService;
	}
	
	/**
	 * To get one balance
	 * @param id
	 * @return JSON balances
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BalanceDto> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") String id) {
		final Optional<BalanceDto> dtoOpt = balanceService.getBalanceById(id);
		return (dtoOpt.isPresent()) ?
					   new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Get all balances
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/getallbalances", method = RequestMethod.GET)
	public ResponseEntity getBalance() throws Exception {
		
		final List<BalanceDto> balanceDtoList;
		try {
			balanceDtoList = balanceService.getAll();
			return (!balanceDtoList.isEmpty()) ?
						   new ResponseEntity(balanceDtoList, HttpStatus.OK) : new ResponseEntity(HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
	}
	
	/**
	 * Create a balance
	 * @param balanceDto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BalanceDto> createBalance(@RequestBody BalanceDto balanceDto) {
		return new ResponseEntity<>(balanceService.create(balanceDto), HttpStatus.OK);
	}
	
	
}
