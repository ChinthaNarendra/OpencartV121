package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	
	
	//Constructor
	public SearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//Locators
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txtSearch;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
	
	//Action Methods
	
	public void enterSearchKeyword(String productName)
	{
	    txtSearch.clear();
	    txtSearch.sendKeys(productName);
	}
	
	public void clickSearchButton() {
		btnSearch.click();
//		Actions act = new Actions(driver);
//		act.moveToElement(lnkSearchButton).click().perform();
	}
	
	public void searchProduct(String productName)
	{
	    txtSearch.clear();
	    txtSearch.sendKeys(productName);
	    btnSearch.click();
	}

}
