package fr.webank.dataaccessservice.controllers;

import fr.webank.dataaccessservice.services.StockService;
import fr.webank.dataaccessservice.services.machine.learning.PredictionSoldeService;
import fr.webank.dataaccessservice.services.stockprice.StockPriceService;
import fr.webank.webankmodels.HistoriqueSoldeDto;
import fr.webank.webankmodels.StockDto;
import fr.webank.webankmodels.StockPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(path = "/prediction")
public class PredictionSoldeController {


    private final PredictionSoldeService predictionSoldeService;

    // constructor
    // @Autowired : dependency injection
    @Autowired
    public PredictionSoldeController( PredictionSoldeService predictionSoldeService) {
        this.predictionSoldeService = predictionSoldeService;
    }

    @RequestMapping(path="/clients", method = RequestMethod.GET)
    public ResponseEntity<Page> getAllStocks(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size
    ) {
        Page<HistoriqueSoldeDto> listHistorique;

        listHistorique = predictionSoldeService.getSoldeCourant(page, size);

        return new ResponseEntity<>(listHistorique, HttpStatus.OK);
    }

    @RequestMapping(path="/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<List> getAllLastYearHistorique(@PathVariable Long clientId) throws IOException, InterruptedException {
        List<HistoriqueSoldeDto> listHistorique;

        listHistorique = predictionSoldeService.getLastYear(clientId);
        return new ResponseEntity<>(listHistorique, HttpStatus.OK);
    }

    @RequestMapping(path="/{clientId}/prediction", method = RequestMethod.GET)
    public ResponseEntity<List> getPredictionForNextYear(@PathVariable Long clientId) throws IOException, InterruptedException {
        List<HistoriqueSoldeDto> listPrediction;
        listPrediction = predictionSoldeService.predictNextYear(clientId);
        return new ResponseEntity<>(listPrediction, HttpStatus.OK);
    }
}
