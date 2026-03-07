package tests;


import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HeaderPage;

public class HeaderPageTest extends BaseTest {
	
	HeaderPage headerPage;
	
	@BeforeMethod
    public void pageSetup() {
        headerPage = new HeaderPage(driver);
        try {
            headerPage.closeTutorial();
        } catch (Exception e) {
        }
    }

	@Test
    public void testAcademyBugsLink() {
        headerPage.clickAcademyBugsLink();
        Assert.assertEquals(driver.getCurrentUrl(), config.getBaseUrl());
    }

    @Test
    public void testExamplesOfBugsLink() {
        headerPage.clickExamplesOfBugsLink();
        Assert.assertEquals(driver.getCurrentUrl(), config.getBaseUrl());
    }

    @Test
    public void testTypesOfBugsLink() {
        headerPage.clickTypesOfBugsLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("types"));
    }

    @Test
    public void testFindBugsLink() {
        headerPage.clickFindBugsLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("find-bugs"));
    }

    @Test
    public void testReportBugsLink() {
        headerPage.clickReportBugsLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("report-bugs"));
    }

    @Test
    public void testHelpIconVisibilityAndClick() throws InterruptedException {

        Assert.assertTrue(headerPage.isHelpIconVisible());

        headerPage.clickHelpIcon();

        Assert.assertTrue(headerPage.isTutorialPopupDisplayed(),
                "Tutorial popup not displayed");

        Assert.assertEquals(headerPage.getTutorialPopupText(),
                "Tutorial",
                "Tutorial text mismatch");
    }
}