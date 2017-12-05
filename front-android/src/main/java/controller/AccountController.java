package controller;

import fr.webank.webankmodels.AccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

/**
 * Created by RubenEdery on 04/12/2017.
 */
@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @RequestMapping(path = "/getaccountsbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<AccountDto[]> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") long id) {
        AccountDto[] accountDto = RestManagement.getResponse(
                "account/getaccountsbyid/", id);
        return !(accountDto == null) ?
                new ResponseEntity<>(accountDto,HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
