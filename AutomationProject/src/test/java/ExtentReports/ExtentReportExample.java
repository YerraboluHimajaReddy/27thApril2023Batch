package ExtentReports;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;

public class ExtentReportExample extends Common.BaseClass{

	LoginPage lp;

	public static ExtentReports report;

	public static ExtentTest test;

	@BeforeSuite
	public void startTest() {

		report = new ExtentReports(System.getProperty("user.dir") + "\\testing1.html");

		test = report.startTest("OrangeHRM");
		
	}
	

	@BeforeSuite
	public void launchBrowser() {

		browserLaunching("Chrome");
		
		lp = new LoginPage(driver);

		System.out.println("i am in @BeforeSuite method");
	}
	
	@BeforeClass
	public void launcURL() {

		urlLuanching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println("i am in @BeforeClass method");
	}

	@BeforeMethod
	public void maximizeBrowser() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

		driver.manage().window().maximize();

		System.out.println("i am in @BeforeMethod method");

	}
	
	@Test(priority = 1)
	public void loginToOrangeHRM() {

		lp.enterUsername();

		lp.enterPassword("admin123");

		lp.clickLogin();


		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("OrangeHRM")) {

			test.log(LogStatus.PASS, "Title is same");

		} else {

			test.log(LogStatus.FAIL, "Title is not same");

		}

	}

	@Test(priority = 2)
	public void clickLogout() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		System.out.println(driver.getTitle());

		String expected = "Testing";

		String actual = driver.getTitle();

		if (actual.equalsIgnoreCase(expected)) {

			test.log(LogStatus.PASS, "Title is same : " + actual);

		} else {

			test.log(LogStatus.FAIL, "Title is not same " + expected + " and " + actual);

		}
	}

	@AfterClass
	public void endTest() {

		report.endTest(test);

		report.flush();
	}

	@AfterSuite
	public void closeBrowser() {

		driver.quit();
	}

}
