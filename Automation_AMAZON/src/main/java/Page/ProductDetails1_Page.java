package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails1_Page {

	@FindBy(xpath = "//div[@id='imgTagWrapperId']//img")
	private WebElement imageClick;
	
	@FindBy(xpath = "//div[@id='ivTitle']")
	private WebElement imageDetails;
	
	@FindBy(xpath = "//button[@class=' a-button-close a-declarative a-button-top-right']")
	private WebElement close;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement cart;
	
	private WebDriver driver;
	private Actions actions;
	
	public ProductDetails1_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public ProductDetails1_Page clickOnImage() {
		actions.moveToElement(imageClick).click().build().perform();
		return this;
	}
	
	public String getimageDetails() {
		String details = imageDetails.getText();
		return details;
	}
	
	public void clickOnCloseOption() {
		close.click();
	}
	
	public void clickOnAddToCart() {
		cart.click(); 
		//--> After this new page will open -> AddtoCart_Page
	}
	
	
	
	
	
	
	
}
