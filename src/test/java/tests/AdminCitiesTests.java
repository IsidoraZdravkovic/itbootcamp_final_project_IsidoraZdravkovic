package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.LoginPage;
import utils.FakerClass;

public class AdminCitiesTests extends BaseTest {

    private LoginPage loginPage;
    private AdminCitiesPage adminCitiesPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.clickLoginPage();
        loginPage.login("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.urlContains("/home"));
        adminCitiesPage.home();
        adminCitiesPage.enterAdminCitiesPage();
        driverWait.until(ExpectedConditions.urlContains("/admin/cities"));


    }

    @Test
    public void RouteValidationAndLogoutButtonPresent() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(adminCitiesPage.isLogoutAdminButtonDisplayed());

    }

    @Test
    public void createNewCity() {
        adminCitiesPage.createNewCityMethod();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[3]/div")));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(adminCitiesPage.isMessageSaveDisplayed());

    }

    @Test
    public void editNewCity() {
        adminCitiesPage.editCreatedCityMethod();
        Assert.assertTrue(adminCitiesPage.isSaveEditedSuc());
    }

    @Test
    public void searchCity() throws InterruptedException {
        adminCitiesPage.search();
        Thread.sleep(2000);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("text-left")));
        Assert.assertTrue(adminCitiesPage.isVisibleResults());
        Assert.assertEquals(adminCitiesPage.fakeCityPlusEdited(), adminCitiesPage.getTextFromSearchResults());

    }

    @Test(priority = 5)
    public void deleteCity() throws InterruptedException {
        adminCitiesPage.search();

        adminCitiesPage.deleteCitiesOne();
        adminCitiesPage.deleteCitiesTwo();
        Thread.sleep(2000);
//        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("\"//*[@id=\\\"app\\\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]\"")));

        Assert.assertTrue(adminCitiesPage.isMessageDeleteSucDisplayed());


    }

    @AfterMethod
    public void afterMethod() {
        adminCitiesPage.clickLogOutAdmin();
    }


}
