package fr.webank.automatedtesting.frontmobile;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Boubacar NDIAYE
 */

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, tags = "@fm-account-statement-infos", features = "src/main/resources/features", plugin = {
        "pretty", "html:target/cucumber" }, glue = "fr.webank.automatedtesting.frontmobile.definition")
public class AccountStatementStepDefinitionTest {
}