package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.SearchPage;
import pageObject.SearchResultPage;
import testBase.BaseClass;

public class TC005_SearchInvalidProductTest extends BaseClass {

    @Test
    public void verify_InvalidSearch() {

        logger.info("***** Starting Invalid Search Test *****");

        SearchPage sp = new SearchPage(getDriver());

        sp.enterSearchKeyword("ABCXYZ123");
        sp.clickSearchButton();

        SearchResultPage srp = new SearchResultPage(getDriver());

        Assert.assertTrue(
                srp.isNoProductMessageDisplayed(),
                "No Product Found message is not displayed");

        logger.info("***** Invalid Search Test Passed *****");
    }
}