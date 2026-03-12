package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TypesOfBugsPage {private WebDriver driver;

// Constructor
public TypesOfBugsPage(WebDriver driver) {
	this.driver = driver;
}

// ── Locators ─────────────────────────────────────────────────────────────

// Page heading / subtitle
private By pageSubtitle = By.xpath("//h6[contains(text(),'Learn the different types of bugs that commonly oc')]");

// Bug type cards (clickable tiles)
private By functionalCard  = By.xpath("(//div[@class='types-of-bugs-tile-div-text'])[1]");
private By visualCard      = By.xpath("(//div[@class='types-of-bugs-tile-div-text'])[2]");
private By contentCard     = By.xpath("(//div[@class='types-of-bugs-tile-div-text'])[3]");
private By performanceCard = By.xpath("(//div[@class='types-of-bugs-tile-div-text'])[4]");
private By crashCard       = By.xpath("(//div[@class='types-of-bugs-tile-div-text'])[5]");

// Card title text
private By functionalCardTitle  = By.xpath("//h5[normalize-space()='Functional']");
private By functionalCardTitlePopupDes  = By.xpath("//p[@class='popup-subtitle types-of-bugs-popup-subtitle']");
private By visualCardTitle      = By.xpath("//h5[normalize-space()='Visual']");
private By contentCardTitle     = By.xpath("//h5[normalize-space()='Content']");
private By performanceCardTitle = By.xpath("//h5[normalize-space()='Performance']");
private By crashCardTitle       = By.xpath("//a[@class='types-of-bugs-tile-div']//h5[@class='types-of-bugs-tile-heading'][normalize-space()='Crash']");

// Card description paragraphs
private By functionalCardDesc  = By.xpath("//p[contains(text(),'Workflow failures producing an unexpected or illog')]");
private By visualCardDesc      = By.xpath("(//p[contains(text(),'Visual issues affect the layout and cause user int')])[1]");
private By contentCardDesc     = By.xpath("//p[contains(text(),'Content issues affect the text of a page, such as ')]");
private By performanceCardDesc = By.xpath("//p[contains(text(),'Problematic slowness or hanging, sluggish interfac')]");
private By crashCardDesc       = By.xpath("//a[@class='types-of-bugs-tile-div']//p[@class='types-of-bugs-tile-subtext'][contains(text(),'Application quits or closes unexpectedly while usi')]");

// Expanded / active card detail (shown after click)
//private By expandedCardDesc = By.xpath("//div[contains(@class,'types-detail')]//p");

// Bug counter widget
//private By bugCounterText  = By.xpath("//*[contains(text(),'You found') and contains(text(),'bugs out of 25')]");
//private By bugNumberSlots  = By.xpath("//div[contains(@class,'sq-found')]//a | //ul[contains(@class,'bug-tracker')]//li//a");

// Footer elements
private By footerUTestLogo       = By.xpath("//img[@alt='uTest']");
//private By footerAboutUs         = By.xpath("//h5[normalize-space()='About Us'] | //a[normalize-space()='About Us']");
private By footerTerms           = By.xpath("//a[normalize-space()='Terms & Conditions']");
private By footerPrivacyPolicy   = By.xpath("//a[normalize-space()='Privacy Policy']");

// ── Actions ───────────────────────────────────────────────────────────────

public void clickFunctionalCard() {
	driver.findElement(functionalCard).click();
}

public void clickVisualCard() {
	driver.findElement(visualCard).click();
}

public void clickContentCard() {
	driver.findElement(contentCard).click();
}

public void clickPerformanceCard() {
	driver.findElement(performanceCard).click();
}

public void clickCrashCard() {
	driver.findElement(crashCard).click();
}

public void clickFooterTerms() {
	driver.findElement(footerTerms).click();
}

public void clickFooterPrivacyPolicy() {
	driver.findElement(footerPrivacyPolicy).click();
}

// ── Getters ───────────────────────────────────────────────────────────────

public String getPageSubtitle() {
	return driver.findElement(pageSubtitle).getText();
}

public String getFunctionalCardTitle() {
	return driver.findElement(functionalCardTitle).getText();
}

public String getVisualCardTitle() {
	return driver.findElement(visualCardTitle).getText();
}

public String getContentCardTitle() {
	return driver.findElement(contentCardTitle).getText();
}

public String getPerformanceCardTitle() {
	return driver.findElement(performanceCardTitle).getText();
}

public String getCrashCardTitle() {
	return driver.findElement(crashCardTitle).getText();
}

public String getFunctionalCardDesc() {
	return driver.findElement(functionalCardDesc).getText();
}

public String getVisualCardDesc() {
	return driver.findElement(visualCardDesc).getText();
}

public String getContentCardDesc() {
	return driver.findElement(contentCardDesc).getText();
}

public String getPerformanceCardDesc() {
	return driver.findElement(performanceCardDesc).getText();
}

public String getCrashCardDesc() {
	return driver.findElement(crashCardDesc).getText();
}

public String getFunctionalCardPopupDesc() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(functionalCardTitlePopupDes)).getText().trim();
}

//public String getBugCounterText() {
//	return driver.findElement(bugCounterText).getText();
//}

//public String getExpandedCardDescription() {
//	return driver.findElement(expandedCardDesc).getText();
//}

// ── Visibility checks ─────────────────────────────────────────────────────

public boolean isPageSubtitleDisplayed() {
	return driver.findElement(pageSubtitle).isDisplayed();
}

public boolean isFunctionalCardDisplayed() {
	return driver.findElement(functionalCardTitle).isDisplayed();
}

public boolean isVisualCardDisplayed() {
	return driver.findElement(visualCardTitle).isDisplayed();
}

public boolean isContentCardDisplayed() {
	return driver.findElement(contentCardTitle).isDisplayed();
}

public boolean isPerformanceCardDisplayed() {
	return driver.findElement(performanceCardTitle).isDisplayed();
}

public boolean isCrashCardDisplayed() {
	return driver.findElement(crashCardTitle).isDisplayed();
}

//public boolean isBugCounterDisplayed() {
//	return driver.findElement(bugCounterText).isDisplayed();
//}
//
//public boolean isFooterAboutUsDisplayed() {
//	return driver.findElement(footerAboutUs).isDisplayed();
//}

public boolean isFooterTermsDisplayed() {
	return driver.findElement(footerTerms).isDisplayed();
}

public boolean isFooterPrivacyPolicyDisplayed() {
	return driver.findElement(footerPrivacyPolicy).isDisplayed();
}

//public int getBugNumberSlotCount() {
//	return driver.findElements(bugNumberSlots).size();
//}

public int getTotalCardCount() {
	int count = 0;
	By[] cards = { functionalCardTitle, visualCardTitle, contentCardTitle,
			performanceCardTitle, crashCardTitle };
	for (By card : cards) {
		if (!driver.findElements(card).isEmpty()) count++;
	}
	return count;
}
}