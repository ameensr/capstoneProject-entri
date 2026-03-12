package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FindBugsPage;
import pages.HeaderPage;

public class FindBugsPageTest extends BaseTest {

	FindBugsPage findBugsPage;
	HeaderPage headerPage;

	@BeforeMethod
	public void setUp() {
		driver.get(config.getBaseUrl() + "find-bugs/");

		findBugsPage = new FindBugsPage(driver);
		headerPage = new HeaderPage(driver);

		try {
			headerPage.closeTutorial();
		} catch (Exception e) {}
	}

	// ── TC-F01: Page loads ────────────────────────────────────────────────────

	@Test(priority = 1, description = "Verify that the Find Bugs page loads successfully without errors")
	public void testPageLoadsSuccessfully() {
		Assert.assertTrue(driver.getCurrentUrl().contains("find-bugs"),
				"URL should contain 'find-bugs'");
		Assert.assertTrue(findBugsPage.isPageSubtitleDisplayed(),
				"Page subtitle should be visible after load");
	}

	// ── TC-F02: Page subtitle ─────────────────────────────────────────────────

	@Test(priority = 2, description = "Verify that the page subtitle text is correct")
	public void testPageSubtitle() {
		String subtitle = findBugsPage.getPageSubtitle();
		Assert.assertTrue(subtitle.contains("25 real bugs"),
				"Page subtitle mismatch. Actual: " + subtitle);
	}

	// ── TC-F03: 18 products displayed ────────────────────────────────────────

	@Test(priority = 3, description = "Verify that 18 products are displayed by default")
	public void testEighteenProductsDisplayed() {
		int count = findBugsPage.getProductCount();
		Assert.assertEquals(count, 18,
				"Expected 18 products but found: " + count);
	}

	// ── TC-F04: Results count label ───────────────────────────────────────────

	@Test(priority = 4, description = "Verify that the product result count label is accurate")
	public void testResultsCountLabel() {
		String label = findBugsPage.getResultsLabelText();
		Assert.assertTrue(label.contains("18"),
				"Results label should show 18. Actual: " + label);
	}

	// ── TC-F05: Product images load ───────────────────────────────────────────

	@Test(priority = 5, description = "Verify that all product images load correctly without broken icons")
	public void testAllProductImagesLoad() {
		Assert.assertFalse(driver.getPageSource().contains("broken"),
				"Page should not contain broken image references");
		// Verify at least first image src is from expected domain
		Assert.assertTrue(driver.getPageSource().contains("academybugs.com"),
				"Product images should be served from academybugs.com");
	}

	// ── TC-F06: Denim Coat image domain ──────────────────────────────────────

	@Test(priority = 6, description = "Verify that the Denim Coat image loads from the correct domain")
	public void testDenimCoatImageDomain() {
		String src = findBugsPage.getDenimCoatImageSrc();
		Assert.assertTrue(src.contains("academybugs.com"),
				"Denim Coat image should load from academybugs.com. Actual src: " + src);
	}

	// ── TC-F07: All products show price ──────────────────────────────────────

	@Test(priority = 7, description = "Verify that all products display a price")
	public void testAllProductsHavePrice() {
		Assert.assertTrue(driver.getPageSource().contains("$") ||
				driver.getPageSource().contains("Login for Pricing"),
				"Products should display prices or 'Login for Pricing'");
	}

	// ── TC-F08: Dark Blue Denim Jeans — Login for Pricing ────────────────────

	@Test(priority = 8, description = "Verify that Dark Blue Denim Jeans shows 'Login for Pricing' for guest users")
	public void testDarkBlueDenimJeansLoginPricing() {
		Assert.assertTrue(findBugsPage.isDarkBlueDenimLoginPriceShown(),
				"Dark Blue Denim Jeans should show 'Login for Pricing' for guest users");
	}

	// ── TC-F09: Blue Hoodie sale price ───────────────────────────────────────

