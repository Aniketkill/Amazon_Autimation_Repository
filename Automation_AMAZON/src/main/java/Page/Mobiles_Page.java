package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mobiles_Page {

	
	@FindBy(xpath = "//span[text() = 'Mobile Accessories']") 
	private	WebElement mobacc;
	
	public Mobiles_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMobileAccessories() {
		mobacc.click();
		//--> After this new page will open -> MobilesAccessories_Page
	}
	
	
}
