package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FakerClass;

public class SignUpPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]")
    private WebElement singUpButton;
    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement emailSignUp;

    @FindBy (id = "password")
    private WebElement passwordSignUp;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")
    private WebElement errorMessageUserAlreadyExists;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement signUpUser;
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div[1]")
    private WebElement notifyMessage;

    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickSignUpPage() {
        singUpButton.click();
    }
    public String getConfirmPasswordSignUpType () {
        return confirmPassword.getAttribute("type");
    }

    public String getEmailSignUpType (){
        return emailSignUp.getAttribute("type");

    }
    public String getPasswordSignUpType () {
        return passwordSignUp.getAttribute("type");
    }

    public boolean ErrorMessageUserAlreadyExists() {
        return errorMessageUserAlreadyExists.isDisplayed();
    }

    public void signUp (String name, String email, String password, String confirmPassword) {
        this.name.sendKeys(name);
        this.emailSignUp.sendKeys(email);
        this.passwordSignUp.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        signUpUser.click();

    }
    public void validSignUp () {
        this.name.sendKeys(FakerClass.getFakeName());
        this.emailSignUp.sendKeys(FakerClass.getFakeEmail());
        this.passwordSignUp.sendKeys("12345");
        this.confirmPassword.sendKeys("12345");
        signUpUser.click();
    }
    public boolean isThereNotifyMessageDisplayed () {
        return notifyMessage.isDisplayed();
    }





}

