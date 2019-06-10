package org.demo.web.pages.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.demo.web.runner.WebInitializer;
import org.openqa.selenium.WebDriver;

@Slf4j
public class SetupDefinitions {

    private static WebDriver driver = new WebInitializer().initialize();

    @Given("^I navigate to facebook$")
    public void navigateToFbLandingPage() {
        log.info("I navigate to the sign up page of facebook");
        driver.manage().window().maximize();
        driver.get(WebInitializer.webUrl);
    }

    @And("^I close the browser$")
    public void closeBrowser() {
        log.info("close the browser");
        //driver.close();
    }
}
