package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ProductPage;
import pageObject.SearchPage;
import pageObject.SearchResultPage;
import pageObject.ShoppingCartPage;
import testBase.BaseClass;

public class TC007_RemoveFromCartTest extends BaseClass {

    @Test
    public void verify_RemoveFromCart() {

        logger.info("***** Starting Remove From Cart Test *****");

        SearchPage sp = new SearchPage(getDriver());

        sp.enterSearchKeyword("MacBook");
        sp.clickSearchButton();

        SearchResultPage srp = new SearchResultPage(getDriver());

        Assert.assertTrue(srp.isProductAvailable("MacBook"));

        srp.clickProduct("MacBook");

        ProductPage pp = new ProductPage(getDriver());

        pp.clickAddToCart();

        logger.info("Opening Shopping Cart");

        pp.clickShoppingCart();

        ShoppingCartPage scp = new ShoppingCartPage(getDriver());

        logger.info("Removing Product");

        scp.clickRemoveButton();

        logger.info("Validating Empty Cart Message");

        Assert.assertEquals(
                scp.getEmptyCartMessage(),
                "Your shopping cart is empty!");

        logger.info("***** Remove From Cart Test Passed *****");
    }
}