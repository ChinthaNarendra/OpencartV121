package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.SearchPage;
import pageObject.SearchResultPage;
import testBase.BaseClass;

public class TC004_SearchTest extends BaseClass {

    @Test
    public void verify_Search() {

        try {

            logger.info("***** Starting Search Test *****");

            SearchPage sp = new SearchPage(getDriver());

            logger.info("Entering product name");
            sp.enterSearchKeyword("MacBook");

            logger.info("Clicking search button");
            sp.clickSearchButton();

            SearchResultPage srp = new SearchResultPage(getDriver());

            logger.info("Validating search results");

            Assert.assertTrue(srp.isProductAvailable("MacBook"));

            logger.info("***** Search Test Passed *****");

        } catch (Exception e) {

            logger.error("Search Test Failed");
            Assert.fail();
        }
    }
}