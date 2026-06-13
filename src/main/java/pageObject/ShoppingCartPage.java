package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//button[@class='btn btn-danger']")
    WebElement btnRemove;

    @FindBy(xpath="//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
    WebElement msgEmptyCart;

    public void clickRemoveButton() {
        btnRemove.click();
    }

    public String getEmptyCartMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(msgEmptyCart));

        return msgEmptyCart.getText();
    }
}