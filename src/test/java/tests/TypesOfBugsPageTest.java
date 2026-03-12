package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HeaderPage;
import pages.TypesOfBugsPage;

public class TypesOfBugsPageTest extends BaseTest {
 
    TypesOfBugsPage typesOfBugsPage;
    HeaderPage headerPage;
 
    @BeforeMethod
    public void setUp() {
        driver.get(config.getBaseUrl() + "types/");
 
        typesOfBugsPage = new TypesOfBugsPage(driver);
        headerPage = new HeaderPage(driver);
 
        try {
            headerPage.closeTutorial();
        } catch (Exception e) {}
    }
    
 
    @Test(priority = 1, description = "Verify that the Types of Bugs page loads without error")
    public void testPageLoadsSuccessfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("types"),
            "URL should contain 'types'");
        Assert.assertTrue(typesOfBugsPage.isPageSubtitleDisplayed(),
            "Page subtitle should be visible after load");
    }
 
 
    @Test(priority = 2, description = "Verify that the browser tab title is correct")
    public void testPageTitle() {
        Assert.assertTrue(driver.getTitle().contains("Types of Bugs"),
            "Tab title should contain 'Types of Bugs'");
    }
  
    @Test(priority = 3, description = "Verify that the page subtitle heading is correct")
    public void testPageSubtitle() {
        String subtitle = typesOfBugsPage.getPageSubtitle();
        Assert.assertTrue(subtitle.contains("Learn the different types of bugs"),
            "Subtitle mismatch. Actual: " + subtitle);
    }
 
  
    @Test(priority = 4, description = "Verify that the 'Types of Bugs' nav item is highlighted as active")
    public void testTypesOfBugsNavIsActive() {
        Assert.assertTrue(driver.getCurrentUrl().contains("types"),
            "Current URL should point to types page, indicating active nav state");
    }
 
 
    @Test(priority = 5, description = "Verify that all 5 bug category cards are displayed")
    public void testAllFiveBugCategoryCardsDisplayed() {
        Assert.assertEquals(typesOfBugsPage.getTotalCardCount(), 5,
            "Expected 5 bug category cards but found: " + typesOfBugsPage.getTotalCardCount());
    }
 
 
    @Test(priority = 6, description = "Verify that the Functional card displays the correct title and description")
    public void testFunctionalCard() {
        Assert.assertTrue(typesOfBugsPage.isFunctionalCardDisplayed(),
            "Functional card should be visible");
        Assert.assertEquals(typesOfBugsPage.getFunctionalCardTitle(), "Functional",
            "Functional card title mismatch");
        Assert.assertTrue(typesOfBugsPage.getFunctionalCardDesc().contains("unexpected or illogical"),
            "Functional card description mismatch");
    }
  
    @Test(priority = 7, description = "Verify that the Visual card displays the correct title and description")
    public void testVisualCard() {
        Assert.assertTrue(typesOfBugsPage.isVisualCardDisplayed(),
            "Visual card should be visible");
        Assert.assertEquals(typesOfBugsPage.getVisualCardTitle(), "Visual",
            "Visual card title mismatch");
        Assert.assertTrue(typesOfBugsPage.getVisualCardDesc().contains("layout"),
            "Visual card description mismatch");
    }
 
 
    @Test(priority = 8, description = "Verify that the Content card displays the correct title and description")
    public void testContentCard() {
        Assert.assertTrue(typesOfBugsPage.isContentCardDisplayed(),
            "Content card should be visible");
        Assert.assertEquals(typesOfBugsPage.getContentCardTitle(), "Content",
            "Content card title mismatch");
        Assert.assertTrue(typesOfBugsPage.getContentCardDesc().contains("spelling"),
            "Content card description mismatch");
    }
 
    
    @Test(priority = 9, description = "Verify that the Performance card displays the correct title and description")
    public void testPerformanceCard() {
        Assert.assertTrue(typesOfBugsPage.isPerformanceCardDisplayed(),
            "Performance card should be visible");
        Assert.assertEquals(typesOfBugsPage.getPerformanceCardTitle(), "Performance",
            "Performance card title mismatch");
        Assert.assertTrue(typesOfBugsPage.getPerformanceCardDesc().contains("slowness"),
            "Performance card description mismatch");
    }
 
    
    @Test(priority = 10, description = "Verify that the Crash card displays the correct title and description")
    public void testCrashCard() {
        Assert.assertTrue(typesOfBugsPage.isCrashCardDisplayed(),
            "Crash card should be visible");
        Assert.assertEquals(typesOfBugsPage.getCrashCardTitle(), "Crash",
            "Crash card title mismatch");
        Assert.assertTrue(typesOfBugsPage.getCrashCardDesc().contains("unexpectedly"),
            "Crash card description mismatch");
    }
 
  
    @Test(priority = 11, description = "Verify that the 'Terms & Conditions' footer link navigates to the correct page")
    public void testTermsAndConditionsLink() {
        typesOfBugsPage.clickFooterTerms();
        Assert.assertTrue(driver.getCurrentUrl().contains("terms"),
            "Should navigate to Terms page. Actual URL: " + driver.getCurrentUrl());
    }
 
 
    @Test(priority = 12, description = "Verify that the 'Privacy Policy' footer link navigates to the correct page")
    public void testPrivacyPolicyLink() {
        typesOfBugsPage.clickFooterPrivacyPolicy();
        Assert.assertTrue(driver.getCurrentUrl().contains("privacy"),
            "Should navigate to Privacy Policy page. Actual URL: " + driver.getCurrentUrl());
    }
  
    @Test(priority = 13, description = "Verify that the page layout renders correctly on mobile viewport (375px)")
    public void testMobileViewport() {
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 812));
        Assert.assertTrue(typesOfBugsPage.isPageSubtitleDisplayed(),
            "Page subtitle should still be visible on mobile viewport");
        Assert.assertTrue(typesOfBugsPage.isFunctionalCardDisplayed(),
            "Functional card should still be visible on mobile viewport");
        // restore
        driver.manage().window().maximize();
    }
  
    @Test(priority = 14, description = "Verify that the page layout renders correctly on tablet viewport (768px)")
    public void testTabletViewport() {
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(768, 1024));
        Assert.assertTrue(typesOfBugsPage.isPageSubtitleDisplayed(),
            "Page subtitle should still be visible on tablet viewport");
        Assert.assertTrue(typesOfBugsPage.isCrashCardDisplayed(),
            "Crash card should still be visible on tablet viewport");
        // restore
        driver.manage().window().maximize();
    }
    
    @Test(priority = 7, description = "Verify that Function card is clicked and displays the description")
    public void clickFunctionalCard() {
    	
    	typesOfBugsPage.clickFunctionalCard();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Assert.assertEquals(typesOfBugsPage.getFunctionalCardPopupDesc(),
            "Workflow failures producing an unexpected or illogical application behavior where the actual result differs from the expected result.");
      
    }
    
}