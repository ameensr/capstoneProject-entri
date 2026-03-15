package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {

	private WebDriver driver;

	// Constructor
	public HeaderPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By academyBugsLink = By.xpath("//a[normalize-space()='AcademyBugs.com']");
	private By examplesOfBugsLink = By.xpath("//a[normalize-space()='Examples of Bugs']");
	private By typesOfBugsLink = By.xpath("//a[normalize-space()='Types of Bugs']");
	private By findBugsLink = By.xpath("//a[normalize-space()='Find Bugs']");
	private By reportBugsLink = By.xpath("//a[normalize-space()='Report Bugs']");
	
	private By helpIcon = By.xpath("//i[contains(@class,'tour-question-mark')]");
	private By closeTutorialButton = By.xpath("//div[@id='TourTip0']//button[@type='button'][normalize-space()='×']");
	private By tutorialPopupTitle = By.xpath("//div[@id='TourTip0']//div[@class='TourTipContent']");
	

	// Actions (Methods)
	public void closeTutorial() {
		driver.findElement(closeTutorialButton).click();
	}
	
	public void closeTutorialIfPresent() {

	    if(driver.findElements(closeTutorialButton).size() > 0) {
	        driver.findElement(closeTutorialButton).click();
	    }
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

	public boolean isTutorialPopupDisplayed() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	    return wait.until(
	        ExpectedConditions.visibilityOfElementLocated(tutorialPopupTitle)
	    ).isDisplayed();
	}
	
//	 public boolean isTutorialPopupDisplayed() {
//	        return driver.findElement(tutorialPopupTitle).isDisplayed();
//	    }


	public String getTutorialPopupText() {
	    return driver.findElement(tutorialPopupTitle).getText();
	
	}
}