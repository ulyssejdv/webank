package fr.webank.automatedtesting.dataaccessservice.definition;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.webank.webankmodels.AccountDto;

@ContextConfiguration
@Scope("cucumber-glue")
@Component("fr.webank.automatedtesting.dataaccessservice.definition")
public class AccountInvocationStepDefinition {
	   
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountInvocationStepDefinition.class);
	private String url;
	private AccountDto accountDto;

	    @Given("there are account registred in the database at \"(.+?)\"")
	    public void setAccountUrl(final String url) {
	        this.url = url;
	    }

	    @When("the user request an account")
	    public void requestAccount() {
	        RestTemplate restTemplate = new RestTemplate();
	        accountDto = restTemplate.getForObject(url, AccountDto.class );
	    }

	    @Then("the account with the id '1' is displaying")
	    public void weDisplayTheAccountWithId1() {
	        Assert.assertTrue(accountDto.toString()=="1");
	    }

	}

