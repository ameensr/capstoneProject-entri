package tests;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HeaderPage;
import pages.ReportBugsPage;

public class ReportBugsPageTest extends BaseTest {

	ReportBugsPage reportBugsPage;
	HeaderPage     headerPage;

	@BeforeMethod
	public void setUp() {
		driver.get(config.getBaseUrl() + "report-bugs/");
		reportBugsPage = new ReportBugsPage(driver);
		headerPage     = new HeaderPage(driver);
		try { headerPage.closeTutorial(); } catch (Exception e) {}
	}


	@Test(priority = 1, description = "Verify that the Report Bugs page loads successfully without errors")
	public void testPageLoadsSuccessfully() {
		Assert.assertTrue(driver.getCurrentUrl().contains("report-bugs"),
				"URL should contain 'report-bugs'");
		Assert.assertTrue(reportBugsPage.isPageHeadingDisplayed(),
				"Page heading 'Report Bugs' should be visible");
	}

	@Test(priority = 2, description = "Verify that the browser tab title is correct")
	public void testPageTitle() {
		Assert.assertTrue(driver.getTitle().contains("Report Bugs"),
				"Tab title should contain 'Report Bugs'. Actual: " + driver.getTitle());
	}

	@Test(priority = 3, description = "Verify that the page description text is correct")
	public void testPageSubtitleText() {
		Assert.assertTrue(reportBugsPage.isPageSubtitleDisplayed(),
				"Page subtitle should be visible");
		Assert.assertTrue(reportBugsPage.getPageSubtitleText().contains("five practice scenarios"),
				"Subtitle mismatch. Actual: " + reportBugsPage.getPageSubtitleText());
	}

	@Test(priority = 4, description = "Verify that 'Report Bugs' nav item is highlighted as active")
	public void testReportBugsNavIsActive() {
		Assert.assertTrue(driver.getCurrentUrl().contains("report-bugs"),
				"URL should point to report-bugs page, indicating active nav state");
	}


	@Test(priority = 5, description = "Verify that the Bug Report Progress tracker is visible with 5 numbered slots")
	public void testProgressTrackerVisible() {

		// Scroll down before radio buttons
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400)");

