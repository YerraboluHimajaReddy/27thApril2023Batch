package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignOutpage;

public class LoginAndLogoutTest extends BaseClass{
	
	LoginPage lp;
	
	HomePage hp;
	
	SignOutpage sp;

	@BeforeSuite
	public void launchBrowser() {

		browserLaunching("chrome");
		
		// Page object model
		
		lp = new LoginPage(driver);
		
		//page factory
		
		hp = PageFactory.initElements(driver, HomePage.class);
		
		sp = PageFactory.initElements(driver, SignOutpage.class);

		System.out.println("I am in @BeforeSuite method");
	}

	@BeforeClass
	public void launchURL() {

		urlLuanching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();

		System.out.println("I am in @BeforeClass method");

	}

	@BeforeMethod
	public void wait1() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		System.out.println("I am in @BeforeMethod method");

	}

	@Test(priority = 1)
	public void enterUserName() {

		lp.enterUsername();

		System.out.println("I am in enterUserName method");

	}

	@Test(priority = 2)
	public void enterPassword() {

		lp.enterPassword("admin123");

		System.out.println("I am in enterpassword method");

	}

	@Test(priority = 3)
	public void clickLogin() {

		lp.clickLogin();
		
		System.out.println("I am in clickLogin method");

	}
	
	@Test(priority = 4)
	public void clickLoginLink() {

		hp.clickLogoutLink();
		
		System.out.println("I am in clickLoginLink method");

	}
	
	@Test(priority = 5)
	public void clickSignoutLink() {

		sp.clickLogout();
		
		System.out.println("I am in clickSignoutLink method");

	}

	@AfterMethod
	public void wait2() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		System.out.println("I am in @AfterMethod method");

	}

	@AfterSuite
	public void closeBrowser() {

		browserClosing();

		System.out.println("I am in @AfterSuite method");
	}
}
