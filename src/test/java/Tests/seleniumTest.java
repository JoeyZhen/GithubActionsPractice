package Tests;
import POM.cmsLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class seleniumTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Starting Test On Chrome Browser");
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        String baseUrl = "https://cms.staging.fluzapp.com";
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

//    @Test
//    public void Login()  throws InterruptedException{
//          cmsLogin c = new cmsLogin(driver);
//          c.searchGoogle();
//          String testTitle = "Tools QA";
//          String originalTitle = driver.getTitle();
//          Assert.assertEquals(originalTitle, testTitle);
//    }

    @Test
    public void clickRateTab()  throws InterruptedException{
        cmsLogin c = new cmsLogin(driver);
        c.searchGoogle();
        c.searchMerchantRate();
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
        System.out.println("Finished Test On Chrome Browser");
    }
}