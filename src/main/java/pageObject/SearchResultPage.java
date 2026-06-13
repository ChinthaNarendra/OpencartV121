package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='product-thumb']")
    List<WebElement> products;
    
    @FindBy(xpath="//div[@class='caption']//a")
    List<WebElement> productNames;
    
    @FindBy(xpath="//p[contains(text(),'There is no product that matches the search criteria.')]")
    WebElement noProductMsg;

    


    public int getSearchResultCount() {
        return products.size();
    }

    public boolean isProductFound() {
        return products.size() > 0;
    }
    
   
    public boolean isProductAvailable(String expProduct) {

        for(WebElement product : productNames) {

        	if(product.getText().contains(expProduct)) {
                return true;
            }
        }

        return false;
    }
    
    public boolean isNoProductMessageDisplayed() {
        return noProductMsg.isDisplayed();
    }
    
    public void clickProduct(String productName) {

        for(WebElement product : productNames) {

            if(product.getText().equalsIgnoreCase(productName)) {

                product.click();
                break;
            }
        }
    }
}