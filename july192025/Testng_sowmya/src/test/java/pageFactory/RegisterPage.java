package pageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory_TestNG;
import utils.ExcelReader;



public class RegisterPage {

	 WebDriver driver;
	 JavascriptExecutor js;

		public RegisterPage()
		{
			this.driver = DriverFactory_TestNG.getdriver();//initialize the driver
			PageFactory.initElements(driver, this); //page factory initiate element
			js = (JavascriptExecutor) driver;

		}
	// Locators

	@FindBy(xpath = "//*[@name='username']")
	WebElement usernameTextbox;

	@FindBy(xpath = "//*[@name='password1']")
	WebElement passwordTextbox;

	@FindBy(xpath = "//*[@name='password2']")
	WebElement confirmpasswordTextbox;

	@FindBy(xpath = "//*[@value='Register']")
	WebElement registerButton;

	@FindBy(xpath = "//div[@class=\"alert alert-primary\"]")
	WebElement missmatchPasswordMessage;
	private Map<String, String> testData;
	private String username;
	private String password;
	private String confirmpassword;
	private Map<String, String> testData1;
	private String username1;
	private String password1;
	private String confirmpassword1;
	private String Errormessage;
	private String Errormessage1;
	private Map<String, String> testData2;
	private String Errormessage2;
	private String confirmpassword2;
	private String password2;
	private String username2;
	private Map<String, String> testData3;
	private String username3;
	private String confirmpassword3;
	private String password3;
	private String Errormessage3;
	private Map<String, String> testData4;
	private String username4;
	private String password4;
	private String confirmpassword4;
	private String Errormessage4;
	private Map<String, String> testData5;
	private String Errormessage5;
	private String confirmpassword5;
	private String password5;
	private String username5;

	

//action methods

//	public void setusername(String username) {
//		usernameTextbox.sendKeys("ninjalinos@work.com");
//	}

	public void setinvalidusername(String username) {
		usernameTextbox.sendKeys(username);
	}
	public void setdatas(String username,String password,String confirmpassword) {
		usernameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		confirmpasswordTextbox.sendKeys(confirmpassword);
	}
		
	public void setinvalidpassword(String password) {
		passwordTextbox.sendKeys(password);
	}

	public void setinvalidconfirmpassword(String confirmpassword) {
		confirmpasswordTextbox.sendKeys(confirmpassword);
	}

	public void setpassword(String password) {
		passwordTextbox.sendKeys("sdet218920@");
	}

	public void setconfirmpassword(String confirmpassword) {
		confirmpasswordTextbox.sendKeys("sdet218920@");
	}

	public void clickRegisterbutton() {
		registerButton.click();
	}

	public String missmatchPasswordMessage() {
		String msg = missmatchPasswordMessage.getText();
		return msg;
	}
	
	public void testdat() {
		testData= ExcelReader.readExcelRow("validRegister", "Sheet1");
	}
	//testData
	public String username() {
		testData= ExcelReader.readExcelRow("validRegister", "Sheet1");
		username = testData.get("UserName");
		
		return username;
	}
	public String password() {
		testData= ExcelReader.readExcelRow("validRegister", "Sheet1");
		password = testData.get("Password");
		
		return password;
	}
	public String confirmpassword() {
		testData= ExcelReader.readExcelRow("validRegister", "Sheet1");
		 confirmpassword = testData.get("Confirmpassword");
		
		return confirmpassword ;
	}
	public String Errormsg() {
		testData= ExcelReader.readExcelRow("validRegister", "Sheet1");
		 Errormessage = testData.get("ErrorMessage");
		
		return Errormessage ;
	}
	//testData1
	public String username1() {
		testData1 = ExcelReader.readExcelRow("Register1", "Sheet1");
		username1 = testData1.get("UserName");
		
		return username1;
	}
	public String password1() {
		testData1 = ExcelReader.readExcelRow("Register1", "Sheet1");
		password1 = testData1.get("Password");
		
		return password1;
	}
	public String confirmpassword1() {
		testData1 = ExcelReader.readExcelRow("Register1", "Sheet1");
		 confirmpassword1 = testData1.get("Confirmpassword");
		
		return confirmpassword1 ;
	}
	public String Errormsg1() {
		testData1 = ExcelReader.readExcelRow("Register1", "Sheet1");
		 Errormessage1 = testData1.get("ErrorMessage");
		
		return Errormessage1 ;
	}
	//testData2
		public String username2() {
			testData2 = ExcelReader.readExcelRow("Register2", "Sheet1");
			username2 = testData2.get("UserName");
			
			return username2;
		}
		public String password2() {
			testData2 = ExcelReader.readExcelRow("Register2", "Sheet1");
			password2 = testData2.get("Password");
			
			return password2;
		}
		public String confirmpassword2() {
			testData2 = ExcelReader.readExcelRow("Register2", "Sheet1");
			 confirmpassword2 = testData2.get("Confirmpassword");
			
			return confirmpassword2 ;
		}
		public String Errormsg2() {
			testData2 = ExcelReader.readExcelRow("Register2", "Sheet1");
			 Errormessage2 = testData2.get("ErrorMessage");
			
			return Errormessage2 ;
		}
		//testData3
				public String username3() {
					testData3 = ExcelReader.readExcelRow("Register3", "Sheet1");
					username3 = testData3.get("UserName");
					
					return username3;
				}
				public String password3() {
					testData3 = ExcelReader.readExcelRow("Register3", "Sheet1");
					password3 = testData3.get("Password");
					
					return password3;
				}
				public String confirmpassword3() {
					testData3 = ExcelReader.readExcelRow("Register3", "Sheet1");
					 confirmpassword3 = testData3.get("Confirmpassword");
					
					return confirmpassword1 ;
				}
				public String Errormsg3() {
					testData3 = ExcelReader.readExcelRow("Register3", "Sheet1");
					 Errormessage3 = testData3.get("ErrorMessage");
					
					return Errormsg3() ;
				}
				//testData4
				public String username4() {
					testData4 = ExcelReader.readExcelRow("Register4", "Sheet1");
					username4 = testData3.get("UserName");
					
					return username4;
				}
				public String password4() {
					testData4 = ExcelReader.readExcelRow("Register4", "Sheet1");
					password4 = testData4.get("Password");
					
					return password4;
				}
				public String confirmpassword4() {
					testData4 = ExcelReader.readExcelRow("Register4", "Sheet1");
					 confirmpassword4 = testData4.get("Confirmpassword");
					
					return confirmpassword4 ;
				}
				public String Errormsg4() {
					testData4 = ExcelReader.readExcelRow("Register4", "Sheet1");
					 Errormessage4 = testData3.get("ErrorMessage");
					
					return Errormsg4() ;
				}
				//testData5
				public String username5() {
					testData5 = ExcelReader.readExcelRow("Register5", "Sheet1");
					username5 = testData5.get("UserName");
					
					return username5;
				}
				public String password5() {
					testData5 = ExcelReader.readExcelRow("Register5", "Sheet1");
					password5 = testData5.get("Password");
					
					return password5;
				}
				public String confirmpassword5() {
					testData5 = ExcelReader.readExcelRow("Register5", "Sheet1");
					 confirmpassword5 = testData5.get("Confirmpassword");
					
					return confirmpassword5 ;
				}
				public String Errormsg5() {
					testData5 = ExcelReader.readExcelRow("Register5", "Sheet1");
					 Errormessage5 = testData5.get("ErrorMessage");
					
					return Errormsg5() ;
				}
		
	
	
	
	
	
	
