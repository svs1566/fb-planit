package org.demo.web.pages;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.demo.web.runner.WebInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@Slf4j
public class SignUpPage extends WebInitializer {

    private WebDriver driver = new WebInitializer().initialize();

    @FindBy(how = How.NAME, using = "firstname")
    private WebElement firstName;

    @FindBy(how = How.NAME, using = "lastname")
    private WebElement lastName;

    @FindBy(how = How.NAME, using = "reg_email__")
    private WebElement emailOrMobile;

    @FindBy(how = How.NAME, using = "reg_passwd__")
    private WebElement password;

    @FindBy(how = How.NAME, using = "birthday_day")
    private WebElement dayOfBirth;

    @FindBy(how = How.NAME, using = "birthday_month")
    private WebElement monthOfBirth;

    @FindBy(how = How.NAME, using = "birthday_year")
    private WebElement yearOfBirth;

    @FindBy(how = How.CSS, using = "input[type='radio'][value='2']")
    private WebElement genderMale;

    @FindBy(how = How.CSS, using = "input[type='radio'][value='1']")
    private WebElement genderFemale;

    @FindBy(how = How.NAME, using = "websubmit")
    private WebElement submitButton;

    public void feedFirstName(final String firstname) {
        firstName.sendKeys(firstname);
    }

    public void feedLastName(final String lastname) {
        lastName.sendKeys(lastname);
    }

    public void feedEmailOrMobile(final String mobileOrEmail) {
        emailOrMobile.sendKeys(mobileOrEmail);
    }

    public void feedPassword(final String passwordParam) {
        password.sendKeys(passwordParam);
    }

    public void feedDayOfBirth(final String dayOfBirthParam) {
        Select select = new Select(dayOfBirth);
        select.selectByVisibleText(dayOfBirthParam);
    }

    public void feedMonthOfBirth(final String monthOfBirthParam) {
        Select select = new Select(monthOfBirth);
        select.selectByVisibleText(monthOfBirthParam);
    }

    public void feedYearOfBirth(final String yearOfBirthParam) {
        Select select = new Select(yearOfBirth);
        select.selectByVisibleText(yearOfBirthParam);
    }

    public void feedGender(final String genderParam) {
        if (StringUtils.isNotBlank(genderParam) && genderParam.equals("female")) {
            genderFemale.click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        } else {
            genderMale.click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
    }

    public void submitButton() {
        submitButton.click();
    }

    @Override
    public String toString() {
        return "SignUpPage{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", email='" + emailOrMobile + '\'' +
                ", password='" + password + '\'' +
                ", dateofbirth='" + dayOfBirth + '\'' +
                ", monthofbirth='" + monthOfBirth + '\'' +
                ", yearofbirth='" + yearOfBirth + '\'' +
                ", genderMale='" + genderMale + '\'' +
                ", genderFemale='" + genderFemale + '\'' +
                '}';
    }

    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyLoggedInUser(final String firstName, WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"bluebar_profile_and_home\"]/div/div/a/span/span"));
        log.debug(element.getText());
        log.debug("firstName: " + firstName);
        assertEquals(element.getText(), firstName);
    }
}
