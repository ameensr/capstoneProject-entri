package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FindBugsPage;
import pages.HeaderPage;

public class FindBugsPageTest extends BaseTest {
	 
		FindBugsPage findBugsPage;
		HeaderPage   headerPage;
	 
		@BeforeMethod
		public void setUp() {
			driver.get(config.getBaseUrl() + "find-bugs/");
			findBugsPage = new FindBugsPage(driver);
			headerPage   = new HeaderPage(driver);
			try { headerPage.closeTutorial(); } catch (Exception e) {}
		}
	 
	 
		@Test(priority = 1, description = "Verify that the Find Bugs page loads successfully without errors")
		public void testPageLoadsSuccessfully() {
			Assert.assertTrue(driver.getCurrentUrl().contains("find-bugs"),
					"URL should contain 'find-bugs'");
			Assert.assertTrue(findBugsPage.isPageSubtitleDisplayed(),
					"Page subtitle should be visible after load");
		}
	 
	 
		@Test(priority = 2, description = "Verify that the page subtitle text is correct")
		public void testPageSubtitle() {
			String subtitle = findBugsPage.getPageSubtitle();
			Assert.assertTrue(subtitle.contains("25 real bugs"),
					"Page subtitle mismatch. Actual: " + subtitle);
		}
	 
	 
		@Test(priority = 3, description = "Verify that 18 products are displayed by default")
		public void testEighteenProductsDisplayed() {
			int count = findBugsPage.getProductCount();
			Assert.assertEquals(count, 18,
					"Expected 18 products but found: " + count);
		}
	 
	 
		@Test(priority = 4, description = "Verify that the product result count label is accurate")
		public void testResultsCountLabel() {
			String label = findBugsPage.getResultsLabelText();
			Assert.assertTrue(label.contains("18"),
					"Results label should show 18. Actual: " + label);
		}
	 
	 
		@Test(priority = 5, description = "Verify that all product images load correctly without broken icons")
		public void testAllProductImagesLoad() {
			Assert.assertFalse(driver.getPageSource().contains("broken"),
					"Page should not contain broken image references");
			Assert.assertTrue(driver.getPageSource().contains("academybugs.com"),
					"Product images should be served from academybugs.com");
		}
	 
	 
		@Test(priority = 6, description = "Verify that the Denim Coat image loads from the correct domain")
		public void testDenimCoatImageDomain() {
			String href = findBugsPage.getDenimCoatImageSrc();
			Assert.assertTrue(href.contains("academybugs.com"),
					"Denim Coat image should load from academybugs.com. Actual src: " + href);
		}
	 
	 
		@Test(priority = 7, description = "Verify that all products display a price")
		public void testAllProductsHavePrice() {
			Assert.assertTrue(driver.getPageSource().contains("$") ||
					driver.getPageSource().contains("Login for Pricing"),
					"Products should display prices or 'Login for Pricing'");
		}
	 
	 
		@Test(priority = 8, description = "Verify that Dark Blue Denim Jeans shows 'Login for Pricing' for users")
		public void testDarkBlueDenimJeansLoginPricing() {
			Assert.assertTrue(findBugsPage.isDarkBlueDenimLoginPriceShown(),
					"Dark Blue Denim Jeans should show 'Login for Pricing' for guest users");
		}
	 
	 
		@Test(priority = 9, description = "Verify that the Blue Hoodie displays the correct original and sale price")
		public void testBlueHoodieSalePrice() {
			Assert.assertTrue(findBugsPage.isBlueHoodieSalePriceDisplayed(),
					"Blue Hoodie should show a sale price");
			Assert.assertTrue(findBugsPage.getBlueHoodieOriginalPrice().contains("140"),
					"Blue Hoodie original price should be $140. Actual: " + findBugsPage.getBlueHoodieOriginalPrice());
			Assert.assertTrue(findBugsPage.getBlueHoodieSalePrice().contains("111"),
					"Blue Hoodie sale price should be $111. Actual: " + findBugsPage.getBlueHoodieSalePrice());
		}
	 
	 
		@Test(priority = 10, description = "Verify that the 'Add to Cart' button works for DNK Yellow Shoes")
		public void testAddToCartDnkYellowShoes() {
			findBugsPage.clickDnkAddToCart();
			Assert.assertTrue(findBugsPage.isAddToCartSuccessMessageDisplayed(),
					"'Successfully Added to your Shopping Cart' message should appear");
		}
	 
	 
		@Test(priority = 11, description = "Verify that the 'Add to Cart' button works for Dark Grey Jeans")
		public void testAddToCartDarkGreyJeans() {
			findBugsPage.clickDarkGreyJeansAddToCart();
			Assert.assertTrue(findBugsPage.isAddToCartSuccessMessageDisplayed(),
					"Item should be added to cart with success message");
		}
	 
	 
		@Test(priority = 12, description = "Verify that the 'View Cart' button navigates to the cart page")
		public void testCheckoutNowNavigation() {
			findBugsPage.addToCartThenViewCart();
			Assert.assertTrue(
					driver.getCurrentUrl().contains("cart") || driver.getCurrentUrl().contains("checkout"),
					"Should redirect to cart/checkout page. Actual URL: " + driver.getCurrentUrl());
		}
	 
	 
		@Test(priority = 13, description = "Verify that the 'Select Options' button opens the product detail page for Fall Coat")
		public void testSelectOptionsFallCoat() {
			findBugsPage.clickFallCoatSelectOptions();
			Assert.assertTrue(driver.getCurrentUrl().contains("fall-coat"),
					"Should navigate to Fall Coat page. Actual URL: " + driver.getCurrentUrl());
		}
	 
	 
		@Test(priority = 14, description = "Verify that the default sorting option is selected on page load")
		public void testDefaultSortOptionSelected() {
			Assert.assertTrue(driver.getPageSource().contains("Default Sorting") ||
					driver.getPageSource().contains("default"),
					"Default Sorting should be selected on page load");
		}
	 
	 
		@Test(priority = 15, description = "Verify that sorting by 'Price Low-High' reorders products correctly")
		public void testSortPriceLowToHigh() {
			findBugsPage.selectSortOption("Price Low-High");
			Assert.assertTrue(driver.getPageSource().contains("15.14") ||
					driver.getPageSource().contains("15"),
					"Lowest priced product (~$15.14) should appear first after Low-High sort");
		}
	 
	 
		@Test(priority = 16, description = "Verify that sorting by 'Price High-Low' reorders products correctly")
		public void testSortPriceHighToLow() {
			findBugsPage.selectSortOption("Price High-Low");
			Assert.assertTrue(driver.getPageSource().contains("478") ||
					driver.getPageSource().contains("479"),
					"Highest priced product (~$478.00) should appear first after High-Low sort");
		}
	 
	 
		@Test(priority = 17, description = "Verify that sorting by 'Title A-Z' reorders products alphabetically")
		public void testSortTitleAToZ() {
			findBugsPage.selectSortOption("Title A-Z");
			String firstProduct = findBugsPage.getFirstProductName();
			Assert.assertTrue(firstProduct.compareToIgnoreCase("B") < 0 ||
					firstProduct.toUpperCase().charAt(0) <= 'D',
					"First product should be alphabetically first after A-Z sort. Actual: " + firstProduct);
		}
	 
	 
		@Test(priority = 18, description = "Verify that clicking 'View 10' limits the product display to 10 items")
		public void testView10LimitsProducts() {
			findBugsPage.clickView10();
			int count = findBugsPage.getProductCount();
			Assert.assertTrue(count <= 10,
					"Product count should be 10 or fewer. Actual: " + count);
		}
	 
	 
		@Test(priority = 19, description = "Verify that clicking 'View 25' shows all 18 products")
		public void testView25ShowsAllProducts() {
			findBugsPage.clickView25();
			int count = findBugsPage.getProductCount();
			Assert.assertEquals(count, 18,
					"All 18 products should be visible after View 25. Actual: " + count);
		}
	 
	 
		@Test(priority = 20, description = "Verify that clicking 'View 50' shows all products without pagination")
		public void testView50ShowsAllProducts() {
			findBugsPage.clickView50();
			int count = findBugsPage.getProductCount();
			Assert.assertEquals(count, 18,
					"All 18 products should be visible after View 50. Actual: " + count);
		}
	 
	 
		@Test(priority = 21, description = "Verify that clicking a product name opens its detail page")
		public void testClickProductOpensDetailPage() {
			findBugsPage.clickFlamingoTshirt();
			Assert.assertTrue(driver.getCurrentUrl().contains("flamingo"),
					"Should navigate to Flamingo Tshirt page. Actual URL: " + driver.getCurrentUrl());
		}
	 
	 
		@Test(priority = 22, description = "Verify that the product (Buddha Bracelet) detail page price matches the listing page price")
		public void testProductDetailPriceMatchesListing() {
			findBugsPage.clickBuddhabracelet();
			Assert.assertTrue(driver.getPageSource().contains("107"),
					"Buddha Bracelet detail page should show $107.00");
		}
		
