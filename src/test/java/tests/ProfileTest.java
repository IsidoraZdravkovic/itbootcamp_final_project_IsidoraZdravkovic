package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest{

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
        String name = faker.name().name();
        String phone = faker.phoneNumber().phoneNumber();
        String city = "Chicago";
        String country = faker.country().name();
        String twitter = "https://twitter.com/" + faker.name().firstName().toLowerCase();
        String gitHub = "https://github.com/" + faker.name().firstName().toLowerCase();
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
