package fr.webank.front.android.controllers;

import fr.webank.front.android.services.AccountStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by ulysse on 11/01/2018.
 */
public class AccountStatementController {

    @Autowired
    private AccountStatementService pdfService;

    //http://localhost:8001/mobile-front/releve/pdf/1
    @GetMapping("releve/pdf/{basId}")
    public ResponseEntity<byte[]> GetAccountStatementPDF(@PathVariable Long basId) {

        byte[] contents = pdfService.getMyPDF(basId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;
    }

    //route : http://localhost:8001/mobile-front/releve/infos/1
    @GetMapping("releve/infos/{basId}")
    public ResponseEntity<byte[]> GetAccountStatementJSON(@PathVariable Long basId) {

        byte[] contents = pdfService.getMyJsonDocumnt(basId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/JSON"));
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        return response;
    }

}
