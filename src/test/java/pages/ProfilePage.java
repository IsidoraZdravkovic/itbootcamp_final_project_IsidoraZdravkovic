package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{


    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement myProfileButton;
    @FindBy(id ="name")
    private WebElement editName;
    @FindBy(id = "phone")
    private WebElement editPhone;
    @FindBy(id = "city")
    private WebElement editCity;
    @FindBy(id = "country")
    private WebElement editCountry;
    @FindBy(id = "urlTwitter")
    private WebElement editTwitter;
    @FindBy(id = "urlGitHub")
    private WebElement editGitHub;
    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement verifyMessageProfile;
    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[3]/button")
    private WebElement closeVerifyMessageButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveEditProfileButton;
    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement profileSavedSuccessfullyMessage;

    public void myProfileButtonClick () {
        myProfileButton.click();

    }
    public void editNameMethod (String name) {
        editName.click();
        editName.sendKeys(Keys.CONTROL + "a");
        editName.sendKeys(Keys.ENTER);
        editName.sendKeys(name);

    }

    public void closeMessage () {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")));
        closeVerifyMessageButton.click();

    }
    public void editPhoneMethod(String phone) {
        editPhone.click();
        editPhone.clear();
        editPhone.sendKeys(phone);
    }
    public void editCityMethod (String city) {
        editCity.click();
        editCity.sendKeys(Keys.CONTROL + "a");
        editCity.sendKeys(Keys.DELETE);
        editCity.sendKeys(city);
        editCity.sendKeys(Keys.TAB);

    }
    public void editCountryMethod(String country) {
        editCountry.click();
        editCountry.sendKeys(country);
    }
    public void editTwitterMethod(String twitter) {
        editTwitter.click();
        editTwitter.sendKeys(twitter);

    }
    public void editGitHubMethod(String gitHub) {
        editGitHub.click();
        editGitHub.sendKeys(gitHub);
    }
    public void clickSaveEditProfileButton () {
        saveEditProfileButton.click();
    }
    public boolean profileSavedSuccessfullyMessage () {
        return profileSavedSuccessfullyMessage.isDisplayed();
    }
    public void editProfile (String name,String phone,String city,String country, String twitter, String gitHub) {
       editNameMethod(name);
       editPhoneMethod(phone);
       editCityMethod(city);
       editCountryMethod(country);
       editTwitterMethod(twitter);
       editGitHubMethod(gitHub);
       clickSaveEditProfileButton();

    }
    public String getNameValue () {
       return editName.getAttribute("value");
    }
    public String getPhoneValue () {
        return editPhone.getAttribute("value");

    }
    public String getCityValue () {
        return editCity.getAttribute("value");

    }
    public String getCountryValue () {
        return editCountry.getAttribute("value");

    }
    public String getTwitterValue () {
        return editTwitter.getAttribute("value");

    }
    public String getGitHubValue() {
        return editGitHub.getAttribute("value");
    }
}
