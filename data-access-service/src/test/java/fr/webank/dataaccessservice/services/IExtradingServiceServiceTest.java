package fr.webank.dataaccessservice.services;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.webank.dataaccessservice.services.stockprice.AlphAvantageService;
import fr.webank.dataaccessservice.services.stockprice.IExtradingServiceService;
import fr.webank.webankmodels.StockPriceDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IExtradingServiceServiceTest {

    @InjectMocks
    private IExtradingServiceService iExtradingServiceService;

    @Mock
    private RestTemplate restTemplate;

    private String resultApiStockPrice;

    @Before
    public void setup() {
        resultApiStockPrice = "{\"symbol\":\"AA\",\"companyName\":\"Alcoa Corporation\",\"primaryExchange\":\"New York Stock Exchange\",\"sector\":\"Basic Materials\",\"calculationPrice\":\"close\",\"open\":52.27,\"openTime\":1516717834999,\"close\":52.49,\"closeTime\":1516741224590,\"high\":52.9,\"low\":51.73,\"latestPrice\":52.49,\"latestSource\":\"Close\",\"latestTime\":\"January 23, 2018\",\"latestUpdate\":1516741224590,\"latestVolume\":4890394,\"iexRealtimePrice\":0,\"iexRealtimeSize\":0,\"iexLastUpdated\":0,\"delayedPrice\":52.49,\"delayedPriceTime\":1516744523784,\"previousClose\":52.94,\"change\":-0.45,\"changePercent\":-0.0085,\"iexMarketPercent\":0,\"iexVolume\":0,\"avgTotalVolume\":4764651,\"iexBidPrice\":0,\"iexBidSize\":0,\"iexAskPrice\":0,\"iexAskSize\":0,\"marketCap\":9721185425,\"peRatio\":17.44,\"week52High\":57.5,\"week52Low\":29.55,\"ytdChange\":-0.04857712524922965}";
    }

    @Test
    public void shouldReturnStockDTO() {
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenReturn(resultApiStockPrice);

        iExtradingServiceService.setRestTemplate(restTemplate);

        StockPriceDto stockPrice = iExtradingServiceService.getStockPrice("AA");

        Assert.assertTrue(stockPrice.getStockId().equals("AA")
                && stockPrice.getStockDescription().equals("Alcoa Corporation")
                && stockPrice.getStockMaxPrice() == 52.9
                && stockPrice.getStockMinPrice() == 51.73
                && stockPrice.getStockPrice() == 52.49
                && stockPrice.getStockExchange() == 0);
    }
}