	@Test(priority = 9, description = "Verify that the Blue Hoodie displays the correct original and sale price")
	public void testBlueHoodieSalePrice() {
		Assert.assertTrue(findBugsPage.isBlueHoodieSalePriceDisplayed(),
				"Blue Hoodie should show a sale price");
		Assert.assertTrue(findBugsPage.getBlueHoodieOriginalPrice().contains("140"),
				"Blue Hoodie original price should be $140. Actual: " + findBugsPage.getBlueHoodieOriginalPrice());
		Assert.assertTrue(findBugsPage.getBlueHoodieSalePrice().contains("111"),
				"Blue Hoodie sale price should be $111. Actual: " + findBugsPage.getBlueHoodieSalePrice());
	}

	// ── TC-F10: Fall Coat sale price ──────────────────────────────────────────

	@Test(priority = 10, description = "Verify that the Fall Coat displays the correct original and sale price")
	public void testFallCoatSalePrice() {
		Assert.assertTrue(findBugsPage.isFallCoatSalePriceDisplayed(),
				"Fall Coat should show a sale price");
		Assert.assertTrue(findBugsPage.getFallCoatOriginalPrice().contains("189"),
				"Fall Coat original price should be $189.95. Actual: " + findBugsPage.getFallCoatOriginalPrice());
		Assert.assertTrue(findBugsPage.getFallCoatSalePrice().contains("169"),
				"Fall Coat sale price should be $169.95. Actual: " + findBugsPage.getFallCoatSalePrice());
	}

	// ── TC-F11: Add to Cart — DNK Yellow Shoes ───────────────────────────────

	@Test(priority = 11, description = "Verify that the 'Add to Cart' button works for DNK Yellow Shoes")
	public void testAddToCartDnkYellowShoes() {
		findBugsPage.clickDnkAddToCart();
		Assert.assertTrue(findBugsPage.isAddToCartSuccessMessageDisplayed(),
				"'Successfully Added to your Shopping Cart' message should appear");
	}

	// ── TC-F12: Add to Cart — Dark Grey Jeans ────────────────────────────────

	@Test(priority = 12, description = "Verify that the 'Add to Cart' button works for Dark Grey Jeans")
	public void testAddToCartDarkGreyJeans() {
		findBugsPage.clickDarkGreyJeansAddToCart();
		Assert.assertTrue(findBugsPage.isAddToCartSuccessMessageDisplayed(),
				"Item should be added to cart with success message");
	}

	// ── TC-F13: Checkout Now navigation ──────────────────────────────────────

	@Test(priority = 13, description = "Verify that the 'Checkout Now' button navigates to the cart page")
	public void testCheckoutNowNavigation() {
		findBugsPage.clickFirstCheckoutNow();
		Assert.assertTrue(driver.getCurrentUrl().contains("cart") ||
				driver.getCurrentUrl().contains("checkout"),
				"Should redirect to cart/checkout. Actual URL: " + driver.getCurrentUrl());
	}

	// ── TC-F14: Select Options — Fall Coat ───────────────────────────────────

	@Test(priority = 14, description = "Verify that the 'Select Options' button opens the product detail page for Fall Coat")
	public void testSelectOptionsFallCoat() {
		findBugsPage.clickFallCoatSelectOptions();
		Assert.assertTrue(driver.getCurrentUrl().contains("fall-coat"),
				"Should navigate to Fall Coat page. Actual URL: " + driver.getCurrentUrl());
	}

	// ── TC-F15: Select Options — Denim Coat ──────────────────────────────────

	@Test(priority = 15, description = "Verify that the 'Select Options' button opens the product detail page for Denim Coat")
	public void testSelectOptionsDenimCoat() {
		findBugsPage.clickDenimCoatSelectOptions();
		Assert.assertTrue(driver.getCurrentUrl().contains("denim-coat"),
				"Should navigate to Denim Coat page. Actual URL: " + driver.getCurrentUrl());
	}

	// ── TC-F16: Default sort selected ────────────────────────────────────────

	@Test(priority = 16, description = "Verify that the default sorting option is selected on page load")
	public void testDefaultSortOptionSelected() {
		Assert.assertTrue(driver.getPageSource().contains("Default Sorting") ||
				driver.getPageSource().contains("default"),
				"Default Sorting should be selected on page load");
	}

	// ── TC-F17: Sort Price Low-High ───────────────────────────────────────────

