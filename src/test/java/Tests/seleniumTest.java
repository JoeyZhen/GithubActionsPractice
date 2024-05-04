package Tests;
import POM.cmsLogin;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class seleniumTest {
    WebDriver driver;
    static ExtentReports reports;

    public static ExtentTest test;

    static ExtentReports extent = new ExtentReports();

    @BeforeMethod
    public void beforeMethod() {
        ExtentSparkReporter spark = new ExtentSparkReporter("src/test/reports");
        extent.attachReporter(spark);
        System.out.println("Starting Test On Chrome Browser");
        String baseUrl = "https://cms.staging.fluzapp.com";
        FirefoxOptions options = new FirefoxOptions();
//        options.setAcceptInsecureCerts(true);
        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--start-maximized");
//        options.addArguments("--remote-debugging-pipe");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--disable-dev-shm-usage");
//        driver = new ChromeDriver(options);
        driver = new FirefoxDriver(options);
        driver.get(baseUrl);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void Login()  throws InterruptedException{
          test = extent.createTest("Validate merchant rate","This test should be fail");
          cmsLogin c = new cmsLogin(driver);
//        String originalTitle = driver.getTitle();
//        System.out.println(originalTitle);
          c.searchGoogle();
          extent.flush();
    }

    @Test
    public void clickRateTab()  throws InterruptedException{
        test = extent.createTest("Validate merchant rate","This test pass");
        cmsLogin c = new cmsLogin(driver);
        c.searchGoogle();
        c.searchMerchantRate();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        System.out.println("Finished Test On Chrome Browser");
        extent.flush();
    }
}