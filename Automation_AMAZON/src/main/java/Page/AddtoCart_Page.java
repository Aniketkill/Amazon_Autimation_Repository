package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart_Page {

	
	@FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	private WebElement verifyOrder;
	
	@FindBy(xpath = "//a[@data-csa-c-content-id='sw-gtc_CONTENT']")
	private WebElement goToCart;
	
	WebDriver driver;
	
	public AddtoCart_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public void clickOnGoToCart() {
		goToCart.click();
		//--> After this new page will open -> GotoCart_Page
	}
	
	public String getOrderconfirmation() {
		String order = verifyOrder.getText();
		return order;
	}
	
	public String getURL() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	
	
}
