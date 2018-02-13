package fr.webank.webankwebapp.controllers;

import fr.webank.webankmodels.StockDto;
import fr.webank.webankmodels.StockPriceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lindabouzid on 28/11/2017.
 */
@Controller
@RequestMapping("/stockExchange")
public class StocksController {

    @RequestMapping(value="/search")
    public ModelAndView getStocksSearching(@RequestParam("val") String val){
        ModelAndView modelAndView = new ModelAndView("stockExchange/viewStocks");

        List<StockDto> stockDtoList = new ArrayList<StockDto>();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://data-access-service:25000//data-access-service/stocks?search=" + val,List.class);

        stockDtoList = responseEntity.getBody();

        modelAndView.addObject("listStock", stockDtoList);

        return modelAndView;
    }

    @GetMapping
    public ModelAndView getStocks(@RequestParam(value="page", required=false) Integer page) {

        if ((page == null) || (page == 0))
            page=1;

        ModelAndView modelAndView = new ModelAndView("stockExchange/viewStocks");

        List<StockDto> stockDtoList = new ArrayList<StockDto>();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://data-access-service:25000//data-access-service/stocks?page=" + (page-1) + "&size=15",List.class);

        stockDtoList = responseEntity.getBody();

        modelAndView.addObject("listStock", stockDtoList);
        modelAndView.addObject("numpage", page);

        return modelAndView;
    }

    @GetMapping(path = "/{stockId}")
    public ModelAndView getStockDetails(@PathVariable String stockId) {
        ModelAndView modelAndView = new ModelAndView("stockExchange/viewStockDetails");

        String URL = "http://data-access-service:25000//data-access-service/stocks/" + stockId;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StockPriceDto> responseEntity = restTemplate.getForEntity(URL,StockPriceDto.class);

        StockPriceDto stockPriceDto = responseEntity.getBody();

        modelAndView.addObject("stockDetails", stockPriceDto);

        return modelAndView;
    }

}
