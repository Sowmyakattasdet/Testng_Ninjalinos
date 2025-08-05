package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//import driverManager.Passing_Driver;
//import utils.ExcelReaderFile;

public class LoginPage {

//	private WebDriver driver;
//	Actions action;
//	String browser;
//	WebDriverWait wait;
//	//ExcelReaderFile excelReader;
//	JavascriptExecutor js;
//	public class LaunchPage {
		
		 WebDriver driver;

			public LoginPage(WebDriver driver )
			{
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}

	@FindBy(xpath = "//*[text()='Sign in']")
	WebElement signinLink;

	@FindBy(xpath = "//*[@name='username']")
	WebElement username_textbox;

	@FindBy(xpath = "//*[@name='password']")
	WebElement password_textbox;

	@FindBy(xpath = "//*[@value=\"Login\"]")
	WebElement login_button;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement loginsuccesfullmessage;

	@FindBy(xpath = "//div[@role='alert'] ")
	WebElement invaliddatamsg;

//	public LoginPage(Passing_Driver passdr) throws IOException {
//
//		this.driver = passdr.getDriver();
//		this.action = new Actions(driver);
//		PageFactory.initElements(driver, this);
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		this.excelReader = new ExcelReaderFile();
//		js = (JavascriptExecutor) driver;
//
//	}

	public void clickSigninLink() {
		signinLink.click();
	}

	public void clickLoginbutton() {
		login_button.click();
	}

	public String loginsuccesfullmessage() {
		String msg = loginsuccesfullmessage.getText();
		return msg;
	}

	public String invaliddatamessage() {
		String msg = invaliddatamsg.getText();
		return msg;
	}

//	public void setvalidDatafromExcel() throws IOException {
//
//		String username = excelReader.getData("validlogin", 1, 0);
//		String password = excelReader.getData("validlogin", 1, 1);
//		username_textbox.sendKeys(username);
//		password_textbox.sendKeys(password);
//		login_button.click();
//	}
//
//	public void setDatafromExcelwithemptyfields() throws IOException {
//
//		String username = excelReader.getData("login", 1, 0);
//		String password = excelReader.getData("login", 1, 1);
//		username_textbox.sendKeys(username);
//		password_textbox.sendKeys(password);
//		login_button.click();
//	}
//
//	public void setDatafromExcelwithusernameNoPassword() throws IOException {
//
//		String username = excelReader.getData("login", 2, 0);
//		String password = excelReader.getData("login", 2, 1);
//		username_textbox.sendKeys(username);
//		password_textbox.sendKeys(password);
//		login_button.click();
//	}

//	public void setDatafromExcelwithPasswordnousername() throws IOException {
//
//		String username = excelReader.getData("login", 3, 0);
//		String password = excelReader.getData("login", 3, 1);
//		username_textbox.sendKeys(username);
//		password_textbox.sendKeys(password);
//		login_button.click();
//	}
//
//	public void setDatafromExcelinvalidData() throws IOException {
//
//		String username = excelReader.getData("login", 4, 0);
//		String password = excelReader.getData("login", 4, 1);
//		username_textbox.sendKeys(username);
//		password_textbox.sendKeys(password);
//		login_button.click();
//	}

//	public String invalidAssertionusernamebox() {
//
//		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", username_textbox);
//		return validationMsg;
//	}
//
//	public String invalidAssertiopasswordbox() {
//
//		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", password_textbox);
//		return validationMsg;
//	}

}