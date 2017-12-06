package fr.webank.automatedtesting.dataaccessservice;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, tags = "@account", features = "src/main/resources/features", plugin = {
"pretty", "html:target/cucumber" }, glue = "fr.webank.automatedtesting.dataaccessservice.definition")
public class AccountInvocationStepDefinitionTest {

}
