package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {

	private WebDriver driver;

	// Constructor
	public HeaderPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	// Academy Bugs logo
	private By academyBugsLink = By.xpath("//a[normalize-space()='AcademyBugs.com']");

	// Examples of Bugs menu
	private By examplesOfBugsLink = By.xpath("//a[normalize-space()='Examples of Bugs']");

	// Types of Bugs menu
	private By typesOfBugsLink = By.xpath("//a[normalize-space()='Types of Bugs']");

	// Find Bugs menu
	private By findBugsLink = By.xpath("//a[normalize-space()='Find Bugs']");

	// Report Bugs menu
	private By reportBugsLink = By.xpath("//a[normalize-space()='Report Bugs']");

	// Help icon (question mark)
	private By helpIcon = By.xpath("//i[@class='fas fa-question-circle tour-question-mark']");

	// Close tutorial button
	private By closeTutorialButton = By.xpath("//div[@id='TourTip0']//button[@type='button'][normalize-space()='×']");

	// Tutorial popup title
	private By tutorialPopupTitle = By.xpath("//p[normalize-space()='Tutorial']");


	// Actions (Methods)

	public void closeTutorial() {
		driver.findElement(closeTutorialButton).click();
	}

	public void clickAcademyBugsLink() {
		driver.findElement(academyBugsLink).click();
	}

	public void clickExamplesOfBugsLink() {
		driver.findElement(examplesOfBugsLink).click();
	}

	public void clickTypesOfBugsLink() {
		driver.findElement(typesOfBugsLink).click();
	}

	public void clickFindBugsLink() {
		driver.findElement(findBugsLink).click();
	}

	public void clickReportBugsLink() {
		driver.findElement(reportBugsLink).click();
	}

	public void clickHelpIcon() {
		driver.findElement(helpIcon).click();
	}

	public boolean isHelpIconVisible() {
		return driver.findElement(helpIcon).isDisplayed();
	}

	public boolean isTutorialPopupDisplayed() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(tutorialPopupTitle).isDisplayed();
	}

	public String getTutorialPopupText() {
	    return driver.findElement(tutorialPopupTitle).getText();
	
	}
}