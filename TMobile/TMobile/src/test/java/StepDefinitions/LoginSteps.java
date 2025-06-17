package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver = null;

    @Given("browser is open")
    public void browser_is_open() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @And("user is on the login page")
    public void user_is_on_the_login_page() {
//        driver.navigate().to("https://www.t-mobile.com/");
//        driver.findElement(By.className("unav-account__toggle")).click();
    }

    @When("user enters invalid username")
    public void user_enters_invalid_username() {
        System.out.println("inside of second step");
    }

    @Then("error message displayed")
    public void error_message_displayed() {
        System.out.println("inside of third step");
    }

    @And("user stays on the same page")
    public void user_stays_on_the_same_page() {
        System.out.println("inside of fourth step");
    }
}
