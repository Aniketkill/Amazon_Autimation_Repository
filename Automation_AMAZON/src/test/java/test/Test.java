package test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Page.AddtoCart_Page;
import Page.GotoCart_Page;
import Page.Home_Page;
import Page.MobilesAccessories_Page;
import Page.Mobiles_Page;
import Page.ProductDetails1_Page;
import Page.SignIn_Page;

public class Test {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "A:\\Velocity\\Automation Testing\\SELENIUM\\chromedriver_win32 (1)\\chromedriver.exe");
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS); //-->IMPLICIT WAIT
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//Home page Operation
		Home_Page home_Page = new Home_Page(driver);
		
		home_Page.scroll(); //scroll down operation
		home_Page.scrollToBottom(); //Scroll till bottom 
		home_Page.scrollToTop(); //scroll to top of page
		home_Page.clickOnBckwdSlider(); //to click on previous slider
		home_Page.clickOnBckwdSlider(); //to click on previous slider
		home_Page.clickOnFrwdSlider(); //to click on next slider
		home_Page.clickOnDealsFrwdSlider(); //To scroll till daily deals task bar and click on next slider
		home_Page.scrollToTop();//scroll till top of page
		home_Page.clickOnMobile();//to select mobile option from top task bar
		
		
		//Mobile Page Operation
		Mobiles_Page mobiles_Page = new Mobiles_Page(driver);
		mobiles_Page.clickOnMobileAccessories(); //to select mobile accessories option
		
		
		//Mobile Accessories Page Operation
		MobilesAccessories_Page mobilesAccessories_Page= new MobilesAccessories_Page(driver);
		mobilesAccessories_Page.clickonItem1(); //to select an item1

		
		//Product Details Page Operation
		ProductDetails1_Page productDetails1_Page = new ProductDetails1_Page(driver);
		productDetails1_Page.clickOnImage().clickOnCloseOption();//click on image using mouse action
		//productDetails1_Page.clickOnCloseOption();//to close hidden division pop-up
	
		driver.navigate().back();//now we have to click on back button to go back to MobilesAccessories_Page
		
		//Mobile Accessories Page Operation
		mobilesAccessories_Page.clickonItem2();//to select an item2
		
		//Product Details Page Operation
		//productDetails1_Page.clickOnImage().clickOnCloseOption();//click on image using mouse action
		//productDetails1_Page.clickOnCloseOption();//to close hidden division pop-up
		productDetails1_Page.clickOnAddToCart();//to click on go to cart
		
		//Add to Cart Page Operation
		AddtoCart_Page addtoCart_Page = new AddtoCart_Page(driver);
		addtoCart_Page.clickOnGoToCart(); //click on go to cart option
		
		//Go to Cart Page Operation
		GotoCart_Page gotoCart_Page = new GotoCart_Page(driver);

		gotoCart_Page.clickOnQuantity(); //Select Quantity
		gotoCart_Page.clickOnProceedToBuy(); //Select Proceed to buy
		
		//Sign In Page Operation
		SignIn_Page signIn_Page = new SignIn_Page(driver);
		
		signIn_Page.sendMobileNumber("8108965079");//Enter email/phone number
		//signIn_Page.clickOnContinue();//to continue
		signIn_Page.clickOnGetOTP();//To click on get OTP
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter OTP");
		String s1 = s.nextLine();
		
		signIn_Page.enterOTP(s1);
		
		
		
		
		//to close window
		//driver.close();
	}
}
