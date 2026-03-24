package pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportBugsPage {

	private WebDriver driver;

	// Constructor
	public ReportBugsPage(WebDriver driver) {
		this.driver = driver;
	}


	private By pageHeading   = By.xpath("//h3[normalize-space()='Report Bugs']");
	private By pageSubtitle  = By.xpath("//p[@class='academy-bug-report-subtitle']");
	private By importantNote = By.xpath("//div[@class='academy-bug-report-note']");
	private By progressTracker = By.xpath("//div[@class='form-group no-hover']");
	private By progressSlot1   = By.xpath("//a[@id='first-tab']");
	private By progressSlot2   = By.xpath("//a[@id='second-tab']");
	private By lockedSlotMsg   = By.xpath("//*[contains(text(),'pass the current bug report')]");

	private By bug1IssueTitle    = By.xpath("//select[@name='bug-title-1']");
	private By bug1IssueType     = By.xpath("//select[@name='bug-type-1']");


	private By bug1FreqEveryTime    = By.xpath("//input[@name='frequency-1' and @value='Every Time']");
	private By bug1FreqHardlyEver   = By.xpath("//input[@name='frequency-1' and @value='Hardly Ever']");
	private By bug1FreqOccasionally = By.xpath("//input[@name='frequency-1' and @value='Occasionally']");
	private By bug1FreqOnce         = By.xpath("//input[@name='frequency-1' and @value='Once']");


	private By bug1PrioLow      = By.xpath("//input[@name='priority-1' and @value='Low']");
	private By bug1PrioMedium   = By.xpath("//input[@name='priority-1' and @value='Medium']");
	private By bug1PrioHigh     = By.xpath("//input[@name='priority-1' and @value='High']");
	private By bug1PrioCritical = By.xpath("//input[@name='priority-1' and @value='Critical']");



	private By bug1TabPanel = By.xpath("//div[@id='steps-form-group-1']");


	private By bug1ActionSource = By.xpath("//ul[@id='bug-1-sortable-2']/li");

	private By bug1ActionTarget = By.id("bug-1-sortable-1");



	private By bug1ExpectedResult = By.xpath("//select[@name='expected-result-1']");
	private By bug1ActualResult   = By.xpath("//select[@name='actual-result-1']");
	private By bug1ErrorMessage   = By.xpath("//select[@name='error-message-1']");


	private By bug1Screenshot1 = By.id("reportBugImage1");
	private By bug1Screenshot2 = By.id("reportBugImage2");
	private By bug1Screenshot3 = By.id("reportBugImage3");

	private By bug1Recording1  = By.id("reportBugVideo1");
	private By bug1Recording2  = By.id("reportBugVideo2");
	private By bug1Recording3  = By.id("reportBugVideo3");

	private By bug1Log1        = By.id("reportBugLog1");
	private By bug1Log2        = By.id("reportBugLog2");
	private By bug1Log3        = By.id("reportBugLog3");


	private By bug1Submit = By.xpath("//button[@id='submit-bug-report-1']//span[@class='submit-issue-button-span'][contains(text(),'Submit')]");


	private By footerTerms         = By.xpath("//a[normalize-space()='Terms & Conditions']");
	private By footerPrivacyPolicy = By.xpath("//a[normalize-space()='Privacy Policy']");
	private By footerAboutUs       = By.xpath("//a[normalize-space()='About Us']");

	//Actions 

	public void clickProgressSlot1() { driver.findElement(progressSlot1).click(); }
	public void clickProgressSlot2() { driver.findElement(progressSlot2).click(); }


	public void selectBug1IssueTitle(String visibleText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(bug1IssueTitle));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
		new Select(el).selectByVisibleText(visibleText);
	}


	public void selectBug1IssueType(String visibleText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(bug1IssueType));
		new Select(el).selectByVisibleText(visibleText);
	}


	public void selectBug1Frequency(String option) {
		By locator;
		switch (option) {
		case "Hardly Ever":   locator = bug1FreqHardlyEver;   break;
		case "Occasionally":  locator = bug1FreqOccasionally; break;
		case "Once":          locator = bug1FreqOnce;         break;
		default:              locator = bug1FreqEveryTime;    break;
		}
		clickRadioInput(locator);
	}


	public void selectBug1Priority(String option) {
		By locator;
		switch (option) {
		case "Low":      locator = bug1PrioLow;      break;
		case "Medium":   locator = bug1PrioMedium;   break;
		case "Critical": locator = bug1PrioCritical; break;
		default:         locator = bug1PrioHigh;     break;
		}
		clickRadioInput(locator);
	}


	private void clickRadioInput(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement el = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
	}



	public void scrollToActionPerformed() {
		WebElement panel = driver.findElement(bug1TabPanel);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", panel);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200)");
	}


	public void dragActionStep(int sourceIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(bug1ActionSource));

		List<WebElement> sourceItems = driver.findElements(bug1ActionSource);
		WebElement targetList = driver.findElement(bug1ActionTarget);

		System.out.println("[DragDrop] sourceItems.size()=" + sourceItems.size()
		+ "  dragging index " + sourceIndex + " → target ul#bug-1-sortable-1");

		if (sourceIndex >= sourceItems.size()) {
			System.out.println("[DragDrop] SKIPPED — sourceIndex " + sourceIndex
					+ " >= sourceItems.size() " + sourceItems.size());
			return;
		}

		WebElement source = sourceItems.get(sourceIndex);

		// Scroll source item into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);


		try {
			((JavascriptExecutor) driver).executeScript(
					"var dt = new DataTransfer();" +
							"arguments[0].dispatchEvent(new DragEvent('dragstart', {bubbles:true, cancelable:true, dataTransfer:dt}));" +
							"arguments[1].dispatchEvent(new DragEvent('dragenter', {bubbles:true, cancelable:true, dataTransfer:dt}));" +
							"arguments[1].dispatchEvent(new DragEvent('dragover',  {bubbles:true, cancelable:true, dataTransfer:dt}));" +
							"arguments[1].dispatchEvent(new DragEvent('drop',      {bubbles:true, cancelable:true, dataTransfer:dt}));" +
							"arguments[0].dispatchEvent(new DragEvent('dragend',   {bubbles:true, cancelable:true, dataTransfer:dt}));",
							source, targetList
					);
		} catch (Exception e) {
			new Actions(driver)
			.clickAndHold(source)
			.pause(Duration.ofMillis(600))
			.moveToElement(targetList)
			.pause(Duration.ofMillis(600))
			.release(targetList)
			.perform();
		}

		try { Thread.sleep(300); } catch (InterruptedException ignored) {}
	}


	public void performBug1ActionSteps() {
		scrollToActionPerformed();

		dragActionStep(0);
		dragActionStep(0);
		dragActionStep(0);
		dragActionStep(0);
		dragActionStep(0);
	}


	public void selectBug1ExpectedResult(String visibleText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(bug1ExpectedResult));
		new Select(el).selectByVisibleText(visibleText);
	}

	public void selectBug1ActualResult(String visibleText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(bug1ActualResult));
		new Select(el).selectByVisibleText(visibleText);
	}

	public void selectBug1ErrorMessage(String visibleText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(bug1ErrorMessage));
		new Select(el).selectByVisibleText(visibleText);
	}


	public void selectBug1Screenshot(int option) {
		By locator = option == 1 ? bug1Screenshot1 : option == 2 ? bug1Screenshot2 : bug1Screenshot3;
		clickRadioInput(locator);
	}

	public void selectBug1Recording(int option) {
		By locator = option == 1 ? bug1Recording1 : option == 2 ? bug1Recording2 : bug1Recording3;
		clickRadioInput(locator);
	}

	public void selectBug1Log(int option) {
		By locator = option == 1 ? bug1Log1 : option == 2 ? bug1Log2 : bug1Log3;
		clickRadioInput(locator);
	}




	public void performDragAndDrop() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);

		for (int i = 0; i < 5; i++) {

			List<WebElement> items = wait.until(
					ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//ul[@id='bug-1-sortable-2']/li")
							)
					);

			WebElement source = items.get(0);
			WebElement target = driver.findElement(By.id("bug-1-sortable-1"));

			// Scroll
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView({block:'center'});", source
					);

			// REAL DRAG (VISIBLE)
			actions
			.moveToElement(source)
			.pause(Duration.ofMillis(500))
			.clickAndHold(source)
			.pause(Duration.ofMillis(500))
			.moveToElement(target)
			.pause(Duration.ofMillis(500))
			.release()
			.build()
			.perform();

			try { Thread.sleep(800); } catch (Exception e) {}
		}
	}







	public void clickBug1Submit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(bug1Submit));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
		btn.click();
	}


	public void clickFooterTerms()         { driver.findElement(footerTerms).click();         }
	public void clickFooterPrivacyPolicy() { driver.findElement(footerPrivacyPolicy).click(); }


	public String getPageHeadingText()   { return driver.findElement(pageHeading).getText();   }
	public String getPageSubtitleText()  { return driver.findElement(pageSubtitle).getText();  }
	public String getImportantNoteText() { return driver.findElement(importantNote).getText(); }

	public int getProgressSlotCount() {
		By allSlots = By.xpath(
				"//a[@href='#first'] | //a[@href='#second'] | //a[@href='#third'] | " +
						"//a[@href='#fourth'] | //a[@href='#fifth']"
				);
		return driver.findElements(allSlots).size();
	}

	public List<String> getBug1DropdownOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(bug1IssueTitle));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
		return new Select(el).getOptions()
				.stream()
				.map(e -> e.getText().trim())
				.collect(Collectors.toList());
	}

	public boolean bug1IssueTypeContainsOption(String optionText) {
		return new Select(driver.findElement(bug1IssueType)).getOptions()
				.stream().anyMatch(o -> o.getText().trim().equals(optionText));
	}

	public boolean bug1ExpectedResultContainsOption(String optionText) {
		return new Select(driver.findElement(bug1ExpectedResult)).getOptions()
				.stream().anyMatch(o -> o.getText().trim().equals(optionText));
	}

	public boolean bug1ActualResultContainsOption(String optionText) {
		return new Select(driver.findElement(bug1ActualResult)).getOptions()
				.stream().anyMatch(o -> o.getText().trim().equals(optionText));
	}

	public boolean bug1ErrorMessageContainsOption(String optionText) {
		return new Select(driver.findElement(bug1ErrorMessage)).getOptions()
				.stream().anyMatch(o -> o.getText().trim().equals(optionText));
	}

	public int getBug1IssueTypeOptionCount() {
		return new Select(driver.findElement(bug1IssueType)).getOptions().size() - 1;
	}


	public boolean isPageHeadingDisplayed()     { return driver.findElement(pageHeading).isDisplayed();     }
	public boolean isPageSubtitleDisplayed()    { return driver.findElement(pageSubtitle).isDisplayed();    }
	public boolean isImportantNoteDisplayed()   { return driver.findElement(importantNote).isDisplayed();   }
	public boolean isProgressTrackerDisplayed() { return driver.findElement(progressTracker).isDisplayed(); }
	public boolean isFooterAboutUsDisplayed() {

		WebElement el = driver.findElement(footerAboutUs);

		((JavascriptExecutor) driver)
		.executeScript("arguments[0].scrollIntoView(true);", el);

		return el.isDisplayed();
	}
	public boolean isFooterTermsDisplayed()     { return driver.findElement(footerTerms).isDisplayed();     }
	public boolean isFooterPrivacyDisplayed()   { return driver.findElement(footerPrivacyPolicy).isDisplayed(); }

	public boolean isBug1IssueTitleDropdownPresent() {
		return !driver.findElements(bug1IssueTitle).isEmpty()
				&& driver.findElement(bug1IssueTitle).isDisplayed();
	}

	public boolean isBug1IssueTypeDropdownPresent() {
		return !driver.findElements(bug1IssueType).isEmpty()
				&& driver.findElement(bug1IssueType).isDisplayed();
	}

	public boolean isBug1SubmitButtonDisplayed() {
		return !driver.findElements(bug1Submit).isEmpty()
				&& driver.findElement(bug1Submit).isDisplayed();
	}

	public boolean isLockedSlotMessageDisplayed() {
		return !driver.findElements(lockedSlotMsg).isEmpty()
				&& driver.findElement(lockedSlotMsg).isDisplayed();
	}

	public boolean isValidationMessageDisplayed() {
		return driver.getPageSource().contains("Please select an item in the list");
	}

	public boolean isBug2Unlocked() {
		return !driver.findElements(progressSlot2).isEmpty()
				&& driver.findElement(progressSlot2).isEnabled();
	}
}