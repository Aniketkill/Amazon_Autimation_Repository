package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_Page {

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement mobileNo;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement getOTP;
	
	@FindBy(xpath = "//input[@id='cvf-input-code']")
	private WebElement enterOTP;
	
	WebDriver driver;
	
	public SignIn_Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void sendMobileNumber(String number) {
		mobileNo.sendKeys(number);
		mobileNo.submit();
	}
		
	public void clickOnGetOTP() {
		getOTP.click();
	}
	
	public void enterOTP(String otp) {
		enterOTP.sendKeys(otp);
		enterOTP.submit();
	}
	
	public String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
}
