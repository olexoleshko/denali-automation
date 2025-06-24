package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactory.*;

import java.time.Duration;

public class RegisterSteps {

    WebDriver driver = null;
    HomePage homePage;
    RegisterPage registerPage;
    ContactPage contactPage;

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

    @Given("user is on the registration page")
    public void userIsOnTheRegistrationPage() {
        homePage = new HomePage(driver);

        driver.navigate().to("https://www.t-mobile.com/");
        homePage.clickRejectCookiesButton();
        homePage.clickMyAccountButton();
        homePage.clickRegisterButton();
    }

    @When("^user enters phone number: (.*)$")
    public void userEntersPhoneNumber(String phoneNumber) {
        registerPage = new RegisterPage(driver);

        registerPage.enterPhoneNumber(phoneNumber);
    }

    @And("clicks on the Next button on Register page")
    public void clicksOnTheNextButtonOnRegisterPage() {
        registerPage = new RegisterPage(driver);

        registerPage.clickNextButton();
    }

    @Then("user redirected to the Contact page")
    public void userRedirectedToTheContactPage() {
        contactPage = new ContactPage(driver);

        contactPage.verifyUrl();
    }

    @When("^user enters contact information: (.*), (.*), (.*), (.*) and (.*)$")
    public void userEntersContactInformation(String firstName, String lastName, String phoneNumber, String email, String password) {
        contactPage = new ContactPage(driver);

        contactPage.enterContactInformation(firstName, lastName, phoneNumber, email, password);
    }

    @And("clicks on the Create T-Mobile ID")
    public void clicksOnTheCreateTMobileID() {

    }

    @Then("user redirected to the Homepage")
    public void userRedirectedToTheHomepage() {

    }
}
