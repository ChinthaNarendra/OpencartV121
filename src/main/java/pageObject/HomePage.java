package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	WebDriver driver;

	// Constructor
	public HomePage(WebDriver driver) {

		super(driver);

		this.driver = driver;
	}

	// Locators

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement lnkMyaccountDropdown;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;

	@FindBy(linkText = "My Account")
	WebElement lnkMyAccountOption;

	// Action Methods

	public void clickMyAccount() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='My Account']")));

		lnkMyaccountDropdown.click();
	}

	public void clickRegister() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(lnkRegister));

		lnkRegister.click();
	}

	public void clickLogin() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(lnkLogin));

		lnkLogin.click();
	}

	public void clickMyAccountDropdown() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(lnkMyaccountDropdown));

	    lnkMyaccountDropdown.click();
	}
	public void clickMyAccountOption() {
		lnkMyAccountOption.click();
	}

}