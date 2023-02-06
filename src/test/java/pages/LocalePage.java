package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage{
    public LocalePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    @FindBy (className = "btnLocaleActivation")
    private WebElement language;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]")
    private WebElement spanish;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]")
    private WebElement french;
    @FindBy (xpath = "/html/body/div/div[2]/div/div[1]")
    private WebElement english;
    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement spanishMessage;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement frenchMessage;
    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement englishMessage;



    public void spanishSet() throws InterruptedException {
        language.click();
        Thread.sleep(3000);
        spanish.click();
    }
    public void frenchSet () throws InterruptedException {
        language.click();
        Thread.sleep(3000);
        french.click();
    }
    public void englishSet () throws InterruptedException {
        language.click();
        Thread.sleep(3000);
        english.click();
    }
    public String spanishMessage () {
       String actual = spanishMessage.getText();
       return actual;
    }
    public String frenchMessage () {
        String actual = frenchMessage.getText();
        return actual;
    }
    public String englishMessage () {
        String actual = englishMessage.getText();
        return actual;

}}
