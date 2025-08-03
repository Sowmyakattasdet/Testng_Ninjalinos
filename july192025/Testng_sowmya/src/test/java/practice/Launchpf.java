package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//import driverManager.Passing_Driver;

public class Launchpf {
	
 WebDriver driver;

	Launchpf(WebDriver driver )
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
//
//	private WebDriver driver;
//	Actions action;
//	String browser;
//	WebDriverWait wait;
//	CommonMethod cmnMethod;

	@FindBy(xpath = "//*[text()='You are at the right place']")
	WebElement message;

	@FindBy(xpath = "//*[text()='Get Started']")

	WebElement btn_getstarted;

	@FindBy(xpath = "//*[text()='NumpyNinja']")
	WebElement numpyNinja;

//	public Launchpf(Passing_Driver passdr) throws IOException {

//		this.driver = passdr.getDriver();
//		this.action = new Actions(driver);
//		PageFactory.initElements(driver, this);
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		this.cmnMethod = new CommonMethod(passdr);
//
//	}

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

//	public void geturl() {
//		cmnMethod.get_testUrl();
//
//	}

	public String gettextmsg() {
		String text = message.getText();
		return text;
	}

	public String gettitle() {
		String title = driver.getTitle();
		return title;
	}

}