package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HeaderPage;

public class HeaderTest extends BaseTest {

    @Test
    public void verifyExamplesNavigation() {

        HeaderPage headerPage = new HeaderPage(driver);

        headerPage.closeTutorial();
        headerPage.clickExamplesOfBugs();

        String expectedUrl = config.getBaseUrl() + "examples-of-bugs";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains("examples"),
                "Navigation to Examples of Bugs page failed");
    }
}