	public String successfulMessage() {
		String msg = missmatchPasswordMessage.getText();
		return msg;
	}

	public String invalidAssertionUsernamebox() {

		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", usernameTextbox);
		return validationMsg;
	}

	public String invalidAssertionconfirmpswdbox() {

		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;",
				confirmpasswordTextbox);
		return validationMsg;
	}

	public String invalidAssertionPasswdnamebox() {

		String validationMsg = (String) js.executeScript("return arguments[0].validationMessage;", passwordTextbox);
		return validationMsg;
	}
	

//	public void setvalidDatafromExcel() throws IOException {
//
//		String username = excelReader.getData("validlogin", 1, 0);
//		String password = excelReader.getData("validlogin", 1, 1);
//		String confirmpassword = excelReader.getData("validlogin", 1, 2);
//		usernameTextbox.sendKeys(username);
//		passwordTextbox.sendKeys(password);
//		confirmpasswordTextbox.sendKeys(confirmpassword);
//		registerButton.click();
//	}
//
//	public void setemptydatafromExcel() throws IOException {
//
//		String username = excelReader.getData("register", 1, 0);
//		String password = excelReader.getData("register", 1, 1);
//		String confirmpassword = excelReader.getData("register", 1, 2);
//		usernameTextbox.sendKeys(username);
//		passwordTextbox.sendKeys(password);
//		confirmpasswordTextbox.sendKeys(confirmpassword);
//		registerButton.click();
//	}
//
//	public void setonlyusernamefromExcel() throws IOException {
//
//		String username = excelReader.getData("register", 2, 0);
//		String password = excelReader.getData("register", 2, 1);
//		String confirmpassword = excelReader.getData("register", 2, 2);
//		usernameTextbox.sendKeys(username);
//		passwordTextbox.sendKeys(password);
//		confirmpasswordTextbox.sendKeys(confirmpassword);
//		registerButton.click();
//	}
//
//	public void setonlypasswordfromExcel() throws IOException {
//
//		String username = excelReader.getData("register", 3, 0);
//		String password = excelReader.getData("register", 3, 1);
//		String confirmpassword = excelReader.getData("register", 3, 2);
//		usernameTextbox.sendKeys(username);
//		passwordTextbox.sendKeys(password);
//		confirmpasswordTextbox.sendKeys(confirmpassword);
//		registerButton.click();
//	}
//
//	public void setwithoutconfirmpasswordfromExcel() throws IOException {
//
//		String username = excelReader.getData("register", 4, 0);
//		String password = excelReader.getData("register", 4, 1);
//		String confirmpassword = excelReader.getData("register", 4, 2);
//		usernameTextbox.sendKeys(username);
//		passwordTextbox.sendKeys(password);
//		confirmpasswordTextbox.sendKeys(confirmpassword);
//		registerButton.click();
//	}
//
//	public void setinvaliddatafromExcel() throws IOException {
//
//		String username = excelReader.getData("register", 5, 0);
//		String password = excelReader.getData("register", 5, 1);
//		String confirmpassword = excelReader.getData("register", 5, 2);
//		usernameTextbox.sendKeys(username);
//		passwordTextbox.sendKeys(password);
//		confirmpasswordTextbox.sendKeys(confirmpassword);
//		registerButton.click();
//	}

}