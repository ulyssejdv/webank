package fr.webank.hdfs.service.controllers;

import fr.webank.hdfs.service.exceptions.PdfNotFoundException;
import fr.webank.hdfs.service.services.BankStatementHdfsService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ulysse on 28/11/2017.
 */
@Log
@RestController
@RequestMapping(path = "/bank-statement")
public class BankStatementController {

    @Autowired
    private BankStatementHdfsService bankStatementHdfsService;


    /**
     * Get all bank statement from HDFS for the given customer
     */
    @GetMapping("/{fileName}")
    public ResponseEntity<?> getBankStatementListForCustomer(@PathVariable String fileName) {

        byte[] contents = null;

        try {
            contents = bankStatementHdfsService.getBankStatementPdf(fileName);
        } catch (PdfNotFoundException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/json"));
            return new ResponseEntity<>(e.getMessage(), headers, HttpStatus.NOT_FOUND);
        }

        if (contents == null) {
            return new ResponseEntity<>("No PDF can be returned", HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.setContentDispositionFormData(fileName, fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }
}
