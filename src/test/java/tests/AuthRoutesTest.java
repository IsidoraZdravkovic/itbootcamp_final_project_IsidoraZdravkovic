package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest{

    @BeforeMethod
    @Override
    public void beforeMethod () {
        super.beforeMethod();

    }
    //Test #1: Forbids visits to home url if not authenticated
    //assert:
    //•	Ucitati /home stranu kada korisnik nije ulogovan
    //•	Verifikovati da se u url-u stranice javlja ruta /login

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
