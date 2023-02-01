package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy(id = "email")
    private WebElement emailField;


    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement errorMessage;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement errorPasswordMessage;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logoutButton;

    public void clickLoginPage() {
        login.click();
    }
    public String getEmailField () {
        return emailField.getAttribute("type");
    }
    public String getPassword() {
        return  password.getAttribute("type");
    }

    public void login(String username, String password) {
        this.emailField.clear();
        this.password.clear();

        this.emailField.sendKeys(username);
        this.password.sendKeys(password);

        loginButton.click();
    }
    public boolean isErrorMessageDisplayed () {
        return errorMessage.isDisplayed();
    }

    public boolean isErrorPasswordDisplayed() {
        return  errorPasswordMessage.isDisplayed();
    }
    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    public void logout () {
        logoutButton.click();
    }


}

