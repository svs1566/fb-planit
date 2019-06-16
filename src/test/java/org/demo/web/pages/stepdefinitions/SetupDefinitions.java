package org.demo.web.pages.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.demo.web.runner.WebInitializer;
import org.openqa.selenium.WebDriver;

@Slf4j
public class SetupDefinitions {

    private static WebDriver driver = new WebInitializer().initialize();

    @Given("^I navigate to facebook$")
    public static void navigateToFbLandingPage() {
        log.debug("I navigate to the sign up page of facebook");
        if (driver == null) {
            driver = new WebInitializer().initialize();
        }
        driver.manage().window().maximize();
        driver.get(WebInitializer.webUrl);
    }

    @Then("^I close the browser$")
    public static void closeBrowser() {
        log.debug("close the browser");
        driver.close();
    }
}
