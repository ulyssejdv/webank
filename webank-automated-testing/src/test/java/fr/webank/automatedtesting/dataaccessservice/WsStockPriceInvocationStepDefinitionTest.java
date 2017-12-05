package fr.webank.automatedtesting.dataaccessservice;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Ayda Najjar.
 */

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, tags = "@ws-stocks-prices", features = "src/main/resources/features", plugin = {
        "pretty", "html:target/cucumber" }, glue = "fr.webank.automatedtesting.dataaccessservice.definition")
public class WsStockPriceInvocationStepDefinitionTest {
}