package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class cmsLogin {
    WebDriver driver;
    By loginButton = By.xpath("//a[normalize-space()='Login with Google']");
    By inputUsername = By.id("identifierId");
    By inputPassword = By.xpath("//input[@name='Passwd']");
    By nextButton = By.xpath("//span[normalize-space()='Next']");
    By appIntegrationTab = By.xpath("//a[normalize-space()='Apps and integrations']");
    By merchantRateTab = By.partialLinkText("Merchant rates testing");
    By searchMerchant = By.xpath("//input[@aria-autocomplete='list']");
    By sumbitButton = By.cssSelector("button[class='btn btn-success']");

    public cmsLogin(WebDriver driver){
        this.driver = driver;
    }

    public void searchGoogle() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsername));
        driver.findElement(inputUsername).sendKeys("doppler-contributor@fluz.app");
        driver.findElement(nextButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys("wiwwK5Zhc[7<VWAI]<RH");
        driver.findElement(nextButton).click();
    }

    public void searchMerchantRate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(appIntegrationTab));
        driver.findElement(appIntegrationTab).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(merchantRateTab));
        driver.findElement(merchantRateTab).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchMerchant));
        driver.findElement(searchMerchant).sendKeys("Amazon");

        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(searchMerchant), Keys.ENTER).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(sumbitButton));
        driver.findElement(sumbitButton).click();
    }


}
