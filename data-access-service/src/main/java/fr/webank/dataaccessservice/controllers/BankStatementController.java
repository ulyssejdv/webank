package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.exceptions.ObjectNotExistsException;
import fr.webank.dataaccessservice.services.BankStatementServiceInterface;
import fr.webank.webankmodels.BankStatementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by ulysse on 28/11/2017.
 */
@RestController
@RequestMapping(path = "/bank-statement")
public class BankStatementController {
    @Autowired
    BankStatementServiceInterface bankStatementService;


    @GetMapping("/{bankStatementId}")
    public ResponseEntity<BankStatementDto> getBankStatementById(@PathVariable Long bankStatementId) {

        final Optional<BankStatementDto> dtoOpt = bankStatementService.getBankStatementById(bankStatementId);

        ResponseEntity<BankStatementDto> responseEntity = null;

        if (dtoOpt.isPresent()) {
            responseEntity = new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return responseEntity;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getAllBasForCustomer(@PathVariable Long customerId) {

        List<BankStatementDto> bankStatementDtoList = null;

        try {
            bankStatementDtoList = bankStatementService.getBankStatementByCustomer(customerId);
        } catch (ObjectNotExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        if (!bankStatementDtoList.isEmpty()) {
            return new ResponseEntity<>(bankStatementDtoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
