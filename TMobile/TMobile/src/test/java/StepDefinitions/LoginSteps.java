package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactory.HomePage;
import pageFactory.LoginPage;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver = null;
    HomePage homePage;
    LoginPage loginPage;

    @Before
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        driver.close();
        driver.quit();
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        homePage = new HomePage(driver);

        driver.navigate().to("https://www.t-mobile.com/");
        homePage.clickRejectCookiesButton();
        homePage.clickMyAccountButton();
        homePage.clickLoginButton();
    }

    @When("^user enters invalid email: (.*)$")
    public void userEntersInvalidEmail(String email) {
        loginPage = new LoginPage(driver);

        loginPage.enterEmail(email);
    }

    @And("clicks on the Next button on Login Page")
    public void clicksOnTheNextButtonOnLoginPage() {
        loginPage = new LoginPage(driver);

        loginPage.clickNextButton();
    }

    @Then("error message displayed")
    public void errorMessageDisplayed() {
        loginPage = new LoginPage(driver);

        loginPage.verifyErrorMessageDisplayed();
    }

    @And("user stays on the same page")
    public void userStaysOnTheSamePage() {
        loginPage = new LoginPage(driver);

        loginPage.verifyUrl();
    }

    @Then("validation message displayed")
    public void validationMessageDisplayed() {
        loginPage = new LoginPage(driver);

        loginPage.verifyValidationMessageDisplayed();
    }

    @When("^user enters non-existing email: (.*)$")
    public void userEntersNonExistingEmail(String email) {
        loginPage = new LoginPage(driver);

        loginPage.enterEmail(email);
    }
}
