package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	// Constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement cnftxtPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdpolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// Actions Methods

	public void setFirstname(String fname) {
	    txtFirstname.sendKeys(fname);
	}

	public void setLastname(String lname) {
	    txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
	    txtEmail.sendKeys(email);
	}
	public void setTelephone(String telephone) {
	    txtTelephone.sendKeys(telephone);
	}

	public void setPassword(String pwd) {
	    txtPassword.sendKeys(pwd);
	}
	
	public void setcnfPassword(String pwd) {
	    cnftxtPassword.sendKeys(pwd);
	}

	public void setPrivacyPolicy() {
		chkdpolicy.click();
		// chkdpolicy.submit();
	}

	public void clickContinue() {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(20));

	    wait.until(ExpectedConditions.elementToBeClickable(btnContinue));

	    btnContinue.click();
	}

	public String getConfirmation() {

	    try {

	        WebDriverWait wait =
	                new WebDriverWait(driver,
	                        Duration.ofSeconds(20));

	        wait.until(
	                ExpectedConditions.visibilityOf(
	                        msgConfirmation));

	        return msgConfirmation.getText();

	    } catch (Exception e) {

	        return e.getMessage();
	    }
	}
}
