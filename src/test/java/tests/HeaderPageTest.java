package tests;


import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HeaderPage;

public class HeaderPageTest extends BaseTest {

	@Test
    public void testAcademyBugsLink() {
        
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.closeTutorial();
        headerPage.clickAcademyBugsLink();
        
        Assert.assertEquals("https://academybugs.com/", driver.getCurrentUrl());
        driver.quit();
    }
	
	@Test
    public void testExamplesOfBugsLink() {
       
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.closeTutorial();
        headerPage.clickExamplesOfBugsLink();
        
        Assert.assertEquals("https://academybugs.com/", driver.getCurrentUrl());
        driver.quit();
    }
	
	@Test
    public void testTypesOfBugsLink() throws InterruptedException {
 
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.closeTutorial();
        headerPage.clickTypesOfBugsLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       // Thread.sleep(3000);
        
        Assert.assertEquals("https://academybugs.com/types/", driver.getCurrentUrl());
        driver.quit();
    }
	
	@Test
    public void testFindBugsLink() {
      
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.closeTutorial();
        headerPage.clickFindBugsLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        Assert.assertEquals("https://academybugs.com/find-bugs/", driver.getCurrentUrl());
        driver.quit();
    }
	
	 @Test
	    public void testReportBugsLink() {
	       
	        HeaderPage headerPage = new HeaderPage(driver);
	        headerPage.closeTutorial();
	        headerPage.clickReportBugsLink();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        
	        Assert.assertEquals("https://academybugs.com/report-bugs/", driver.getCurrentUrl());
	        driver.quit();
	    }
	 
	 @Test
	    public void testHelpIconVisibilityAndClick()  {
	       
	        HeaderPage headerPage = new HeaderPage(driver);
	        
	        Assert.assertTrue(headerPage.isHelpIconVisible());
	        headerPage.clickHelpIcon();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        Assert.assertEquals(headerPage.getTutorialPopupText(), "Tutorial");
	    }

    
    
    
}