package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {

	    try {

//	        System.out.println("STEP-1");

	        HomePage hp = new HomePage(getDriver());
	        hp.clickMyAccount();

//	        System.out.println("STEP-2");

	        hp.clickRegister();

//	        System.out.println("STEP-3");

	        AccountRegistrationPage regpage =
	                new AccountRegistrationPage(getDriver());

	        regpage.setFirstname(randomString().toUpperCase());
	        regpage.setLastname(randomString().toUpperCase());
	        regpage.setEmail(randomString()+"@gmail.com");
	        regpage.setTelephone(randomNumber());

	        String password=randomAlphaNumeric();

	        regpage.setPassword(password);
	        regpage.setcnfPassword(password);

//	        System.out.println("STEP-4");

	        regpage.setPrivacyPolicy();
	        regpage.clickContinue();

//	        System.out.println("STEP-5");

	        String confmsg=regpage.getConfirmation();

//	        System.out.println("STEP-6");

	        Assert.assertEquals(
	                confmsg,
	                "Your Account Has Been Created!");

	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	        Assert.fail();
	    }
		logger.info("****Finished TC001_AccountRegistrationTest****");
	
	}
}