package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.StockPriceGeneratorService;
import fr.webank.dataaccessservice.services.StockService;
import fr.webank.webankmodels.StockDto;
import fr.webank.webankmodels.StockPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
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

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List> getAllStocks(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size
    ) {
        //
        Page<StockDto> listStock = stockService.getAllStocks(page, size);
        return new ResponseEntity<>(listStock.getContent(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{stockId}", method = RequestMethod.GET)
    public ResponseEntity <StockPriceDto> getStockPrice(@PathVariable String stockId) {

        StockPriceGeneratorService stockPriceGeneratorService = new StockPriceGeneratorService();

        StockPriceDto stockPriceDto = stockPriceGeneratorService.GenerateStock(stockId);

        return new ResponseEntity<>(stockPriceDto, HttpStatus.OK);
    }
}
