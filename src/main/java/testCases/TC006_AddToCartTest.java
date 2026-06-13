package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ProductPage;
import pageObject.SearchPage;
import pageObject.SearchResultPage;
import testBase.BaseClass;

public class TC006_AddToCartTest extends BaseClass {

    @Test
    public void verify_AddToCart() {

        logger.info("***** Starting Add To Cart Test *****");

        SearchPage sp = new SearchPage(getDriver());

        logger.info("Searching for product");
        sp.enterSearchKeyword("MacBook");
        sp.clickSearchButton();

        SearchResultPage srp = new SearchResultPage(getDriver());

        logger.info("Validating product availability");
        Assert.assertTrue(srp.isProductAvailable("MacBook"));

        logger.info("Opening product page");
        srp.clickProduct("MacBook");

        ProductPage pp = new ProductPage(getDriver());

        logger.info("Adding product to cart");
        pp.clickAddToCart();

        logger.info("Validating success message");

        Assert.assertTrue(
                pp.getSuccessMessage().contains("Success"),
                "Product was not added to cart");

        logger.info("***** Add To Cart Test Passed *****");
    }
}