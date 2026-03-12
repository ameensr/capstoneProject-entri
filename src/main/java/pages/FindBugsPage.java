package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindBugsPage {
	private WebDriver driver;
	 
    // Constructor
    public FindBugsPage(WebDriver driver) {
        this.driver = driver;
    }
 
    // ── Locators ─────────────────────────────────────────────────────────────
 
    // Page subtitle
    private By pageSubtitle = By.xpath("//h6[contains(text(),'Explore a practice test site that has 25 real bugs')]");
 
    // Product grid
    private By allProductTiles     = By.xpath("//section[@id='ec_product_page']");
    private By productResultsLabel = By.xpath("//span[@class='ec_product_page_showing']");
 
    // Sort dropdown
    private By sortDropdown = By.xpath("//select[contains(@class,'orderby')] | //select[@name='orderby']");
 
    // View count buttons (10 / 25 / 50)
    private By view10Button = By.xpath("//a[@class='what-we-offer-pagination-link'][normalize-space()='10']");
    private By view25Button = By.xpath("//a[@class='ec_selected']");
    private By view50Button = By.xpath("//a[normalize-space()='50']");
 
    // Specific products — by name
    private By dnkYellowShoes        = By.xpath("(//a[@class='ec_image_link_cover'][normalize-space()='DNK Yellow Shoes'])[2]");
    private By darkGreyJeans         = By.xpath("(//a[@class='ec_image_link_cover'][normalize-space()='Dark Grey Jeans'])[2]");
    
    
    /////////////////////////////////////////////////////////////////////////////////////
    
    private By flamingTshirt         = By.xpath("//a[contains(normalize-space(),'Flamingo Tshirt')]");
    private By blueHoodie            = By.xpath("//a[contains(normalize-space(),'Blue Hoodie')]");
    private By fallCoat              = By.xpath("//a[contains(normalize-space(),'Fall Coat')]");
    private By denimCoat             = By.xpath("//a[contains(normalize-space(),'Denim Coat')]");
    private By darkBlueDenimJeans    = By.xpath("//a[contains(normalize-space(),'Dark Blue Denim Jeans')]");
    private By buddhaBracelet        = By.xpath("//a[contains(normalize-space(),'Buddha Bracelet')]");
 
    // Add to Cart buttons (generic + specific)
    private By addToCartButtons         = By.xpath("//a[contains(@class,'add_to_cart_button')] | //a[normalize-space()='ADD TO CART']");
    private By dnkAddToCartButton       = By.xpath("//a[contains(@href,'model_number=4481370')]");
    private By darkGreyJeansCartButton  = By.xpath("//a[contains(@href,'model_number=4281370')]");
 
    // Checkout Now buttons
    private By checkoutNowButtons = By.xpath("//a[normalize-space()='CHECKOUT NOW']");
 
    // Select Options buttons (for variable products)
    private By fallCoatSelectOptions  = By.xpath("//a[contains(normalize-space(),'Fall Coat')]/ancestor::li//a[normalize-space()='Select Options'] | //a[@href[contains(.,'fall-coat')]]/following::a[normalize-space()='Select Options'][1]");
    private By denimCoatSelectOptions = By.xpath("//a[contains(normalize-space(),'Denim Coat')]/ancestor::li//a[normalize-space()='Select Options'] | //a[@href[contains(.,'denim-coat')]]/following::a[normalize-space()='Select Options'][1]");
 
    // Pricing
    private By blueHoodieOriginalPrice = By.xpath("//a[contains(normalize-space(),'Blue Hoodie')]/ancestor::li//del//span[@class='woocommerce-Price-amount amount'] | //a[contains(normalize-space(),'Blue Hoodie')]/ancestor::li//del");
    private By blueHoodieSalePrice     = By.xpath("//a[contains(normalize-space(),'Blue Hoodie')]/ancestor::li//ins//span[@class='woocommerce-Price-amount amount'] | //a[contains(normalize-space(),'Blue Hoodie')]/ancestor::li//ins");
    private By fallCoatOriginalPrice   = By.xpath("//a[contains(normalize-space(),'Fall Coat')]/ancestor::li//del");
    private By fallCoatSalePrice       = By.xpath("//a[contains(normalize-space(),'Fall Coat')]/ancestor::li//ins");
    private By darkBlueDenimLoginPrice = By.xpath("//a[contains(normalize-space(),'Dark Blue Denim Jeans')]/ancestor::li//a[contains(text(),'Login')]");
 
    // Bug counter widget
    private By bugCounterText  = By.xpath("//*[contains(text(),'You found') and contains(text(),'bugs out of 25')]");
    private By bugNumberSlots  = By.xpath("//div[contains(@class,'sq-found')]//a");
 
    // Disclaimer modal
    private By notRealOrderModal      = By.xpath("//*[contains(text(),'Not a real order')] | //*[contains(text(),'not create a real order')]");
    private By profileSettingsHint    = By.xpath("//*[contains(text(),'more bugs in the profile settings')]");
 
    // Product image for Denim Coat
    private By denimCoatImage = By.xpath("//a[contains(normalize-space(),'Denim Coat')]/ancestor::li//img");
 
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
 
    public void clickFirstCheckoutNow() {
        driver.findElements(checkoutNowButtons).get(0).click();
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
        new org.openqa.selenium.support.ui.Select(driver.findElement(sortDropdown))
            .selectByVisibleText(visibleText);
    }
 
    // ── Getters ───────────────────────────────────────────────────────────────
 
    public String getPageSubtitle() {
        return driver.findElement(pageSubtitle).getText();
    }
 
    public String getResultsLabelText() {
        return driver.findElement(productResultsLabel).getText();
    }
 
    public String getBugCounterText() {
        return driver.findElement(bugCounterText).getText();
    }
 
    public String getFirstProductName() {
        return driver.findElements(allProductTiles).get(0)
                     .findElement(By.tagName("h3")).getText();
    }
 
    public String getDenimCoatImageSrc() {
        return driver.findElement(denimCoatImage).getAttribute("src");
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
 
    // ── Visibility / Count checks ─────────────────────────────────────────────
 
    public int getProductCount() {
        return driver.findElements(allProductTiles).size();
    }
 
    public int getAddToCartButtonCount() {
        return driver.findElements(addToCartButtons).size();
    }
 
    public int getBugNumberSlotCount() {
        return driver.findElements(bugNumberSlots).size();
    }
 
    public boolean isPageSubtitleDisplayed() {
        return driver.findElement(pageSubtitle).isDisplayed();
    }
 
    public boolean isBugCounterDisplayed() {
        return driver.findElement(bugCounterText).isDisplayed();
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
}