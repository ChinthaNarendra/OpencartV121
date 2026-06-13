package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.LogoutPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC008_LogoutTest extends BaseClass {

    @Test
    public void verify_Logout() {

        // Login
        HomePage hp = new HomePage(getDriver());

        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(getDriver());

        lp.setEmail(p.getProperty("email"));
        lp.setPassword(p.getProperty("password"));
        lp.clickLogin();

        HomePage hp1 = new HomePage(getDriver());

        hp1.clickMyAccountDropdown();
        hp1.clickMyAccountOption();
        
        // Open My Account page from dropdown
        hp.clickMyAccountDropdown();
        hp.clickMyAccountOption();

        // Logout
        MyAccountPage map = new MyAccountPage(getDriver());

        Assert.assertTrue(map.isMyAccountPageexists());

        map.clickLogout();

        // Verify Logout
        LogoutPage lop = new LogoutPage(getDriver());

        Assert.assertTrue(lop.isLogoutSuccessful());
    }
}