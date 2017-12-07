package fr.webank.automatedtesting.frontmobile.definition;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.webank.automatedtesting.frontmobile.definition.AccountStatementStepDefinition;
import fr.webank.webankmodels.BasDto;
import fr.webank.webankmodels.StockDto;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * Created by Boubacar  NDIAYE
 */

@ContextConfiguration
@Scope("cucumber-glue")
@Component("fr.webank.automatedtesting.frontmobile.definition")
public class AccountStatementStepDefinition {
    ObjectMapper mapper = new ObjectMapper();

        private final Logger LOGGER = LoggerFactory.getLogger(fr.webank.automatedtesting.frontmobile.definition.AccountStatementStepDefinition.class);
        private String url;
        List<BasDto> list;

        /**
         * @param url
         */
        @Given("the rest front end url \"(.+?)\"")
        public void getInformations(final String url) {
            this.url = url;
        }

        @When("request about account informations")
        public void requestListStocksServer() throws IOException {
            RestTemplate restTemplate = new RestTemplate();
            list = mapper.readValue(url, List.class);
        }

        @Then("get informations bout account with the given url")
        public void checkResults() throws IOException {
            BasDto bas=mapper.readValue(url,BasDto.class);
           // Assert.assertEquals(list.size() ,1);
            Assert.assertEquals(bas.getFileName(),"bas_87654.pdf");
            Assert.assertEquals(bas.getFileName(),"1511871088454");

        }

    }
