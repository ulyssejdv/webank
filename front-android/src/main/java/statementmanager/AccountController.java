package controller;

import fr.webank.webankmodels.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import statementmanager.AccountStatementService;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

/**
 * Created by RubenEdery on 04/12/2017.
 */
@RestController
@RequestMapping(path = "/account")
public class AccountController {
    @Autowired
    private AccountStatementService pdfService;
    
    @RequestMapping(path = "/getaccountsbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<AccountDto[]> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") long id) {
        AccountDto[] accountDto = RestManagement.getResponse(
                "account/getaccountsbyid/", id);
        return !(accountDto == null) ?
                new ResponseEntity<>(accountDto,HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/releve/pdf/{basId}")
    public ResponseEntity<byte[]> GetAccountStatementPDF(@PathVariable Long basId) {

        byte[] contents = pdfService.getMyPDF(basId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;
    }

//route : http://localhost:8001/mobile-front/releve/infos/1

    @GetMapping("/releve/infos/{basId}")
    public ResponseEntity<byte[]> GetAccountStatementJSON(@PathVariable Long basId) {

        byte[] contents = pdfService.getMyJsonDocumnt(basId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/JSON"));
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;
    }





}
