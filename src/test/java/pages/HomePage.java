package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    @FindBy(className = "btnLogout")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div[3]/button")
    private WebElement close;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void logout() {
        logoutButton.click();
    }

    public void closeDialog() {
        close.click();
    }
}



