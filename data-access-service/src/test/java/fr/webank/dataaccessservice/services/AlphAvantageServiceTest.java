package fr.webank.dataaccessservice.services;

import fr.webank.dataaccessservice.services.stockprice.AlphAvantageService;
import fr.webank.webankmodels.StockPriceDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AlphAvantageServiceTest {

    @InjectMocks
    private AlphAvantageService stockPriceAlphAvantage;

    @Mock
    private RestTemplate restTemplate;

    private String resultApiStockPrice;

    @Before
    public void setup() {
        resultApiStockPrice = "{\"Meta Data\": {\"1. Information\": \"Intraday (1min) prices and volumes\",\"2. Symbol\": \"ABEO\",\"3. Last Refreshed\": \"2018-01-23 16:00:00\",\"4. Interval\": \"1min\",\"5. Output Size\": \"Compact\", \"6. Time Zone\": \"US/Eastern\" }, \"Time Series (1min)\": { \"2018-01-23 16:00:00\": { \"1. open\": \"15.4000\", \"2. high\": \"15.4500\", \"3. low\": \"15.3500\", \"4. close\": \"15.4000\", \"5. volume\": \"85327\" }, \"2018-01-23 15:59:00\": { \"1. open\": \"15.4500\", \"2. high\": \"15.4828\", \"3. low\": \"15.4000\", \"4. close\": \"15.4250\", \"5. volume\": \"7154\"}}}";
    }

    @Test
    public void shouldReturnStockDTO() {
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenReturn(resultApiStockPrice);

        stockPriceAlphAvantage.setRestTemplate(restTemplate);

        StockPriceDto stockPrice = stockPriceAlphAvantage.getStockPrice("ABEO");

        Assert.assertTrue(stockPrice.getStockId().equals("ABEO")
            && stockPrice.getStockDescription().equals("Intraday (1min) prices and volumes")
            && stockPrice.getStockMaxPrice() == 15.4500
            && stockPrice.getStockMinPrice() == 15.3500
            && stockPrice.getStockPrice() == 15.4000
            && stockPrice.getStockExchange() == 85327);
    }
}
