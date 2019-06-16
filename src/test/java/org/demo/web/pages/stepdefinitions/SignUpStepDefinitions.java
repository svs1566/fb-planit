package org.demo.web.pages.stepdefinitions;

import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.abstraction.MockUnitString;
import org.demo.web.pages.SignUpPage;
import org.demo.web.runner.WebInitializer;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.andreinc.mockneat.unit.text.Strings.strings;
import static net.andreinc.mockneat.unit.types.Ints.ints;
import static net.andreinc.mockneat.unit.user.Names.names;

@Slf4j
public class SignUpStepDefinitions {

    private WebDriver driver = WebInitializer.getDriver();

    private SignUpPage signUpPage = new SignUpPage();
    private String firstName;

    @When("^I sign up (.*) users with random details on facebook successfully$")
    public void signUpUsersOnFacebook(final String numberOfUsers) {
        int users = Integer.parseInt(numberOfUsers);
        for (int i = 0; i < users; i++) {
            signUpFacebook();
            SetupDefinitions.navigateToFbLandingPage();
        }
    }

    /**
     * This methods fills up all the details on Facebook sign up page
     * It then verifies the user logged in on the new logged in page
     */
    private void signUpFacebook() {
        feedFirstName();
        feedSurName();
        feedMobile();
        feedPassword();
        feedBirthDay();
        feedBirthMonth();
        feedBirthYear();
        feedGender();
        hitSignUpPageButton();
        verifyLoggedIn();
        SetupDefinitions.closeBrowser();
    }

    /**
     * This method feeds the firstname required to sign up
     */
    private void feedFirstName() {
        log.debug(signUpPage.toString());
        firstName = getRandomFirstName().get();
        log.debug("firstName: " + firstName);
        signUpPage.feedFirstName(firstName);
    }

    /**
     * This method feeds the surname required to sign up
     */
    private void feedSurName() {
        String surName = getRandomSurName().get();
        log.debug("surName: " + surName);
        signUpPage.feedLastName(surName);
    }

    /**
     * This method feeds mobile required to sign up
     */
    private void feedMobile() {
        String mobile = getRandomMobile();
        log.debug("mobile:" + mobile);
        signUpPage.feedEmailOrMobile(mobile);
    }

    /**
     * This method feeds password required to sign up
     */
    private void feedPassword() {
        final String password = getRandomPassword().get();
        log.debug("password : " + password);
        signUpPage.feedPassword(password);
    }

    /**
     * This method feeds birth day required to sign up
     */
    private void feedBirthDay() {
        String randomDayOfMonth = getRandomDayOfMonth();
        log.debug("birthday : " + randomDayOfMonth);
        signUpPage.feedDayOfBirth(randomDayOfMonth);
    }

    /**
     * This method feeds birth month required to sign up
     */
    private void feedBirthMonth() {
        List<String> months = new ArrayList<>(12);
        months.add("Jan");
        months.add("Feb");
        months.add("Mar");
        months.add("Apr");
        months.add("May");
        months.add("Jun");
        months.add("Jul");
        months.add("Aug");
        months.add("Sep");
        months.add("Oct");
        months.add("Nov");
        months.add("Dec");

        final String month = months.get(new Random().nextInt(months.size()));
        log.debug("birthMonth : " + month);
        signUpPage.feedMonthOfBirth(month);
    }

    /**
     * This method feeds birth year required to sign up
     */
    private void feedBirthYear() {
        String year = getRandomYear();
        log.debug("birthYear : " + year);
        signUpPage.feedYearOfBirth(year);
    }

    /**
     * This method feeds gender required to sign up
     */
    private void feedGender() {
        List<String> genders = new ArrayList<>(2);
        genders.add("male");
        genders.add("female");
        final String gender = genders.get(new Random().nextInt(genders.size()));
        log.debug("gender :" + gender);
        signUpPage.feedGender(gender);
    }

    /**
     * This method submits the filled in page
     */
    private void hitSignUpPageButton() {
        log.debug("hitSignUpPageButton");
        signUpPage.submitButton();
    }

    /**
     * This method verfies the signed up user is logged in to verify their identity.
     */
    private void verifyLoggedIn() {
        log.debug("verifyLoggedIn");
        signUpPage.verifyLoggedInUser(firstName, driver);
    }

    /**
     * This method generates a random password
     */
    private static MockUnitString getRandomPassword() {
        return strings().size(10).accumulate(1, "\n");
    }

    /**
     * This method generates a random firstName
     */
    private static MockUnitString getRandomFirstName() {
        return names().first();
    }

    /**
     * This method generates a random surname
     */
    private static MockUnitString getRandomSurName() {
        return names().last();
    }

    /**
     * This method generates a random mobile
     */
    private static String getRandomMobile() {
        return "042" + ints().range(0000000, 9999999).get();
    }

    /**
     * This method picks a random day of the month.
     * to avoid complexity of leap years and shorter month of Feb,
     * consideration is given to avoid complexity at this point in time.
     */
    private static String getRandomDayOfMonth() {
        return ints().range(1, 28).get().toString();
    }

    /**
     * This method picks a random year.
     */
    private static String getRandomYear() {
        return ints().range(1950, 2000).get().toString();
    }

}