package fr.webank.front.android.controllers;

import fr.webank.front.android.services.AccountStatementService;
import fr.webank.front.android.services.RestManagement;
import fr.webank.webankmodels.AccountDto;
import fr.webank.webankmodels.BankStatementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
/**
 * Created by BoubacarNDIAYE on 04/12/2017.
 */
@RestController
@RequestMapping(path = "/bank-statement/customer")
public class AccountStatementController {

        @RequestMapping(path = "/getCustomerBankStatement/{id}", method = RequestMethod.GET)
        public ResponseEntity<BankStatementDto[]> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") long id) {
            BankStatementDto[] BankStatementDto = AccountStatementService.getResponseStatement(
                    "", id);
            return !(BankStatementDto == null) ?
                    new ResponseEntity<>(BankStatementDto,HttpStatus.OK) :
                    new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


    }





