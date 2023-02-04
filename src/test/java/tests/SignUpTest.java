package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpPage;
import sun.awt.windows.ThemeReader;

public class SignUpTest extends BaseTest {
    Faker faker = new Faker();

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        signUpPage.clickSignUpPage();
    }


        @Test
    public void visitTheSigunUpPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));

    }

    @Test
    public void CheckInputTypes() {
        driverWait.until(ExpectedConditions.urlContains("/signup"));
        String expectedEmailType = "email";
        String expectedPasswordType = "password";
        String expectedConfirmPasswordType = "password";

        String actualEmailType = signUpPage.getEmailSignUpType();
        String actualPasswordType = signUpPage.getPasswordSignUpType();
        String actualConfirmPasswordType = signUpPage.getConfirmPasswordSignUpType();
        Assert.assertEquals(actualEmailType, expectedEmailType);
        Assert.assertEquals(actualPasswordType, expectedPasswordType);
        Assert.assertEquals(actualConfirmPasswordType, expectedConfirmPasswordType);

    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists() throws InterruptedException {

        String name = "Test Test";
        String email = "admin@admin.com";
        String password = "123654";
        String confirmPassword = "123654";
        signUpPage.signUp(name, email, password, confirmPassword);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(signUpPage.ErrorMessageUserAlreadyExists());
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));


    }

    @Test
    public void signUp() {
        signUpPage.validSignUp();
        driverWait.until(ExpectedConditions.urlContains("/home"));

        driver.navigate().refresh();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[1]")));

        Assert.assertTrue(signUpPage.isThereNotifyMessageDisplayed());
        homePage.closeDialog();
        homePage.logout();


    }



}
