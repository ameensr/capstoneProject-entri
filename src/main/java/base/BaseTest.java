package base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
    protected ConfigReader config;
    //protected String baseUrl = "https://academybugs.com/";

    @BeforeClass(alwaysRun = true)
    public void setup() {

        config = new ConfigReader();
        String browser = config.getBrowser();

        if (browser == null || browser.trim().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } 
        else if (browser.trim().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } 
        else {
            throw new IllegalArgumentException("Unsupported browser in config.properties: " + browser);
        }

        driver.manage().window().maximize();

        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(config.getBaseUrl());

        // optional zoom
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='50%'");
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}