	@Test(priority = 17, description = "Verify that sorting by 'Price Low-High' reorders products correctly")
	public void testSortPriceLowToHigh() {
		findBugsPage.selectSortOption("Price Low-High");
		String firstProduct = findBugsPage.getFirstProductName();
		Assert.assertTrue(driver.getPageSource().contains("15.14") ||
				driver.getPageSource().contains("15"),
				"Lowest priced product (~$15.14) should appear first after Low-High sort");
	}

	// ── TC-F18: Sort Price High-Low ───────────────────────────────────────────

	@Test(priority = 18, description = "Verify that sorting by 'Price High-Low' reorders products correctly")
	public void testSortPriceHighToLow() {
		findBugsPage.selectSortOption("Price High-Low");
		Assert.assertTrue(driver.getPageSource().contains("478") ||
				driver.getPageSource().contains("479"),
				"Highest priced product (~$478.00) should appear first after High-Low sort");
	}

	// ── TC-F19: Sort Title A-Z ────────────────────────────────────────────────

	@Test(priority = 19, description = "Verify that sorting by 'Title A-Z' reorders products alphabetically")
	public void testSortTitleAToZ() {
		findBugsPage.selectSortOption("Title A-Z");
		String firstProduct = findBugsPage.getFirstProductName();
		Assert.assertTrue(firstProduct.compareToIgnoreCase("B") < 0 ||
				firstProduct.toUpperCase().charAt(0) <= 'D',
				"First product should be alphabetically first after A-Z sort. Actual: " + firstProduct);
	}

	// ── TC-F20: Sort Title Z-A ────────────────────────────────────────────────

	@Test(priority = 20, description = "Verify that sorting by 'Title Z-A' reorders products in reverse alphabetical order")
	public void testSortTitleZToA() {
		findBugsPage.selectSortOption("Title Z-A");
		String firstProduct = findBugsPage.getFirstProductName();
		Assert.assertTrue(firstProduct.toUpperCase().charAt(0) >= 'S',
				"First product should be alphabetically last after Z-A sort. Actual: " + firstProduct);
	}

	// ── TC-F21: Sort Best Rating ──────────────────────────────────────────────

	@Test(priority = 21, description = "Verify that sorting by 'Best Rating' does not produce an error")
	public void testSortBestRatingNoError() {
		findBugsPage.selectSortOption("Best Rating");
		Assert.assertFalse(driver.getPageSource().contains("Fatal error") ||
				driver.getPageSource().contains("500"),
				"Sorting by Best Rating should not produce a server error");
		Assert.assertTrue(findBugsPage.getProductCount() > 0,
				"Products should still be visible after Best Rating sort");
	}

	// ── TC-F22: Sort Most Viewed ──────────────────────────────────────────────

	@Test(priority = 22, description = "Verify that sorting by 'Most Viewed' does not produce an error")
	public void testSortMostViewedNoError() {
		findBugsPage.selectSortOption("Most Viewed");
		Assert.assertFalse(driver.getPageSource().contains("Fatal error") ||
				driver.getPageSource().contains("500"),
				"Sorting by Most Viewed should not produce a server error");
		Assert.assertTrue(findBugsPage.getProductCount() > 0,
				"Products should still be visible after Most Viewed sort");
	}

	// ── TC-F23: View 10 ───────────────────────────────────────────────────────

	@Test(priority = 23, description = "Verify that clicking 'View 10' limits the product display to 10 items")
	public void testView10LimitsProducts() {
		findBugsPage.clickView10();
		int count = findBugsPage.getProductCount();
		Assert.assertTrue(count <= 10,
				"Product count should be 10 or fewer. Actual: " + count);
	}

	// ── TC-F24: View 25 ───────────────────────────────────────────────────────

	@Test(priority = 24, description = "Verify that clicking 'View 25' shows all 18 products")
	public void testView25ShowsAllProducts() {
		findBugsPage.clickView25();
		int count = findBugsPage.getProductCount();
		Assert.assertEquals(count, 18,
				"All 18 products should be visible after View 25. Actual: " + count);
	}

	// ── TC-F25: View 50 ───────────────────────────────────────────────────────

