package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GotoCart_Page {

	@FindBy(xpath = "//select[@name='quantity']")
	private WebElement qty;
	
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]")
	private WebElement qtyBefore;
	
	@FindBy(xpath = "//span[@id='sc-subtotal-amount-buybox']")
	private WebElement qtyAfter;
	
	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	private WebElement buy;
	
	
	
	public GotoCart_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnQuantity() {
		Select s = new Select (qty);
		s.selectByIndex(2);
	}
	
	public void clickOnProceedToBuy() {
		buy.click();
		//--> After this new page will open -> SignIn_Page
	}
	
	public String qtyAmountBefore() {
		String beforeAmount = qtyBefore.getText();
		return beforeAmount;
	}
	
	public String qtyAmountAfter() {
		String AfterAmount = qtyAfter.getText();
		return AfterAmount;
	}
	
	
}
