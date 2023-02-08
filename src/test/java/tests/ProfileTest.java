package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProfilePage;
import pages.SignUpPage;
import utils.FakerClass;

public class ProfileTest extends BaseTest{
    private SignUpPage signUpPage;
    private ProfilePage profilePage;
    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        signUpPage = new SignUpPage(driver, driverWait);
        profilePage = new ProfilePage(driver,driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod () {
        super.beforeMethod();
        signUpPage.clickSignUpPage();
        signUpPage.validSignUp();
        profilePage.closeMessage();

    }
    @Test
    public void editProfile () {
        profilePage.myProfileButtonClick();
        String name = FakerClass.getFakeName();
        String phone = FakerClass.getFakePhone();
        String city = "Chicago";
        String country = FakerClass.getFakeCountry();
        String twitter = "https://twitter.com/" + FakerClass.getFakeName().toLowerCase();
        String gitHub = "https://github.com/" + FakerClass.getFakeName().toLowerCase();
        profilePage.editProfile(name,phone, city,country,twitter,gitHub);
        Assert.assertEquals(profilePage.getNameValue(),name);
        Assert.assertEquals(profilePage.getPhoneValue(),phone);
        Assert.assertEquals(profilePage.getCityValue(),city);
        Assert.assertEquals(profilePage.getCountryValue(),country);
        Assert.assertEquals(profilePage.getTwitterValue(),twitter);
        Assert.assertEquals(profilePage.getGitHubValue(),gitHub);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));
        Assert.assertTrue(profilePage.profileSavedSuccessfullyMessage());






    }
}
