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
    public void setUp()  {

	    driver.get("https://academybugs.com/#examples-of-bugs");

	    exampleOfBugsPage = new ExampleOfBugsPage(driver);
	    headerPage = new HeaderPage(driver);

	    try {
	        headerPage.closeTutorial();
	    } catch (Exception e) {
	    }
	}
        


    @Test(priority = 1)
    public void testSocialShareTile() throws InterruptedException {
    	exampleOfBugsPage.clickSocialShareTile();
        // Add assertion for the helpful message
        Assert.assertTrue(driver.getPageSource().contains("buttons don’t work"));
        Thread.sleep(3000);
        exampleOfBugsPage.clickpPopupTileClose();
    }

    @Test(priority = 2)
    public void testSendButtonTile() throws InterruptedException {
    	exampleOfBugsPage.clickSendButtonTile();
        // Add assertion for the detailed error message
        Assert.assertTrue(driver.getPageSource().contains("button returns an error page"));
        Thread.sleep(3000);
        exampleOfBugsPage.clickpPopupTileClose();
    }

    @Test(priority = 3)
    public void testVideoPlayerTile() throws InterruptedException {
    	exampleOfBugsPage.clickVideoPlayerTile();
        // Add assertion for troubleshooting guide
        Assert.assertTrue(driver.getPageSource().contains("example some videos can’t be played"));
        Thread.sleep(3000);
        exampleOfBugsPage.clickpPopupTileClose();
    }

    @Test(priority = 4)
    public void testArticlesErrorTile() throws InterruptedException {
    	exampleOfBugsPage.clickArticlesErrorTile();
        // Add assertion for support page link
        Assert.assertTrue(driver.getPageSource().contains("clicking an article shows an error page"));
        Thread.sleep(3000);
        exampleOfBugsPage.clickpPopupTileClose();
        // Ensure it does not lead to a blank page or 404 error
        Assert.assertFalse(driver.getCurrentUrl().contains("404"));
    }

    @Test(priority = 5)
    public void testSearchErrorTile() throws InterruptedException {
    	exampleOfBugsPage.clickSearchErrorTile();
        // Add assertion for suggestions
        Assert.assertTrue(driver.getPageSource().contains("leads to an error page"));
        Thread.sleep(3000);
        exampleOfBugsPage.clickpPopupTileClose();
    }

    @Test(priority = 6)
    public void testBookingTile() throws InterruptedException {
    	exampleOfBugsPage.clickBookingTile();
        // Add assertion for contact form
        Assert.assertTrue(driver.getPageSource().contains("submit the booking form"));
        Thread.sleep(3000);
        exampleOfBugsPage.clickpPopupTileClose();
    }

   
}