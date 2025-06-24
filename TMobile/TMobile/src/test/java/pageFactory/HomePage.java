package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(id = "onetrust-reject-all-handler")
    WebElement rejectCookiesButton;

    @FindBy(className = "unav-account__toggle")
    WebElement myAccountButton;

    @FindBy(css = "a[href=\"/account/dashboard?INTNAV=tNav:LogIn\"]")
    WebElement loginButton;

    @FindBy(css = "a[href=\"https://account.t-mobile.com/signin/v2/enterPhoneNumber \"]")
    WebElement registerButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRejectCookiesButton() {
        rejectCookiesButton.click();
    }

    public void clickMyAccountButton() {
        myAccountButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}
