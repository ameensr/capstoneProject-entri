package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
    protected ConfigReader config;
    protected String baseUrl = "https://academybugs.com/";

    @BeforeMethod(alwaysRun = true)
    public void setup() throws InterruptedException {

        config = new ConfigReader();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(config.getBaseUrl());
        
        
        Thread.sleep(3000);

        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='50%'");
        driver.get(baseUrl + "#examples-of-bugs");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}