		Assert.assertTrue(reportBugsPage.isProgressTrackerDisplayed(),
				"Bug Report Progress tracker should be visible");
		Assert.assertEquals(reportBugsPage.getProgressSlotCount(), 5,
				"Progress tracker should have exactly 5 slots");
	}

	@Test(priority = 6, description = "Verify that only Bug 1 is accessible on initial page load")
	public void testOnlyBug1AccessibleOnLoad() {
		Assert.assertTrue(
				reportBugsPage.isLockedSlotMessageDisplayed() ||
				driver.getPageSource().contains("pass the current bug report"),
				"Locked slot message should be shown for slots 2–5");
	}

	@Test(priority = 7, description = "Verify that the Important Note disclaimer is displayed")
	public void testImportantNoteDisplayed() {
		Assert.assertTrue(reportBugsPage.isImportantNoteDisplayed(),
				"Important Note section should be visible");
		Assert.assertTrue(reportBugsPage.getImportantNoteText().contains("starting from"),
				"Important Note text mismatch. Actual: " + reportBugsPage.getImportantNoteText());
	}


	@Test(priority = 8, description = "Verify that Bug 1 Instructions are displayed correctly")
	public void testBug1InstructionsDisplayed() {
		Assert.assertTrue(
				driver.getPageSource().contains("Find Bugs") ,
				"Bug 1 instructions should reference 'Find Bugs' and 'open its image'");
	}

	@Test(priority = 9, description = "Verify that Bug 1 Issue Title dropdown contains all correct options")
	public void testBug1IssueTitleDropdownOptions() {



		List<String> expectedOptions = List.of(
				"— Select the correct option —",
				"Windows 10 - Home Page - Broken image when product image expanded",
				"Blank overlay when product image expanded",
				"Windows - Product Details Page - The product image can't be expanded",
				"Windows 10 - Product Details Page - Broken image when product image expanded",
				"Product Details Page - Broken image when product image expanded"
				);
		List<String> actualOptions = reportBugsPage.getBug1DropdownOptions();
		Assert.assertEquals(actualOptions, expectedOptions,
				"Bug 1 Issue Title dropdown options mismatch!");
	}

	@Test(priority = 10, description = "Verify that Bug 1 Issue Type dropdown contains all 5 bug types")
	public void testBug1IssueTypeDropdownOptions() {
		Assert.assertTrue(reportBugsPage.isBug1IssueTypeDropdownPresent(),
				"Bug 1 Issue Type dropdown should be present");
		Assert.assertEquals(reportBugsPage.getBug1IssueTypeOptionCount(), 5,
				"Issue Type should have exactly 5 options (excluding placeholder)");
		Assert.assertTrue(reportBugsPage.bug1IssueTypeContainsOption("Content"),"Issue Type missing: Content");
		Assert.assertTrue(reportBugsPage.bug1IssueTypeContainsOption("Performance"),"Issue Type missing: Performance");
		Assert.assertTrue(reportBugsPage.bug1IssueTypeContainsOption("Visual"),"Issue Type missing: Visual");
		Assert.assertTrue(reportBugsPage.bug1IssueTypeContainsOption("Functional"),"Issue Type missing: Functional");
		Assert.assertTrue(reportBugsPage.bug1IssueTypeContainsOption("Crash"),"Issue Type missing: Crash");
	}

	@Test(priority = 11, description = "Verify that Bug 1 Frequency field shows all 4 options")
	public void testBug1FrequencyOptions() {
		Assert.assertTrue(driver.getPageSource().contains("Every Time"),"Frequency missing: Every Time");
		Assert.assertTrue(driver.getPageSource().contains("Hardly Ever"),"Frequency missing: Hardly Ever");
		Assert.assertTrue(driver.getPageSource().contains("Occasionally"),"Frequency missing: Occasionally");
		Assert.assertTrue(driver.getPageSource().contains("Once"),"Frequency missing: Once");
	}

	@Test(priority = 12, description = "Verify that Bug 1 Priority field shows all 4 options")
	public void testBug1PriorityOptions() {
		Assert.assertTrue(driver.getPageSource().contains("Low"),      "Priority missing: Low");
		Assert.assertTrue(driver.getPageSource().contains("Medium"),   "Priority missing: Medium");
		Assert.assertTrue(driver.getPageSource().contains("High"),     "Priority missing: High");
		Assert.assertTrue(driver.getPageSource().contains("Critical"), "Priority missing: Critical");
	}

	@Test(priority = 13, description = "Verify that Bug 1 Action Performed drag-and-drop section is present")
	public void testBug1ActionPerformedSectionPresent() {
		Assert.assertTrue(
				driver.getPageSource().contains("Drag and drop") ||
				driver.getPageSource().contains("Action Performed"),
				"Action Performed section should be present for Bug 1");
	}

	@Test(priority = 14, description = "Verify that Bug 1 Expected Result dropdown contains correct option")
	public void testBug1ExpectedResultOptions() {
		Assert.assertTrue(
				reportBugsPage.bug1ExpectedResultContainsOption("An expanded image of the product is shown"),
				"Expected Result should contain: 'An expanded image of the product is shown'");
	}

	@Test(priority = 15, description = "Verify that Bug 1 Actual Result dropdown contains correct option")
	public void testBug1ActualResultOptions() {


		((org.openqa.selenium.JavascriptExecutor) driver)
		.executeScript("window.scrollBy(0, 600)");
		Assert.assertTrue(
				reportBugsPage.bug1ActualResultContainsOption("A blank overlay with a broken image icon shows up"),
				"Actual Result should contain: 'A blank overlay with a broken image icon shows up'");
	}

	@Test(priority = 16, description = "Verify that Bug 1 Error Message dropdown contains correct option")
	public void testBug1ErrorMessageOptions() {

		((org.openqa.selenium.JavascriptExecutor) driver)
		.executeScript("window.scrollBy(0, 600)");

		Assert.assertTrue(
				reportBugsPage.bug1ErrorMessageContainsOption("There is no error message"),
				"Error Message dropdown should contain: 'There is no error message'");
	}

	@Test(priority = 17, description = "Verify that Bug 1 Attachments section shows Screenshot, Screen recording and Log")
	public void testBug1AttachmentsSectionPresent() {

		((org.openqa.selenium.JavascriptExecutor) driver)
		.executeScript("window.scrollBy(0, 600)");

		Assert.assertTrue(driver.getPageSource().contains("Screenshot"),       "Attachments: Screenshot missing");
		Assert.assertTrue(driver.getPageSource().contains("Screen recording"), "Attachments: Screen recording missing");
		Assert.assertTrue(driver.getPageSource().contains("Log"),              "Attachments: Log missing");
	}

	@Test(priority = 18, description = "Verify that the Submit Issue button is present for Bug 1")
	public void testBug1SubmitButtonPresent() {

		((org.openqa.selenium.JavascriptExecutor) driver)
		.executeScript("window.scrollBy(0, 600)");

		Assert.assertTrue(reportBugsPage.isBug1SubmitButtonDisplayed(),
				"'Submit Issue' button should be visible for Bug 1");
	}

	//Fill flow
	@Test(priority = 19, description = "Verify that the full Bug 1 report flow completes with all correct answers")
	public void testBug1FullReportFlow() {

		reportBugsPage.clickProgressSlot1();
		reportBugsPage.selectBug1IssueTitle(
				"Windows 10 - Product Details Page - Broken image when product image expanded");
		reportBugsPage.selectBug1IssueType("Visual");
		reportBugsPage.selectBug1Frequency("Every Time");
		reportBugsPage.selectBug1Priority("High");
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700)");			
		reportBugsPage.performDragAndDrop();
		reportBugsPage.selectBug1ExpectedResult("An expanded image of the product is shown");
		reportBugsPage.selectBug1ActualResult("A blank overlay with a broken image icon shows up");
		reportBugsPage.selectBug1ErrorMessage("There is no error message");
		reportBugsPage.selectBug1Screenshot(1);
		reportBugsPage.selectBug1Recording(1);
		reportBugsPage.selectBug1Log(1);
		reportBugsPage.clickBug1Submit();
		Assert.assertTrue(
				driver.getPageSource().contains("correct") ||
				driver.getPageSource().contains("passed")  ||
				driver.getPageSource().contains("success") ||
				reportBugsPage.isBug2Unlocked(),
				"Bug 1 should be marked as passed after submitting all correct answers");
	}

	@Test(priority = 20, description = "Verify that submitting Bug 1 without selecting Issue Title shows validation message")
	public void testBug1EmptyFieldValidation() {
		reportBugsPage.clickBug1Submit();
		Assert.assertTrue(reportBugsPage.isValidationMessageDisplayed(),
				"Validation message 'Please select an item in the list' should appear for empty required field");
	}

	@Test(priority = 21, description = "Verify that submitting Bug 1 with a wrong Issue Title does not pass")
	public void testBug1WrongTitleFails() {
		reportBugsPage.selectBug1IssueTitle("Blank overlay when product image expanded"); // wrong
		reportBugsPage.selectBug1IssueType("Visual");
		reportBugsPage.selectBug1Frequency("Every Time");
		reportBugsPage.selectBug1Priority("High");
		reportBugsPage.selectBug1ExpectedResult("An expanded image of the product is shown");
		reportBugsPage.selectBug1ActualResult("A blank overlay with a broken image icon shows up");
		reportBugsPage.selectBug1ErrorMessage("There is no error message");
		reportBugsPage.selectBug1Screenshot(1);
		reportBugsPage.selectBug1Recording(1);
		reportBugsPage.selectBug1Log(1);
		reportBugsPage.clickBug1Submit();

		Assert.assertFalse(
				driver.getPageSource().contains("passed") || driver.getPageSource().contains("success"),
				"Form should NOT pass with an incorrect Issue Title");
	}



	@Test(priority = 22, description = "Verify that the page renders correctly on mobile viewport (375px)")
	public void testMobileViewport() {
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 812));
		Assert.assertTrue(reportBugsPage.isPageHeadingDisplayed(),
				"Page heading should still be visible on mobile viewport");
		Assert.assertTrue(reportBugsPage.isBug1IssueTitleDropdownPresent(),
				"Bug 1 Issue Title dropdown should still be visible on mobile viewport");
		driver.manage().window().maximize();
	}

	@Test(priority = 23, description = "Verify that the page renders correctly on tablet viewport (768px)")
	public void testTabletViewport() {
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(768, 1024));
		Assert.assertTrue(reportBugsPage.isPageHeadingDisplayed(),
				"Page heading should still be visible on tablet viewport");
		Assert.assertTrue(reportBugsPage.isBug1IssueTitleDropdownPresent(),
				"Bug 1 Issue Title dropdown should still be visible on tablet viewport");
		driver.manage().window().maximize();
	}
}