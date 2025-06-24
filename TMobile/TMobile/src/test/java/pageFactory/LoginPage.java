package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "emailOrPhoneNumberTextBox")
    WebElement emailInput;

    @FindBy(id = "lp1-next-btn")
    WebElement nextButton;

    public void clickNextButton() {
        nextButton.click();
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void verifyErrorMessageDisplayed() {
        driver.getPageSource().contains("Sorry, something you entered does not match our records. Please try again.");
    }

    public void verifyValidationMessageDisplayed() {
        driver.getPageSource().contains("Enter a valid email or phone number.");
    }

    public void verifyUrl() {
        driver.getCurrentUrl().contains("https://account.t-mobile.com/signin");
    }
}
