package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	// Constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") //added in step 6
	WebElement lnkLogout;

	// Action Methods
	public boolean isMyAccountPageexists() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
