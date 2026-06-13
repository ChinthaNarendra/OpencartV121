package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(id = "button-cart")
	WebElement btnAddToCart;

	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement successMsg;

	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
	WebElement lnkShoppingCart;

	@FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
	WebElement btnWishList;
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement productName;

	
	public String getProductName() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOf(productName));

	    return productName.getText();
	}
	public void clickShoppingCart() {
		lnkShoppingCart.click();
	}

	public void clickAddToCart() {
		btnAddToCart.click();
	}

	public void clickWishList() {
		btnWishList.click();
	}

	public String getSuccessMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(successMsg));

		return successMsg.getText();
	}
}