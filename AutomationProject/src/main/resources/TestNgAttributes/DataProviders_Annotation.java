package TestNgAttributes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestNG.BaseClass;

public class DataProviders_Annotation extends BaseClass {

	@BeforeSuite
	public void launchBrowser() {

		browserLaunching("chrome");

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
	
	@DataProvider(name = "OrangeHRMCredentails")
	public Object[][] getData(){
		
		Object[][] values = new Object[3][2];
		
		values[0][0] = "lakshmi@gmail.com";
		values[0][1] = "lakshmi";
		
		values[1][0] = "narendra@gmail.com";
		values[1][1] = "narendra";
		
		values[2][0] = "Hareesh@gmail.com";
		values[2][1] = "hareesh";
		
		return values;
	}
	

	@Test(dataProvider = "OrangeHRMCredentails")
	public void enterCredntails(String username, String password) {

		driver.findElement(By.xpath("//input[@name='username']")).clear();
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		
		driver.findElement(By.xpath("//input[@name='password']")).clear();

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

		System.out.println("I am in enterCredntails method");

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
