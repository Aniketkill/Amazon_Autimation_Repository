package testNgPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
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
import browserSetup.Base;
import utils.Utilities;

public class TestNgSanity extends Base{

	WebDriver driver;
	Home_Page home_Page;
	Mobiles_Page mobiles_Page;
	MobilesAccessories_Page mobilesAccessories_Page;
	ProductDetails1_Page productDetails1_Page;
	AddtoCart_Page addtoCart_Page;
	GotoCart_Page gotoCart_Page;
	String testCaseId;

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
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
		driver.get("https://www.amazon.in/");
	}
	
	@Test(priority = 0)
	public void verifyScrollingOperation() throws InterruptedException {
		
		testCaseId = "T-100";
		
		System.out.println("test");
		home_Page = new Home_Page(driver);
		
		home_Page.scrollToBottom();
		Thread.sleep(2000);
		home_Page.scrollToTop();
		Thread.sleep(2000);
		home_Page.clickOnBckwdSlider();
		home_Page.clickOnBckwdSlider();
		home_Page.clickOnFrwdSlider();
		home_Page.clickOnDealsFrwdSlider();
		Thread.sleep(2000);
		
		home_Page.clickOnDealsFrwdSlider();

	}
	
	@AfterMethod
	public void failedTestCases(ITestResult result) throws IOException {
		
		
			if(ITestResult.FAILURE == result.getStatus())
			{
				Utilities.captureScreenshot(driver, testCaseId);
			}
		
	
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
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
		driver = null;
		System.gc();
	}

}
