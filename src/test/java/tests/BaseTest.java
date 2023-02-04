package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BaseTest {
    Faker faker = new Faker();
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;
    protected AdminCitiesPage adminCitiesPage;
    protected AuthRoutesPage authRoutesPage;
protected HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Bootcamp\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, driverWait);
        signUpPage = new SignUpPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        authRoutesPage = new AuthRoutesPage(driver,driverWait);
        homePage = new HomePage(driver, driverWait);



    }

    @BeforeMethod
    public void beforeMethod () {
        driver.get("https://vue-demo.daniel-avellaneda.com");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
