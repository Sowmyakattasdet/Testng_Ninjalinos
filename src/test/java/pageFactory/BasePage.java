package pageFactory;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory_TestNG;
import utils.ConfigReader;

public class BasePage {
	
	private WebDriver tldriver;
	String browser;
	WebDriverWait wait;
	ConfigReader config;
	
	
	@FindBy(xpath = "//div[2]/following::*/div[2]/a")
	WebElement tryHereQueue;
	@FindBy(className = "btn")
	WebElement launchBtn;

	@FindBy(xpath = "//*[text()='Sign in']")
	WebElement signinBtn;

	@FindBy(id = "id_username")
	WebElement userName;

	@FindBy(id = "id_password")
	WebElement pwd;

	@FindBy(xpath = "//input[4]")
	WebElement logInBtn;

	@FindBy(xpath = "//*[text()='Sign out']")
	WebElement signOut;
	
	
	public BasePage() throws IOException {

		this.config = new ConfigReader();
		this.tldriver = DriverFactory_TestNG.getDriver();
		//this.tldriver = driver;
		PageFactory.initElements(tldriver, this);
		this.wait = new WebDriverWait(tldriver, Duration.ofSeconds(10));

	}
	
	
	
	public void launch_webpage() {
		tldriver.get(config.get_prop_value("testurl"));
		launchBtn.click();
		signinBtn.click();
		userName.sendKeys("ninjalinos@work.com");
		pwd.sendKeys("sdet218920@");
		logInBtn.click();
	}
	
	public void waitUntilPageLoads(String partialUrl) {
		wait.until(ExpectedConditions.urlContains(partialUrl));
	}

}
