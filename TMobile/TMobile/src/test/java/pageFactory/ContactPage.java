package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameInput;

    @FindBy(id = "lastName")
    WebElement lastNameInput;

    @FindBy(id = "PhoneNumber")
    WebElement phoneNumberInput;

    @FindBy(id = "Email")
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    public void enterContactInformation(String firstName, String lastName, String phoneNumber, String email, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        phoneNumberInput.sendKeys(phoneNumber);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void verifyUrl() {
        driver.getCurrentUrl().contains("https://account.t-mobile.com/signup/v2/createaccount");
    }
}
