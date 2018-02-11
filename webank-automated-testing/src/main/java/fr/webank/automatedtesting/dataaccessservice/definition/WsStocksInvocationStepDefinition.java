package fr.webank.automatedtesting.dataaccessservice.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.webank.webankmodels.StockDto;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * Created by Ayda Najjar.
 */

@ContextConfiguration
@Scope("cucumber-glue")
@Component("fr.webank.automatedtesting.dataaccessservice.definition")
public class WsStocksInvocationStepDefinition {
    private static final Logger LOGGER = LoggerFactory.getLogger(WsStocksInvocationStepDefinition.class);
    private String url;
    private String stockId;
    private StockDto stock;
    private StockDto[] listStok;
    /**
     * @param url
     */
    @Given("the rest frontend service at \"(.+?)\"")
    public void setWsStocksUrl(final String url) {
        this.url = url;
    }

    @When("request the list of stocks")
    public void requestListStocksServer() {
        RestTemplate restTemplate = new RestTemplate();
        listStok = restTemplate.getForObject(url, StockDto[].class );
    }

    @Then("checks the results")
    public void checkResults() {
        Assert.assertTrue(listStok.length <= 10);
    }

    @Given("the stoks filtred list rest frontend service at \"(.+?)\"")
    public void setFilteredWsStocksUrl(final String url) {
        this.url = url;
    }

    @Then("checks the filtered results")
    public void checkFilteredResults() {
        Boolean ok = true;

        for (StockDto stock:
             listStok) {
            if(!stock.getStockId().toUpperCase().contains("AA") && !stock.getStockDescription().toUpperCase().contains("AA"))
            {
                ok = false;
                break;
            }
        }

        Assert.assertTrue(ok);
    }

    @Then("choose stock id from results")
    public void chooseStockId() {
        Random random = new Random();
        int randomIndex = random.nextInt(listStok.length + 1);

        stockId = listStok[randomIndex].getStockId();
    }

    @Then("request the stock details")
    public void requestStockDetails() {
        RestTemplate restTemplate = new RestTemplate();
        stock = restTemplate.getForObject(url + "/" + stockId, StockDto.class );
    }

    @Then("checks the stock details")
    public void checkStockDetails() {
        Assert.assertTrue(stock.getStockId().equals(stockId));
    }


}
