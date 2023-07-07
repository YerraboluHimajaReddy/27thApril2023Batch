package TestNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public final class LoginToOrangeHRM_Screenshots extends BaseClass{

	@BeforeSuite
	public void launchBrowser() throws IOException {

		browserLaunching("chrome");

		System.out.println("I am in @BeforeSuite method");
		
		takeScreenshot("AfterBowserLaunching.png");
	}

	@BeforeClass
	public void launchURL() throws IOException {

		urlLuanching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();

		System.out.println("I am in @BeforeClass method");
		
		takeScreenshot("AfterLaunchingURL.png");

	}

	@BeforeMethod
	public void wait1() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		System.out.println("I am in @BeforeMethod method");

	}

	@Test(priority = 1)
	public void enterUserName() throws IOException {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");

		System.out.println("I am in enterUserName method");

		takeScreenshot("AfterEnteringUsername.png");

	}

	@Test(priority = 2)
	public void enterPassword() throws IOException {

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		System.out.println("I am in enterpassword method");

		takeScreenshot("AfterEnteringPassword.png");

	}

	@Test(priority = 3)
	public void clickLogin() throws IOException {

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("I am in clickLogin method");

		takeScreenshot("AfterLogin.png");

	}

	@AfterMethod
	public void wait2() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		System.out.println("I am in @AfterMethod method");

	}

	@AfterSuite
	public void closeBrowser() throws IOException {

		takeScreenshot("beforeBrowserClosing.png");

		browserClosing();

		System.out.println("I am in @AfterSuite method");
	}
}
