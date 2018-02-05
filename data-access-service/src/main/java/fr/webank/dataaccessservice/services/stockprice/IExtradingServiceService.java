package fr.webank.dataaccessservice.services.stockprice;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import fr.webank.webankmodels.StockPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IExtradingServiceService implements IStockPriceService {

    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public IExtradingServiceService() {
        restTemplate = new RestTemplate();
    }

    @Override
    public StockPriceDto getStockPrice(String symbole) {
        String result = restTemplate.getForObject("https://api.iextrading.com/1.0/stock/"+symbole+"/quote", String.class);

        Gson gson = new Gson();
        JsonObject priceData = gson.fromJson(result, JsonObject.class);

        StockPriceDto stockPrice = new StockPriceDto();

        stockPrice.setStockId(symbole);
        stockPrice.setStockDescription(priceData.get("companyName").getAsString());

        stockPrice.setStockPrice(priceData.get("latestPrice").getAsDouble());
        stockPrice.setStockMinPrice(priceData.get("low").getAsDouble());
        stockPrice.setStockMaxPrice(priceData.get("high").getAsDouble());
        stockPrice.setStockOpenPrice(priceData.get("open").getAsDouble());
        stockPrice.setStockExchange(priceData.get("iexVolume").getAsDouble());
        return stockPrice;
    }
}
