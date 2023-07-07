package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Common.BaseClass;
import Pages.LoginPage;

public class LoginTest_Himaja extends BaseClass{
	
	LoginPage lp;

	@BeforeSuite
	public void launchBrowser() {

		browserLaunching("chrome");
		
		lp = new LoginPage(driver);

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
