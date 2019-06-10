package org.demo.web;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootApplication
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "\\ws\\auto-test\\src\\test\\resources\\facebookSignUp.feature",
        glue = {"org.demo.web.pages"}, //the path of the step definition files
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        monochrome = true, //display the console output in a proper readable format
        strict = true, //it will check if any step is not defined in step definition file
        dryRun = false //to check the mapping is proper between feature file and step def file
        //tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}
)
@SpringBootTest
public class AutomationTestRunner {

    public static void main(final String[] args) {
        SpringApplication.run(AutomationTestRunner.class, args);
    }
}

//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest
	

