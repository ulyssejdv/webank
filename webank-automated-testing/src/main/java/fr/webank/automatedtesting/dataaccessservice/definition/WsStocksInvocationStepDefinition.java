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

/**
 * Created by Ayda Najjar.
 */

@ContextConfiguration
@Scope("cucumber-glue")
@Component("fr.webank.automatedtesting.dataaccessservice.definition")
public class WsStocksInvocationStepDefinition {
    private static final Logger LOGGER = LoggerFactory.getLogger(WsStocksInvocationStepDefinition.class);
    private String url;
    private List<StockDto> listStok;
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
        listStok = restTemplate.getForObject(url, List.class );
    }

    @Then("checks the results")
    public void checkResults() {
        Assert.assertTrue(listStok.size() == 10);
    }
}
