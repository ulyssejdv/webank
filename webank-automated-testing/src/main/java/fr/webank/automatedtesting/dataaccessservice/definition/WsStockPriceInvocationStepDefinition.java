package fr.webank.automatedtesting.dataaccessservice.definition;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.webank.webankmodels.StockDto;
import fr.webank.webankmodels.StockPriceDto;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ayda Najjar.
 */

@ContextConfiguration
@Scope("cucumber-glue")
@Component("fr.webank.automatedtesting.dataaccessservice.definition")
public class WsStockPriceInvocationStepDefinition {
    private static final Logger LOGGER = LoggerFactory.getLogger(WsStocksInvocationStepDefinition.class);
    private String url;
    private StockPriceDto stockPrice;

    /**
     * @param url
     */

    @Given("the rest frontend stock price service at \"(.+?)\"")
    public void setWsStocksUrl(final String url) {
        this.url = url;
    }

    @When("request the stock price")
    public void requestStockPriceServer() {
        RestTemplate restTemplate = new RestTemplate();
        stockPrice = restTemplate.getForObject(url, StockPriceDto.class );
    }

    @Then("check stock price less than max price")
    public void checkStockPriceLessThanMaxPrice() {
        Assert.assertTrue(stockPrice.getStockPrice()<=stockPrice.getStockMaxPrice());
    }

    @And("check stock price great than max price")
    public void checkStockPriceGreatThanMaxPrice() {
        Assert.assertTrue(stockPrice.getStockPrice()>=stockPrice.getStockMinPrice());
    }
}
