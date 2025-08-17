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
	private Map<String, String> testData;
	private String username;
	private String password;
	private Map<String, String> testData1;
	private String username1;
	private String password1;
	private Map<String, String> testData2;
	private String username2;
	private String password2;
	private Map<String, String> testData3;
	private String username3;
	private String password3;
	private Map<String, String> testData4;
	private String username4;
	private String password4;



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
	
	//testData
		public String username() {
			testData  = ExcelReader.readExcelRow("Valid credential", "Sheet1");
			username = testData.get("UserName");
			
			return username;
		}
		public String password() {
			testData  = ExcelReader.readExcelRow("Valid credential", "Sheet1");
			password = testData.get("Password");
			
			return password;
		}
		//testData1
				public String username1() {
					testData1 = ExcelReader.readExcelRow("Login1", "Sheet1");
					username1 = testData.get("UserName");
					
					return username1;
				}
				public String password1() {
					testData1 = ExcelReader.readExcelRow("Login1", "Sheet1");
					password1 = testData.get("Password");
					
					return password1;
				}
				
				//testData2
				public String username2() {
					testData2 = ExcelReader.readExcelRow("Login2", "Sheet1");
					username2 = testData.get("UserName");
					
					return username2;
				}
				public String password2() {
					testData2 = ExcelReader.readExcelRow("Login2", "Sheet1");
					password2 = testData.get("Password");
					
					return password2;
				}
				//testData3
				public String username3() {
					testData3 = ExcelReader.readExcelRow("Login3", "Sheet1");
					username3 = testData.get("UserName");
					
					return username3;
				}
				public String password3() {
					testData3 = ExcelReader.readExcelRow("Login3", "Sheet1");
					password3 = testData.get("Password");
					
					return password3;
				}
				//testData4
				public String username4() {
					testData4 = ExcelReader.readExcelRow("Login4", "Sheet1");
					username4 = testData.get("UserName");
					
					return username4;
				}
				public String password4() {
					testData4 = ExcelReader.readExcelRow("Login4", "Sheet1");
					password4 = testData.get("Password");
					
					return password4;
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