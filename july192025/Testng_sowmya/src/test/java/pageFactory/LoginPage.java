package pageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import driverFactory.DriverFactory_TestNG;
import utils.ExcelReader;



public class LoginPage {


		
		 WebDriver driver;
		 JavascriptExecutor js;

			public LoginPage( )
			{
				this.driver = DriverFactory_TestNG.getdriver();//initialize the driver
				PageFactory.initElements(driver, this); //page factory initiate element
				js = (JavascriptExecutor) driver;

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
	public void setdata(String username,String password) {
		username_textbox.sendKeys(username);
		password_textbox.sendKeys(password);
		
		
	}

	public void setvalidDatafromExcel() throws IOException {
	Map<String, String> testData = ExcelReader.readExcelRow("validIogin", "Sheet1");
    System.out.println(testData);
	String username = testData.get("username");
	String password = testData.get("password");
		username_textbox.sendKeys(username);
		password_textbox.sendKeys(password);
		login_button.click();
	}
	public String validexcelexpsuccessmsg() {
		Map<String, String> testData = ExcelReader.readExcelRow("Valid credential", "Sheet1");
		String expsuccessmsg = testData.get("ExpectedMsg");
		return expsuccessmsg;
	}
	public String login1expErrormsg() {
		Map<String, String> testData1 = ExcelReader.readExcelRow("Login1", "Sheet1");
		String expsuccessmsg = testData1.get("ExpectedMsg");
		return expsuccessmsg;
	}
	
	public Map<String, String> testData1() {
		Map<String, String> testData1 = ExcelReader.readExcelRow("Login1", "Sheet1");
		return testData1;
	}
	



	public String invalidAssertionusernamebox() {

		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", username_textbox);
		return validationMsg;
	}

	public String invalidAssertiopasswordbox() {

		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", password_textbox);
		return validationMsg;
	}

}