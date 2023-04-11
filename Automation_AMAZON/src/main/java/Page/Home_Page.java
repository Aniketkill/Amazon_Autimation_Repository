package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	//--> 1. VARIABLE DECLARATION
	
	@FindBy (xpath = "//i[@class='a-icon a-icon-next-rounded']")
	private WebElement sliderfrwd;

	@FindBy (xpath = "//i[@class='a-icon a-icon-previous-rounded']")
	private WebElement sliderbckwd;
	
	@FindBy (xpath = "(//span[@class='gw-icon feed-arrow'])[2]")
	private WebElement dealsSliderfrwd;

	@FindBy (xpath = "//a[@href='/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles']")
	private WebElement mobile;
	
	private WebDriver driver;
	private JavascriptExecutor javascriptExecutor;
	
	
	//--> 2. VARIABLE INITIALIZATION
	
	public Home_Page (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		javascriptExecutor = (JavascriptExecutor)driver;
		
	}
	
	
	//--> 3. VARIABLE USE
	
	public void clickOnFrwdSlider() {
		sliderfrwd.click();
	}
	
	public void clickOnBckwdSlider() {
		sliderbckwd.click();
	}
	
	public void clickOnDealsFrwdSlider() throws InterruptedException {
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();",dealsSliderfrwd);
		Thread.sleep(2000);
		javascriptExecutor.executeScript("window.scrollBy(0,-150)");
		Thread.sleep(2000);
		dealsSliderfrwd.click();
		
	}
	
	
	public void clickOnMobile() {
		mobile.click();
		//--> After this new page will open -> Mobiles_Page
	}
	
	public void scroll(){
		javascriptExecutor.executeScript("window.scrollBy(0,500)");
	}
	
	public void scrollToBottom() {
		javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollToTop() {
		javascriptExecutor.executeScript("window.scrollBy(0,-7000)");
	}
	
	
	
	
}
