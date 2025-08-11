package pageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import driverFactory.DriverFactory;
import utils.ConfigReaderTest;

public class LaunchPage {
	
 WebDriver driver;
 ConfigReaderTest config;



	public LaunchPage()
	{
		this.driver = DriverFactory.getdriver();//initialize the driver
		PageFactory.initElements(driver, this); //page factory initiate element
		
		
	}
	


	@FindBy(xpath = "//*[text()='You are at the right place']")
	WebElement message;

	@FindBy(xpath = "//*[text()='Get Started']")

	WebElement btn_getstarted;

	@FindBy(xpath = "//*[text()='NumpyNinja']")
	WebElement numpyNinja;



	public void clickgetstarted() {
		btn_getstarted.click();
	}

	public void numpyNinja() {
		numpyNinja.isDisplayed();

	}
	public void geturl()
	{
	driver.get("https://dsportalapp.herokuapp.com/");
		
		
	}

	public void loadurl() throws IOException {
		config = new ConfigReaderTest();
		Properties prop = config.readConfig();
		String url = prop.getProperty("testurl");
		driver.get(url);
	}

	public String gettextmsg() {
		String text = message.getText();
		return text;
	}

	public String gettitle() {
		String title = driver.getTitle();
		return title;
	}
 public  void quitdriver()
 {
	 driver.quit();
 }
}