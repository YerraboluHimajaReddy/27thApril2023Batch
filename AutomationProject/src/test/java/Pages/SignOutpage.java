package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignOutpage {

	WebDriver driver;

	public SignOutpage(WebDriver driver) {

		this.driver = driver;
	}

	// 2nd way

	@CacheLookup
	@FindBy(xpath  = "//a[text()='About']")
	private WebElement about_Button;
	
	@FindBy(xpath  = "//a[text()='Support']")
	private WebElement support_Button;
	
	@FindBy(xpath  = "//a[text()='Change Password']")
	private WebElement changePassword_Button;
	
	@FindBy(xpath  = "//a[text()='Logout']")
	private WebElement logout_Button;

	public void clickLogout() {

		logout_Button.click();
	}

	public void clickChangePassword() {

		changePassword_Button.click();
	}

	public void clickSupport() {

		support_Button.click();
	}	

	public void clickAbout() {

		about_Button.click();
	}

}
