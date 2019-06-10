package org.demo.web.pages.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.demo.web.pages.SignUpPage;
import org.demo.web.runner.WebInitializer;
import org.openqa.selenium.WebDriver;

@Slf4j
public class SignUpStepDefinitions {

    private WebDriver driver = WebInitializer.getDriver();

    private SignUpPage signUpPage = new SignUpPage();

    @When("^I enter my firstname as '(.*)'$")
    public void feedFirstName(final String firstName) {
        log.info(signUpPage.toString());
        log.info("firstNameParam: " + firstName);
        signUpPage.feedFirstName(firstName);

    }

    @When("^I enter my surname as '(.*)'$")
    public void feedSurName(final String surName) {
        log.info("Surname : " + surName);
        signUpPage.feedLastName(surName);
    }

    @When("^I enter my mobile as '(.*)'$")
    public void feedMobile(final String emailOrMobile) {
        log.info("mobile : " + emailOrMobile);
        signUpPage.feedEmailOrMobile(emailOrMobile);
    }

    @When("^I enter my password as '(.*)'$")
    public void feedPassword(final String password) {
        log.info("password : " + password);
        signUpPage.feedPassword(password);
    }

    @When("^I enter my birthday as '(.*)'$")
    public void feedBirthDay(final String birthday) {
        log.info("birthday : " + birthday);
        signUpPage.feedDayOfBirth(birthday);
    }

    @When("^I enter my birthmonth as '(.*)'$")
    public void feedBirthMonth(final String birthMonth) {
        log.info("birthMonth : " + birthMonth);
        signUpPage.feedMonthOfBirth(birthMonth);
    }

    @When("^I enter my birthyear as '(.*)'$")
    public void feedBirthYear(final String birthYear) {
        log.info("birthYear : " + birthYear);
        signUpPage.feedYearOfBirth(birthYear);
    }

    @When("^I enter my gender as '(.*)'$")
    public void feedGender(final String gender) {
        log.info("gender :" + gender);
        signUpPage.feedGender(gender);
    }

    @Given("^I hit signup$")
    public void hitSignUpPageButton() {
        log.info("hitSignUpPageButton");
        signUpPage.submitButton();
    }

    @Then("^I confirm to have logged in successfully$")
    public void verifyLoggedIn() {
        log.info("verifyLoggedIn");
    }
}