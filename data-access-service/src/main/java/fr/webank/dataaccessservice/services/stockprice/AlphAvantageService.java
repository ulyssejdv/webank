package fr.webank.dataaccessservice.services.stockprice;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import fr.webank.webankmodels.StockPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphAvantageService implements IStockPriceService {

  private RestTemplate restTemplate;

  public RestTemplate getRestTemplate() {
    return restTemplate;
  }

  public void setRestTemplate(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Autowired
  public AlphAvantageService() {
    restTemplate = new RestTemplate();
  }

  @Override
  public StockPriceDto getStockPrice(String symbole) {

    String result = restTemplate.getForObject("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="+symbole+"&interval=1min&apikey=A6S6WU8UGVGODW37", String.class);

    Gson gson = new Gson();
    JsonObject jsonObject = gson.fromJson(result, JsonObject.class);

    StockPriceDto stockPrice = new StockPriceDto();

    stockPrice.setStockId(symbole);

    if(jsonObject.getAsJsonObject("Meta Data") == null)
      return null;
    stockPrice.setStockDescription(jsonObject.getAsJsonObject("Meta Data").get("1. Information").getAsString());

    String lastRefreshDate = jsonObject.getAsJsonObject("Meta Data").get("3. Last Refreshed").getAsString();
    JsonObject priceData = jsonObject.getAsJsonObject("Time Series (1min)").getAsJsonObject(lastRefreshDate);

    stockPrice.setStockPrice(priceData.get("4. close").getAsDouble());
    stockPrice.setStockMinPrice(priceData.get("3. low").getAsDouble());
    stockPrice.setStockMaxPrice(priceData.get("2. high").getAsDouble());
    stockPrice.setStockOpenPrice(priceData.get("1. open").getAsDouble());
    stockPrice.setStockExchange(priceData.get("5. volume").getAsDouble());
    return stockPrice;
  }
}
