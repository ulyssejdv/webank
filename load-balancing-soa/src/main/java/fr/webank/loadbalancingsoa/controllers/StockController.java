package fr.webank.loadbalancingsoa.controllers;


import fr.webank.webankmodels.StockPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Ayda Najjar.
 */

@RestController
@RequestMapping(path = "/stocks")
public class StockController {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List> getAllStocks(
            @RequestParam(value = "search", defaultValue = "", required = false) String search,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "size", defaultValue ="20", required = false) Integer size
    )
    {
        return restTemplate.getForEntity("http://webank/data-access-service/stocks?search="+search+"page="+page+"&size="+size, List.class);
    }

    @RequestMapping(path = "/{stockId}", method = RequestMethod.GET)
    public ResponseEntity <StockPriceDto> getStockPrice(@PathVariable String stockId) {
      return restTemplate.getForEntity("http://webank/data-access-service/stocks/"+stockId, StockPriceDto.class);
    }
}
