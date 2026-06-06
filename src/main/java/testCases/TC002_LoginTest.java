package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity", "Master"})
	public void verify_login() {
		logger.info("****Started TC002_LoginTest****");

		try {

			// Home Page
			HomePage hp = new HomePage(getDriver());
			logger.info("Clicking on MyAccount");
			hp.clickMyAccount();

			logger.info("Clicking on Login");
			hp.clickLogin();

			// LoginPage
			LoginPage lp = new LoginPage(getDriver());
			lp.setEmail(p.getProperty("email")); // this email & Password will come from the config.properties
			lp.setPassword(p.getProperty("password"));

			logger.info("Clicking on Login Button");
			lp.clickLogin();

			// MyAccountPage
			MyAccountPage myac = new MyAccountPage(getDriver());

			logger.info("Checking whether Heading is displayed or not....");
			boolean target_page = myac.isMyAccountPageexists();
			Assert.assertEquals(target_page, true, "Lohin failed...");
		} catch (Exception e) {
		    logger.error("Exception occurred", e);
		    Assert.fail(e.getMessage());
		}

		logger.info("**** Finished TC002_LoginTest ****");

	}
}
