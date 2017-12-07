package fr.webank.automatedtesting.dataaccessservice;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Alex
 */

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, tags = "@ws-notifications", features = "src/main/resources/features", plugin = {
        "pretty", "html:target/cucumber" }, glue = "fr.webank.automatedtesting.dataaccessservice.definition")

public class WsNotificationStepDefinitionTest {
}