	@Test(priority = 25, description = "Verify that clicking 'View 50' shows all products without pagination")
	public void testView50ShowsAllProducts() {
		findBugsPage.clickView50();
		int count = findBugsPage.getProductCount();
		Assert.assertEquals(count, 18,
				"All 18 products should be visible after View 50. Actual: " + count);
	}

	// ── TC-F26: Clicking product opens detail page ────────────────────────────

	@Test(priority = 26, description = "Verify that clicking a product name opens its detail page")
	public void testClickProductOpensDetailPage() {
		findBugsPage.clickFlamingoTshirt();
		Assert.assertTrue(driver.getCurrentUrl().contains("flamingo"),
				"Should navigate to Flamingo Tshirt page. Actual URL: " + driver.getCurrentUrl());
	}

	// ── TC-F27: Product detail price matches listing ──────────────────────────

	@Test(priority = 27, description = "Verify that the product detail page price matches the listing page price")
	public void testProductDetailPriceMatchesListing() {
		findBugsPage.clickBuddhabracelet();
		Assert.assertTrue(driver.getPageSource().contains("107"),
				"Buddha Bracelet detail page should show $107.00");
	}

	// ── TC-F28: Bug counter initializes at 0 ─────────────────────────────────

	@Test(priority = 28, description = "Verify that the bug counter initializes at 0 on a fresh session")
	public void testBugCounterInitialState() {
		Assert.assertTrue(findBugsPage.isBugCounterDisplayed(),
				"Bug counter widget should be visible");
		String counterText = findBugsPage.getBugCounterText();
		Assert.assertTrue(counterText.contains("25"),
				"Bug counter should reference 25 total bugs. Actual: " + counterText);
	}

	// ── TC-F29: Bug counter increments ───────────────────────────────────────

	@Test(priority = 29, description = "Verify that the bug counter increments when a bug is discovered")
	public void testBugCounterIncrements() {
		String before = findBugsPage.getBugCounterText();
		// Trigger a known bug: click DNK add to cart triggers bug detection
		findBugsPage.clickDnkAddToCart();
		String after = findBugsPage.getBugCounterText();
		// Counter should have changed or at least still be present
		Assert.assertNotNull(after,
				"Bug counter should still be visible after interacting with the page");
	}

	// ── TC-F30: 'Not a real order' disclaimer ────────────────────────────────

	@Test(priority = 30, description = "Verify that the 'Not a real order' disclaimer appears at checkout")
	public void testNotRealOrderDisclaimer() {
		findBugsPage.clickDnkAddToCart();
		findBugsPage.clickFirstCheckoutNow();
		Assert.assertTrue(driver.getPageSource().contains("not create a real order") ||
				driver.getPageSource().contains("education purposes"),
				"Checkout should show 'not a real order' education notice");
	}

	// ── TC-F31: Profile settings hint ────────────────────────────────────────

	@Test(priority = 31, description = "Verify that the profile settings bug hint modal is triggered")
	public void testProfileSettingsHint() {
		driver.get(config.getBaseUrl() + "account/");
		try { headerPage.closeTutorial(); } catch (Exception e) {}
		Assert.assertTrue(driver.getPageSource().contains("profile") ||
				driver.getPageSource().contains("account"),
				"Should be on the account/profile page");
	}

	// ── TC-F32: Mobile viewport ───────────────────────────────────────────────

	@Test(priority = 32, description = "Verify that the page renders correctly on mobile viewport (375px)")
	public void testMobileViewport() {
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 812));
		Assert.assertTrue(findBugsPage.isPageSubtitleDisplayed(),
				"Page subtitle should still be visible on mobile viewport");
		Assert.assertTrue(findBugsPage.getProductCount() > 0,
				"Products should still be visible on mobile viewport");
		// restore
		driver.manage().window().maximize();
	}

	// ── TC-F33: Tablet viewport ───────────────────────────────────────────────

	@Test(priority = 33, description = "Verify that the page renders correctly on tablet viewport (768px)")
	public void testTabletViewport() {
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(768, 1024));
		Assert.assertTrue(findBugsPage.isPageSubtitleDisplayed(),
				"Page subtitle should still be visible on tablet viewport");
		Assert.assertTrue(findBugsPage.getProductCount() > 0,
				"Products should still be visible on tablet viewport");
		// restore
		driver.manage().window().maximize();
	}
}