package com.solvd.testing;


import com.zebrunner.carina.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.solvd.testing.cucumber.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"
        }
)
public class CucumberTestRunner extends CucumberBaseTest {
}