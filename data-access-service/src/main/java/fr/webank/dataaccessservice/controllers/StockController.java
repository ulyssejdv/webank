package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.StockService;
import fr.webank.webankmodels.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(path = "/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<StockDto>> get() {
        // TODO
        return new ResponseEntity<>(new ArrayList<StockDto>(), HttpStatus.OK);
    }



}
