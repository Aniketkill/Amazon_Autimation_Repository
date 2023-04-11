package testNgPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Page.AddtoCart_Page;
import Page.GotoCart_Page;
import Page.Home_Page;
import Page.MobilesAccessories_Page;
import Page.Mobiles_Page;
import Page.ProductDetails1_Page;
import Page.SignIn_Page;
import browserSetup.Base;

public class VerifyProceedToBuyFunctionality extends Base{
	WebDriver driver;
	Home_Page home_Page;
	Mobiles_Page mobiles_Page;
	MobilesAccessories_Page mobilesAccessories_Page;
	ProductDetails1_Page productDetails1_Page;
	AddtoCart_Page addtoCart_Page;
	GotoCart_Page gotoCart_Page;
	SignIn_Page signIn_Page;

	
	@Parameters("browser")

	@BeforeTest
	public void launchBrowser(String browserName) {
		System.out.println("Browser Launched");

		if (browserName.equals("Chrome")) {
			driver = openChromeBrowser();
		}

		if (browserName.equals("Firefox")) {
			driver = openFirefoxBrowser();
		}

		if (browserName.equals("Edge")) {
			driver = openEdgeBrowser();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS); // -->IMPLICIT WAIT
	}

	
	@BeforeClass
	public void createPOMObject() {
		home_Page = new Home_Page(driver);
		mobiles_Page = new Mobiles_Page(driver);
		mobilesAccessories_Page = new MobilesAccessories_Page(driver);
		productDetails1_Page = new ProductDetails1_Page(driver);
		addtoCart_Page = new AddtoCart_Page(driver);
		gotoCart_Page = new GotoCart_Page(driver);
		signIn_Page = new SignIn_Page(driver);
	}

	@BeforeMethod()
	public void beforeMethod() {
		System.out.println("Before Method");
		driver.get("https://www.amazon.in/");

		home_Page.clickOnMobile();
		mobiles_Page.clickOnMobileAccessories();
		mobilesAccessories_Page.clickonItem2();
		productDetails1_Page.clickOnAddToCart();
	}
	
	@Test (priority = 0)
	public void verifyQtyDropDown() {
		
		System.out.println("verifyQtyDropDown");
		addtoCart_Page.clickOnGoToCart();
	
		String qtyAmountBefore = gotoCart_Page.qtyAmountBefore();
		System.out.println(qtyAmountBefore);

		gotoCart_Page.clickOnQuantity();
		
		String qtyAmountAfter = gotoCart_Page.qtyAmountAfter();
		System.out.println(qtyAmountAfter);

//		int j=Integer.parseInt(qtyAmountAfter);
//		System.out.println(j);
//		if(i<j)
//		{
//			System.out.println("Pass");
//		}
//		
//		else
//		{
//			System.out.println("Fail");
//		}
	}
	
	
	@Test (priority = 1)
	public void verifyProceedToBuyFunctionality() {
		System.out.println("verifyProceedToBuyFunctionality");
		addtoCart_Page.clickOnGoToCart();
		gotoCart_Page.clickOnProceedToBuy();
		
		String exp = "https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=amazon_checkout_in&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fbuy%2Fsignin%2Fhandlers%2Fcontinue.html%3Fie%3DUTF8%26brandId%3D%26cartItemIds%3D%26eGCApp%3D%26hasWorkingJavascript%3D0%26isEGCOrder%3D0%26isFresh%3D%26oldCustomerId%3D0%26oldPurchaseId%3D%26preInitiateCustomerId%3D%26purchaseInProgress%3D%26ref_%3Dcart_signin_submit%26siteDesign%3D&pageId=amazon_checkout_in&showRmrMe=0&siteState=isRegularCheckout.1%7CIMBMsgs.%7CisRedirect.1&suppressSignInRadioButtons=0";
		String act =  signIn_Page.getUrl();
		
		Assert.assertEquals(act, exp);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void clearObjects() {
		System.out.println("After Class");
		home_Page = null;
		mobiles_Page = null;
		mobilesAccessories_Page = null;
		productDetails1_Page = null;
		addtoCart_Page = null;
		gotoCart_Page = null;
		signIn_Page = null;
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
		driver = null;
		System.gc();
	}
	
}
