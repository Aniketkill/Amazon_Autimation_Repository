package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilesAccessories_Page {


	@FindBy(xpath = "(//div[@id='acs-product-block-1'])[1]")
	private WebElement accOption1;
	
	
	@FindBy(xpath = "(//div[@id='acs-product-block-3'])[1]")
	private WebElement accOption2;
	
	public MobilesAccessories_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickonItem1() {
		accOption1.click();
		//--> After this new page will open -> ProductDetails1_Page
		//--> We will click on back option & come back to this page
	}
	
	public void clickonItem2() {
		accOption2.click();
		//--> After this new page will open -> ProductDetails2_Page
	}
}
