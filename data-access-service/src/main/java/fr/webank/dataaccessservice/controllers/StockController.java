package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.StockPriceGeneratorService;
import fr.webank.dataaccessservice.services.StockService;
import fr.webank.webankmodels.StockDto;
import fr.webank.webankmodels.StockPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ayda Najjar.
 */


@RestController
@RequestMapping(path = "/stocks")
public class StockController {

    private final StockService stockService;
    private final StockPriceGeneratorService stockPriceGeneratorService;

    // constructor
    // @Autowired : dependency injection
    @Autowired
    public StockController(StockService stockService, StockPriceGeneratorService stockPriceGeneratorService) {
        this.stockService = stockService;
        this.stockPriceGeneratorService = stockPriceGeneratorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List> getAllStocks(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        // return all stocks from data base
        Page<StockDto> listStock = stockService.getAllStocks(page, size);
        return new ResponseEntity<>(listStock.getContent(), HttpStatus.OK);
    }


    @RequestMapping(path = "/{stockId}", method = RequestMethod.GET)
    public ResponseEntity <StockPriceDto> getStockPrice(@PathVariable String stockId) {

        StockPriceDto stockPriceDto = stockPriceGeneratorService.GenerateStock(stockId);
        if (stockPriceDto == null)
            // return status http 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            // return the information of stock price
            return new ResponseEntity<>(stockPriceDto, HttpStatus.OK);
    }
}
