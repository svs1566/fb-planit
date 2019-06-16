package org.demo.web;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "\\ws\\fb-planit\\src\\test\\resources\\facebookSignUp.feature",
        glue = {"org.demo.web.pages"}, //the path of the step definition files
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        monochrome = true, //display the console output in a proper readable format
        strict = true, //it will check if any step is not defined in step definition file
        dryRun = false //to check the mapping is proper between feature file and step def file
)
@SpringBootTest
public class AutomationTestRunner {

    public static void main(final String[] args) {
        SpringApplication.run(AutomationTestRunner.class, args);
    }
}
