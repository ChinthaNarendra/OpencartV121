package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.SearchPage;
import pageObject.SearchResultPage;
import testBase.BaseClass;

public class TC009_AddToWishListTest extends BaseClass {

	@Test
	public void verify_AddToWishList() {

		// Login
		HomePage hp = new HomePage(getDriver());

		hp.clickMyAccount();
		hp.clickLogin();

		LoginPage lp = new LoginPage(getDriver());

		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();

		// Search Product
		SearchPage sp = new SearchPage(getDriver());

		sp.enterSearchKeyword("MacBook");
		sp.clickSearchButton();

		// Open Product
		SearchResultPage srp = new SearchResultPage(getDriver());
		srp.clickProduct("MacBook");

		// Add to Wishlist
		ProductPage pp = new ProductPage(getDriver());

		String product = pp.getProductName();

		pp.clickWishList();

//		System.out.println("Wishlist clicked");

		String msg = pp.getSuccessMessage();

//		System.out.println("Message received : " + msg);

		Assert.assertTrue(msg.contains("wish list"));

//		System.out.println("Assertion passed");
	}
}