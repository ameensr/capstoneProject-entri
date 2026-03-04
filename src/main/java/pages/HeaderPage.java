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
	private By academyBugsLink  = By.cssSelector("#sq-site-branding");
	private By examplesOfBugsLink = By.id("menu-item-5906");
	private By typesOfBugsLink = By.id("menu-item-1024");
	private By findBugsLink = By.id("menu-item-561");
	private By reportBugsLink = By.id("menu-item-5687");
	private By helpIcon = By.className("tour-question-mark");
	private By closeTutorialButton = By.cssSelector("div[id='TourTip0'] button[type='button']");
	private By tutorialPopupTitle = By.cssSelector("p.TourTipTitle");
	

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

    public boolean isTutorialPopupDisplayed() {
        return driver.findElement(tutorialPopupTitle).isDisplayed();
    }
    
    public String getTutorialPopupText() {
        return driver.findElement(tutorialPopupTitle).getText();
    }
}