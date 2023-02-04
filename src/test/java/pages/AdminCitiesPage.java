package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage{
    Faker faker = new Faker();
     String fakeCity = faker.address().city();

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]")
    private WebElement logoutAdminButton;

    @FindBy(className = "btnNewItem")
    private WebElement newItem;

    @FindBy(name = "name")
    private WebElement newItemInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageSaveSuccessful;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div[3]/button[2]/span")
    private WebElement citySave;
    @FindBy(xpath = "//*[@id=\"edit\"]/span")
    private WebElement editButton;

    @FindBy(id = "search")
    private WebElement inputSearch;

    @FindBy (id = "name")
    private WebElement inputEdited;

    @FindBy(className = "btnSave")
    private WebElement saveButtonForEditedCity;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageSaveSucefulyForEditedCity;
    @FindBy(xpath = "/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement searchResults;

    @FindBy(id ="delete") // trebalo bi da radi isto, ali aj da probamo
    private WebElement deleteButton;
@FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement confirmDeleteButton;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement isDeleteSuccessfulyMessageDisplayed;

//*[@id="app"]/div[5]/div/div/div[2]/button[2]/span

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void home () {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
    }

    public void enterAdminCitiesPage () {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
    }
    public boolean isLogoutAdminButtonDisplayed () {
        return logoutAdminButton.isDisplayed();
    }




    public void createNewCityMethod () {
        newItem.click();
        newItemInput.clear();
        newItemInput.sendKeys(fakeCity);
        citySave.click();
    }


    public boolean isMessageSaveDisplayed () {
        return messageSaveSuccessful.isDisplayed();
    }

    public void editCreatedCityMethod() {
        this.editButton.click();
        this.inputEdited.click();
        this.inputEdited.sendKeys(Keys.CONTROL + "a");
        this.inputEdited.sendKeys(Keys.DELETE);
        this.inputEdited.sendKeys(fakeCity + " - edited");
        saveButtonForEditedCity.click();
    }
    public boolean isSaveEditedSuc () {
       return messageSaveSucefulyForEditedCity.isDisplayed();
    }
    public void clickLogOutAdmin () {
        logoutAdminButton.click();
    }
    public void search () {
        inputSearch.click();
        inputSearch.sendKeys(fakeCity + " - edited");
    }
    public boolean isVisibleResults () {
        return searchResults.isDisplayed();
    }
    public String getTextFromSearchResults () {
        String expected = searchResults.getText();
        return expected;
    }
    public String fakeCityPlusEdited () {
        return fakeCity + " - edited";
    }
    public void deleteCitiesOne () {
        deleteButton.click();
    }
    public void deleteCitiesTwo() {
       confirmDeleteButton.click();

    }
    public boolean isMessageDeleteSucDisplayed () {
        return isDeleteSuccessfulyMessageDisplayed.isDisplayed();
    }








//cityField.sendKeys(city)
//cityField.sendKeys(Keys.CONTROL + "a")
//            cityField.sendKeys(Keys.DELETE)

//treba da fake city prebacis u base test..tako nesto je jovana rekla

}
