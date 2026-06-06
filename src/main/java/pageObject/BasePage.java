package pageObject;
//This class is just for the constructor to reuse in other classes(mainly for re-usability)
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	
	protected WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
