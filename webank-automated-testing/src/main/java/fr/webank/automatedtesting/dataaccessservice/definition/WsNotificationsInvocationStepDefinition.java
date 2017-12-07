package fr.webank.automatedtesting.dataaccessservice.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.webank.webankmodels.NotificationDTO;
import org.junit.Assert;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Alex
 */

@ContextConfiguration
@Scope("cucumber-glue")
@Component("fr.webank.automatedtesting.dataaccessservice.definition")
public class WsNotificationsInvocationStepDefinition {

    private String url;
    private List<NotificationDTO> listNotification;
    /**
     * @param url
     */
    @Given("the rest notifications web service at \"(.+?)\"")
    public void setWsStocksUrl(final String url) {
        this.url = url;
    }

    @When("request the customer with the id notifications")
    public void requestListStocksServer() {
        RestTemplate restTemplate = new RestTemplate();
        listNotification = restTemplate.getForObject(url, List.class );
    }

    @Then("check that the received data is consistent with the created transaction")
    public void checkResults() {
        Assert.assertTrue(listNotification.size() > 0);
    }
}
