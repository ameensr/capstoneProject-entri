package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExampleOfBugsPage {

	private WebDriver driver;

	// Constructor
	public ExampleOfBugsPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By socialShareTile = By.xpath("(//div[@class='example-tile-div-text'])[1]");
	private By sendButtonTile = By.xpath("(//div[@class='example-tile-div-text'])[2]");
	private By videoPlayerTile = By.xpath("(//div[@class='example-tile-div-text'])[3]");
	private By articlesErrorTile = By.xpath("(//div[@class='example-tile-div-text'])[4]");
	private By searchErrorTile = By.xpath("(//div[@class='example-tile-div-text'])[5]");
	private By bookingTile = By.xpath("(//div[@class='example-tile-div-text'])[6]");
	private By popupTileClose = By.xpath("//div[@id='popmake-4434']//button[@aria-label='Close'][normalize-space()='×']");

	// Actions
	public void clickSocialShareTile() {
		driver.findElement(socialShareTile).click();
	}

	public void clickSendButtonTile() {
		driver.findElement(sendButtonTile).click();
	}

	public void clickVideoPlayerTile() {
		driver.findElement(videoPlayerTile).click();
	}

	public void clickArticlesErrorTile() {
		driver.findElement(articlesErrorTile).click();
	}

	public void clickSearchErrorTile() {
		driver.findElement(searchErrorTile).click();
	}

	public void clickBookingTile() {
		driver.findElement(bookingTile).click();
	}

	public void clickpPopupTileClose() {
		driver.findElement(popupTileClose).click();
	}


}