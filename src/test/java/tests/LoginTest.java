package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    Faker faker = new Faker();

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.clickLoginPage();


    }

    @Test
    public void LoginPresentInUrl() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void checkInputTypes() {
        String emailExpected = "email";
        String passwordExpected = "password";
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

        String emailActual = loginPage.getEmailField();
        String passwordActual = loginPage.getPassword();
        Assert.assertEquals(emailActual, emailExpected);
        Assert.assertEquals(passwordActual, passwordExpected);

    }

    @Test
    public void isErrorMessageDisplayedWhenUserDoesNotExists() {

        String email = faker.internet().emailAddress();
        String password = faker.internet().password();



        loginPage.login(email,password);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));


        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

    }

    @Test
    public void isErrorMessageDisplayedWhenPasswordIsWrong() {
        String validEmail = "admin@admin.com";
        String password = faker.internet().password();
        // jesi na login stranici ovde?
        loginPage.login(validEmail, password);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));
     ;
        Assert.assertTrue(loginPage.isErrorPasswordDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void isThereHomeRouteWhenLoggedIn() {
        String validEmail = "admin@admin.com";
        String validPassword = "12345";
        loginPage.login(validEmail, validPassword);
        driverWait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
        loginPage.logout();
    }

    @Test
    public void logoutButtonTest() throws InterruptedException {
        String validEmail = "admin@admin.com";
        String validPassword = "12345";
        Thread.sleep(3000);
        loginPage.login(validEmail, validPassword);
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed());
        loginPage.logout();
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));


    }



}

