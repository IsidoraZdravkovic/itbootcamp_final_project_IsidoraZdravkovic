package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LocalePage;

public class LocaleTest extends BaseTest{
    private LocalePage localePage;

    @BeforeMethod
    @Override
    public void beforeClass () {
        super.beforeClass();
        localePage = new LocalePage(driver,driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod () {
        super.beforeMethod();

    }

    @Test
    public void setLocaleToEs () throws InterruptedException {
        String expected = "Página de aterrizaje";
        localePage.spanishSet();
        Thread.sleep(3000);
        Assert.assertEquals(localePage.spanishMessage(),expected);


    }
    @Test
    public void setLocaleToEng() throws InterruptedException {
        String expected = "Landing";
        localePage.englishSet();
        Thread.sleep(3000);
        Assert.assertEquals(localePage.englishMessage(),expected);
    }


    @Test
    public void setLocaleToFrench () throws InterruptedException {
        String expected = "Page d'atterrissage";
        localePage.frenchSet();
        Thread.sleep(3000);
        Assert.assertEquals(localePage.frenchMessage(), expected);


    }



}
