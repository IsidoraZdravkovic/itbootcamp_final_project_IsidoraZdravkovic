package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthRoutesPage;
import pages.BasePage;

public class AuthRoutesTest extends BaseTest{
    private AuthRoutesPage authRoutesPage;


    @BeforeClass
    @Override
    public void beforeClass () {
        super.beforeClass();


    }

    @BeforeMethod
    @Override
    public void beforeMethod () {
        super.beforeMethod();
        authRoutesPage = new AuthRoutesPage(driver, driverWait);

    }


    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticatedAssert () {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

    }

    @Test
    public void visitProfileTest () {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

    }

    @Test
    public void visitAdminCitiesTest () {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));


    }
    @Test
    public void visitAdminUsersTest () {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        driverWait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