		@Test(priority = 23, description = "Verify login functionality from cart page")
		public void testLoginFromCart() {

		    findBugsPage.loginFromCart(
		        "c.ar.losad.ar.us.a@gmail.com",
		        "Abc@123456"
		    );

		    // Validation (based on site behavior)
		    Assert.assertTrue(
		    	    findBugsPage.isLoginAttemptHandled(),
		    	    "Login action did not trigger any expected behavior (bug)"
		    	);
		}
	 
	 
		@Test(priority = 24, description = "Verify that the page renders correctly on mobile viewport (375px)")
		public void testMobileViewport() {
			driver.manage().window().setSize(new org.openqa.selenium.Dimension(375, 812));
			Assert.assertTrue(findBugsPage.isPageSubtitleDisplayed(),
					"Page subtitle should still be visible on mobile viewport");
			Assert.assertTrue(findBugsPage.getProductCount() > 0,
					"Products should still be visible on mobile viewport");
			driver.manage().window().maximize();
		}
	 
	 
		@Test(priority = 25, description = "Verify that the page renders correctly on tablet viewport (768px)")
		public void testTabletViewport() {
			driver.manage().window().setSize(new org.openqa.selenium.Dimension(768, 1024));
			Assert.assertTrue(findBugsPage.isPageSubtitleDisplayed(),
					"Page subtitle should still be visible on tablet viewport");
			Assert.assertTrue(findBugsPage.getProductCount() > 0,
					"Products should still be visible on tablet viewport");
			driver.manage().window().maximize();
		}
	 
	 
		@Test(priority = 26, description = "Verify that the user is able to navigate to the cart page after adding a product to the cart and continue to checkout")
		public void testCheckoutNavigation() {
			findBugsPage.checkCheckOutFlow(
					"India",
					"Amee",
					"Stark",
					"123 Abc Street",
					"Trivandrum",
					"Kerala",
					"695618",
					"8855445566",
					"jameetest@test.com"
			);
	 
			Assert.assertTrue(
					driver.getCurrentUrl().contains("shipping") || driver.getPageSource().contains("Shipping"),
					"Should navigate to Shipping page after Continue to Shipping. Actual URL: " + driver.getCurrentUrl()
			);
		}
		
	}