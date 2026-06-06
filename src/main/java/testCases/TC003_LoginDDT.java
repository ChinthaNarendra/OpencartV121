package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
    public void verify_loginDDT(String email, String pwd, String exp) {

//        System.out.println("====================================");
//        System.out.println("Email    : " + email);
//        System.out.println("Password : " + pwd);
//        System.out.println("Expected : " + exp);

        logger.info("**** Starting TC003_LoginDDT ****");

        try {

            HomePage hp = new HomePage(getDriver());
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail(email);
            lp.setPassword(pwd);
            lp.clickLogin();

            // Temporary wait for page loading
            Thread.sleep(3000);

            MyAccountPage myac = new MyAccountPage(getDriver());
            boolean target_page = myac.isMyAccountPageexists();

            System.out.println("Login Success Status = " + target_page);

            if (exp.equalsIgnoreCase("valid")) {

                if (target_page) {
                    myac.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.fail("Expected VALID login but login failed");
                }

            } else if (exp.equalsIgnoreCase("invalid")) {

                if (target_page) {
                    myac.clickLogout();
                    Assert.fail("Expected INVALID login but login succeeded");
                } else {
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

        logger.info("**** Finished TC003_LoginDDT ****");
    }
}