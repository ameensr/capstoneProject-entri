package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
    protected ConfigReader config;

    @BeforeMethod
    public void setup() {

        config = new ConfigReader();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(config.getBaseUrl());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}