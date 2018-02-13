package fr.webank.loadbalancingsoa.controllers;


import fr.webank.webankmodels.StockDto;
import fr.webank.webankmodels.StockPriceDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by Ayda Najjar.
 */

@RestController
@RequestMapping(path = "/stocks")
public class StockController {

//    @Value("${app.server1}")
    private String server1 = "data-access-service-2:25010";

//    @Value("${app.server2}")
    private String server2 = "data-access-service:25000";

    public static String defaultServer = "";

    public StockController() {
        defaultServer = server1;
        System.out.print("server1: " + server1);
        System.out.print("server2: " +server2);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<StockDto[]> getAllStocks(
            @RequestParam(value = "search", defaultValue = "", required = false) String search,
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "size", defaultValue ="20", required = false) Integer size
    )
    {
        RestTemplate restTemplate = new RestTemplate();

        StockDto[] response;
        try {
            response = restTemplate.getForObject("http://"+defaultServer+"/data-access-service/stocks?search="+search+"&page="+page+"&size="+size, StockDto[].class);
        } catch(Exception ex) {
            if(defaultServer.equals(server1)) {

                defaultServer = server2;
            } else
            {
                defaultServer = server1;
            }

            response = restTemplate.getForObject("http://"+defaultServer+"/data-access-service/stocks?search="+search+"&page="+page+"&size="+size, StockDto[].class);
        }

        return new ResponseEntity<StockDto[]>(response, HttpStatus.OK);
    }

    @RequestMapping(path = "/{stockId}", method = RequestMethod.GET)
    public ResponseEntity <StockPriceDto> getStockPrice(@PathVariable String stockId) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<StockPriceDto> response;

        try {
            response = restTemplate.getForEntity("http://"+server1+"/data-access-service/stocks/"+stockId, StockPriceDto.class);
        } catch(Exception ex) {

            if(defaultServer.equals(server1)) {

                defaultServer = server2;
            } else
            {
                defaultServer = server1;
            }

            response = restTemplate.getForEntity("http://"+server2+"/data-access-service/stocks/"+stockId, StockPriceDto.class);
        }
        return response;
    }
}
