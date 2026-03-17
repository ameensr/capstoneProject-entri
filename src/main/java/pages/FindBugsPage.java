package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindBugsPage {
	private WebDriver driver;

	// Constructor
	public FindBugsPage(WebDriver driver) {
		this.driver = driver;
	}

	// ── Locators ──────────────────────────────────────────────────────────────

	// Page subtitle
	private By pageSubtitle = By.xpath("//h6[contains(text(),'Explore a practice test site that has 25 real bugs')]");

	// Product grid
	private By allProductTiles     = By.xpath("//li[contains(@class,'product')]");
	private By productResultsLabel = By.xpath("//span[@class='ec_product_page_showing']");

	// Sort dropdown
	private By sortDropdown = By.xpath("//select[@id='sortfield']");

	// View count buttons (10 / 25 / 50)
	private By view10Button = By.xpath("//a[@class='what-we-offer-pagination-link'][normalize-space()='10']");
	private By view25Button = By.xpath("//a[@class='ec_selected']");
	private By view50Button = By.xpath("//a[normalize-space()='50']");

	// Specific products — by name
	private By dnkYellowShoes     = By.xpath("(//a[@class='ec_image_link_cover'][normalize-space()='DNK Yellow Shoes'])[2]");
	private By darkGreyJeans      = By.xpath("(//a[@class='ec_image_link_cover'][normalize-space()='Dark Grey Jeans'])[2]");
	private By flamingTshirt      = By.xpath("(//a[@class='ec_image_link_cover'][normalize-space()='Flamingo Tshirt'])[2]");
	private By buddhaBracelet     = By.xpath("(//a[@class='ec_image_link_cover'][normalize-space()='Buddha Bracelet'])[2]");

	// Add to Cart buttons
	private By addToCartButtons        = By.xpath("//a[normalize-space()='ADD TO CART']");
	private By dnkAddToCartButton      = By.xpath("(//a[contains(text(),'ADD TO CART')])[2]");
	private By darkGreyJeansCartButton = By.xpath("(//a[@id='ec_add_to_cart_4'])[1]");

	// Cart navigation
	private By viewCartLink   = By.xpath("//a[normalize-space()='View Cart']");
	private By checkOutButton = By.xpath("//a[normalize-space()='Checkout']");

	// Select Options buttons
	private By fallCoatSelectOptions  = By.xpath("(//a[normalize-space()='Select Options'])[2]");
	private By denimCoatSelectOptions = By.xpath("(//a[normalize-space()='Select Options'])[4]");

	// Pricing
	private By blueHoodieOriginalPrice = By.xpath("(//span[@class='ec_list_price_type1'][normalize-space()='$140.00'])[1]");
	private By blueHoodieSalePrice     = By.xpath("(//span[@class='ec_price_type1'][normalize-space()='$111.00'])[1]");
	private By fallCoatOriginalPrice   = By.xpath("(//span[@class='ec_list_price_type1'][normalize-space()='$189.95'])[1]");
	private By fallCoatSalePrice       = By.xpath("(//span[@class='ec_price_type1'][normalize-space()='$169.95'])[1]");
	private By darkBlueDenimLoginPrice = By.xpath("(//a[normalize-space()='Login for Pricing'])[2]");

	// Denim Coat image
	private By denimCoatImage = By.xpath("//a[contains(normalize-space(),'Denim Coat')]");

	// Modals
	private By notRealOrderModal   = By.xpath("//*[contains(text(),'Not a real order')] | //*[contains(text(),'not create a real order')]");
	private By profileSettingsHint = By.xpath("//*[contains(text(),'more bugs in the profile settings')]");

	// Billing info
	private By billInfoCountry  = By.xpath("//select[@id='ec_cart_billing_country']");
	private By billInfoFirstName = By.xpath("//input[@id='ec_cart_billing_first_name']");
	private By billInfoLastName  = By.xpath("//input[@id='ec_cart_billing_last_name']");
	private By billInfoAddress   = By.xpath("//input[@id='ec_cart_billing_address']");
	private By billInfoCity      = By.xpath("//input[@id='ec_cart_billing_city']");

	private By billInfoState   = By.xpath("//input[@id='ec_cart_billing_state'] | //select[@id='ec_cart_billing_state']");

	private By billInfoZip      = By.xpath("//input[@id='ec_cart_billing_zip']");
	private By billInfoPhone    = By.xpath("//input[@id='ec_cart_billing_phone']");
	private By billInfoEmail    = By.xpath("//input[@id='ec_contact_email']");
	private By billInfoReEmail  = By.xpath("//input[@id='ec_contact_email_retype']");

	private By continueToShipButton = By.xpath("(//input[@value='CONTINUE TO SHIPPING'])[1]");
	
	
	// Login section in Cart page
	private By emailField    = By.xpath("//input[@id='ec_account_login_widget_email']");
	private By passwordField = By.xpath("//input[@id='ec_account_login_widget_password']");
	private By signInButton  = By.xpath("//button[normalize-space()='SIGN IN']");

	// ── Actions ───────────────────────────────────────────────────────────────

	public void clickDnkYellowShoes() { 
		driver.findElement(dnkYellowShoes).click(); 
	}
	public void clickDarkGreyJeans() { 
		driver.findElement(darkGreyJeans).click();  
	}
	public void clickFlamingoTshirt() { 
		driver.findElement(flamingTshirt).click();
	}
	public void clickBuddhabracelet() { 
		driver.findElement(buddhaBracelet).click();
	}
	public void clickDnkAddToCart() { 
		driver.findElement(dnkAddToCartButton).click();  
	}
	public void clickDarkGreyJeansAddToCart() { 
		driver.findElement(darkGreyJeansCartButton).click();
	}
	public void clickFallCoatSelectOptions() { 
		driver.findElement(fallCoatSelectOptions).click(); 
	}
	public void clickDenimCoatSelectOptions() { 
		driver.findElement(denimCoatSelectOptions).click(); 
	}
	public void clickView10() { 
		driver.findElement(view10Button).click();  
	}
	public void clickView25() { 
		driver.findElement(view25Button).click();   
	}
	public void clickView50() { 
		driver.findElement(view50Button).click();  
	}

	public void selectSortOption(String visibleText) {
		new Select(driver.findElement(sortDropdown)).selectByVisibleText(visibleText);
	}

	public void addToCartThenViewCart() {
		clickDnkAddToCart();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
	}

	public void checkCheckOutFlow(String country, String firstName, String lastName,
			String address, String city, String state,
			String zip, String phone, String email) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Step 1 — Add to cart and click View Cart
		clickDnkAddToCart();
		wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();

		// Step 2 — Click Checkout
		driver.findElement(checkOutButton).click();

		// Step 3 — Select country (triggers state field to render)
		wait.until(ExpectedConditions.elementToBeClickable(billInfoCountry));
		new Select(driver.findElement(billInfoCountry)).selectByVisibleText(country);

		// Step 4 — Fill all billing fields
		wait.until(ExpectedConditions.visibilityOfElementLocated(billInfoFirstName)).sendKeys(firstName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(billInfoLastName)).sendKeys(lastName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(billInfoAddress)).sendKeys(address);
		wait.until(ExpectedConditions.visibilityOfElementLocated(billInfoCity)).sendKeys(city);


		if (!driver.findElements(billInfoState).isEmpty()) {
			WebElement stateEl = driver.findElement(billInfoState);
			if (stateEl.isDisplayed()) {
				stateEl.sendKeys(state);
			}
		} 
		wait.until(ExpectedConditions.visibilityOfElementLocated(billInfoZip)).sendKeys(zip);
		wait.until(ExpectedConditions.visibilityOfElementLocated(billInfoPhone)).sendKeys(phone);
		wait.until(ExpectedConditions.visibilityOfElementLocated(billInfoEmail)).sendKeys(email);
		wait.until(ExpectedConditions.visibilityOfElementLocated(billInfoReEmail)).sendKeys(email);

		// Step 5 — Continue to Shipping
		driver.findElement(continueToShipButton).click();
	}
	
	//Sign In from Cart page after adding item to cart
	public void loginFromCart(String email, String password) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Step 1: Add product & go to cart
	    clickDnkAddToCart();
	    wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();

	    // Step 2: Scroll down to login section
	    ((org.openqa.selenium.JavascriptExecutor) driver)
	        .executeScript("window.scrollBy(0,500)");

	    // Step 3: Enter email
	    wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);

	    // Step 4: Enter password
	    driver.findElement(passwordField).sendKeys(password);

	    // Step 5: Click Sign In
	    driver.findElement(signInButton).click();
	}
	

	// ── Getters ───────────────────────────────────────────────────────────────

	public String getPageSubtitle() { 
		return driver.findElement(pageSubtitle).getText(); 
	}
	public String getResultsLabelText() { 
		return driver.findElement(productResultsLabel).getText();      
	}
	public String getDenimCoatImageSrc() { 
		return driver.findElement(denimCoatImage).getAttribute("href"); 
	}

	public String getFirstProductName() {
		return driver.findElements(allProductTiles).get(0)
				.findElement(By.tagName("h3")).getText();
	}

	public String getBlueHoodieOriginalPrice() { 
		return driver.findElement(blueHoodieOriginalPrice).getText().trim(); 
	}
	public String getBlueHoodieSalePrice() { 
		return driver.findElement(blueHoodieSalePrice).getText().trim();  
	}
	public String getFallCoatOriginalPrice() { 
		return driver.findElement(fallCoatOriginalPrice).getText().trim(); 
	}
	public String getFallCoatSalePrice() { 
		return driver.findElement(fallCoatSalePrice).getText().trim();  
	}

	// ── Visibility / Count Checks ─────────────────────────────────────────────

	public int     getProductCount() { 
		return driver.findElements(allProductTiles).size();  
	}
	public int     getAddToCartButtonCount() { 
		return driver.findElements(addToCartButtons).size();  
	}
	public boolean isPageSubtitleDisplayed() { 
		return driver.findElement(pageSubtitle).isDisplayed();
	}

	public boolean isDarkBlueDenimLoginPriceShown() {
		return !driver.findElements(darkBlueDenimLoginPrice).isEmpty() &&
				driver.findElement(darkBlueDenimLoginPrice).isDisplayed();
	}

	public boolean isBlueHoodieSalePriceDisplayed() {
		return !driver.findElements(blueHoodieSalePrice).isEmpty() &&
				driver.findElement(blueHoodieSalePrice).isDisplayed();
	}

	public boolean isFallCoatSalePriceDisplayed() {
		return !driver.findElements(fallCoatSalePrice).isEmpty() &&
				driver.findElement(fallCoatSalePrice).isDisplayed();
	}

	public boolean isNotRealOrderModalDisplayed() {
		return !driver.findElements(notRealOrderModal).isEmpty() &&
				driver.findElement(notRealOrderModal).isDisplayed();
	}

	public boolean isProfileSettingsHintDisplayed() {
		return !driver.findElements(profileSettingsHint).isEmpty() &&
				driver.findElement(profileSettingsHint).isDisplayed();
	}

	public boolean isAddToCartSuccessMessageDisplayed() {
		return driver.getPageSource().contains("Successfully Added") ||
				driver.getPageSource().contains("successfully added");
	}
	
	public boolean isUserLoggedIn() {
	    return driver.getPageSource().toLowerCase().contains("logout")
	        || driver.getPageSource().toLowerCase().contains("my account");
	}
	
	public boolean isStillOnLoginSection() {
	    return driver.findElement(emailField).isDisplayed();
	}
	
	public boolean isLoginAttemptHandled() {

	    return driver.getCurrentUrl().contains("cart") 
	        || driver.getPageSource().toLowerCase().contains("error")
	        || driver.getPageSource().toLowerCase().contains("invalid")
	        || driver.getPageSource().toLowerCase().contains("login");
	}
	
}