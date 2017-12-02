package fr.webank.webankwebapp.controllers;

import fr.webank.webankmodels.StockDto;
import fr.webank.webankmodels.StockPriceDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping
    public ModelAndView getStocks() {
        ModelAndView modelAndView = new ModelAndView("stockExchange/viewStocks");

        List<StockDto> stockDtoList = new ArrayList<StockDto>();
/*
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StockDto> pageResponseEntity = restTemplate.getForEntity("http://localhost:25000//data-access-service/stocks?page=0&size=5",StockDto.class);

        System.out.println(pageResponseEntity.getBody());
*/
        StockDto stockDto1 = StockDto.builder().build();
        stockDto1.setStockId("coucou");
        stockDto1.setStockDescription("salut");
        stockDtoList.add(stockDto1);

        modelAndView.addObject("listStock", stockDtoList);

        return modelAndView;
    }

    @GetMapping(path = "/{stockId}")
    public ModelAndView getStockDetails(@PathVariable String stockId) {
        ModelAndView modelAndView = new ModelAndView("stockExchange/viewStockDetails");

        System.out.println(stockId);

        StockPriceDto stockPriceDto = new StockPriceDto();
        stockPriceDto.setStockId(stockId);
        stockPriceDto.setStockDescription("newdescritpion");
        stockPriceDto.setStockExchange(23D);
        stockPriceDto.setStockMaxPrice(99D);
        stockPriceDto.setStockMinPrice(11D);
        stockPriceDto.setStockOpenPrice(43D);
        stockPriceDto.setStockPrice(85D);
        stockPriceDto.setStockPriceChange(23D);

        modelAndView.addObject("stockDetails", stockPriceDto);

        return modelAndView;
    }
}
