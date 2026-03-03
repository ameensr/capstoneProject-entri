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
	private By siteTitle = By.cssSelector("h3.sq-site-title a");
	private By examplesOfBugsLink = By.id("menu-item-5906");
	private By typesOfBugsLink = By.id("menu-item-1024");
	private By findBugsLink = By.id("menu-item-561");
	private By reportBugsLink = By.id("menu-item-5687");
	private By closeTutorialButton = By.cssSelector("div[id='TourTip0'] button[type='button']");

	// Actions (Methods)

	public void closeTutorial() {
		driver.findElement(closeTutorialButton).click();
	}

	public void clickSiteTitle() {
		driver.findElement(siteTitle).click();
	}

	public void clickExamplesOfBugs() {
		driver.findElement(examplesOfBugsLink).click();
	}

	public void clickTypesOfBugs() {
		driver.findElement(typesOfBugsLink).click();
	}

	public void clickFindBugs() {
		driver.findElement(findBugsLink).click();
	}

	public void clickReportBugs() {
		driver.findElement(reportBugsLink).click();
	}

}