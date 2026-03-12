package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ExampleOfBugsPage;
import pages.HeaderPage;

public class ExampleOfBugsPageTest extends BaseTest {
	
	ExampleOfBugsPage exampleOfBugsPage;
    HeaderPage headerPage;

	
    @BeforeMethod
    public void setUp() {

        driver.get(config.getBaseUrl() + "#examples-of-bugs");

        exampleOfBugsPage = new ExampleOfBugsPage(driver);
        headerPage = new HeaderPage(driver);

        try {
            headerPage.closeTutorial();
        } catch (Exception e) {}
    }
        


    @Test(priority = 1)
    public void testSocialShareTile()  {
    	exampleOfBugsPage.clickSocialShareTile();
        // Add assertion for the helpful message
        Assert.assertTrue(driver.getPageSource().contains("buttons don’t work"));
        
        exampleOfBugsPage.closePopup();
    }

    @Test(priority = 2)
    public void testSendButtonTile()  {
    	exampleOfBugsPage.clickSendButtonTile();
        // Add assertion for the detailed error message
        Assert.assertTrue(driver.getPageSource().contains("button returns an error page"));
        
        exampleOfBugsPage.closePopup();
    }

    @Test(priority = 3)
    public void testVideoPlayerTile()  {
    	exampleOfBugsPage.clickVideoPlayerTile();
        // Add assertion for troubleshooting guide
        Assert.assertTrue(driver.getPageSource().contains("example some videos can’t be played"));
        
        exampleOfBugsPage.closePopup();
    }

    @Test(priority = 4)
    public void testArticlesErrorTile() {
        exampleOfBugsPage.clickArticlesErrorTile();
        Assert.assertTrue(driver.getPageSource().contains("article shows an error page"));
        exampleOfBugsPage.closePopup();
    }

    @Test(priority = 5)
    public void testSearchErrorTile() {
    	exampleOfBugsPage.clickSearchErrorTile();
        // Add assertion for suggestions
        Assert.assertTrue(driver.getPageSource().contains("leads to an error page"));
        exampleOfBugsPage.closePopup();
    }

    @Test(priority = 6)
    public void testBookingTile()  {
    	exampleOfBugsPage.clickBookingTile();
        // Add assertion for contact form
        Assert.assertTrue(driver.getPageSource().contains("submit the booking form"));
        exampleOfBugsPage.closePopup();
    }

    
   
}