package fr.webank.automatedtesting.baacstservice;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by ulysse on 06/12/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@baacst",
        features = "src/main/resources/features",
        plugin = {
                "pretty",
                "html:target/cucumber"
        },
        glue = "fr.webank.automatedtesting.baacstservice.definition"
)
public class BaacstInvocationStepDefinitionTest {
}
