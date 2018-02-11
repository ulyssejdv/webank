package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.StockService;
import fr.webank.dataaccessservice.services.stockprice.AlphAvantageService;
import fr.webank.dataaccessservice.services.stockprice.StockPriceService;
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
    private final StockPriceService stockPriceService;

    // constructor
    // @Autowired : dependency injection
    @Autowired
    public StockController(StockService stockService, StockPriceService stockPriceService) {
        this.stockService = stockService;
        this.stockPriceService = stockPriceService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List> getAllStocks(
            @RequestParam(value = "search", defaultValue = "", required = false) String search,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size
    ) {
        Page<StockDto> listStock;

        if(search == null || search.equals("")) {
            listStock = stockService.getAllStocks(page, size);
        } else {
            listStock = stockService.getStocksByIdOrDescription(search, page, size);
        }

        return new ResponseEntity<>(listStock.getContent(), HttpStatus.OK);
    }


    @RequestMapping(path = "/{stockId}", method = RequestMethod.GET)
    public ResponseEntity <StockPriceDto> getStockPrice(@PathVariable String stockId) {

        StockPriceDto stockPriceDto = stockPriceService.getStockPrice(stockId);
        if (stockPriceDto == null)
            // return status http 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            // return the information of stock price
            return new ResponseEntity<>(stockPriceDto, HttpStatus.OK);
    }
}
