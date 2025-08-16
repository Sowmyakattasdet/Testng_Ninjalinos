package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverFactory.DriverFactory_TestNG;
import pageFactory.HomePage;
import pageFactory.LaunchPage;
import pageFactory.LoginPage;
import utils.Dataprovider;
import utils.ExcelReader;

public class LoginTest {
 
	LaunchPage Launchpf;
	 HomePage Homepf;
	 LoginPage Loginpf;
	 private Map<String, String> testData;
	 private Map<String, String> testData1;
	 private Map<String, String> testData2;
	 private Map<String, String> testData3;
	 private Map<String, String> testData4;
	 
	 @BeforeMethod
		@Parameters("browser")
		public void setup(@Optional("chrome") String browser) throws IOException, InterruptedException {
				DriverFactory_TestNG driverFact = new DriverFactory_TestNG();
			driverFact.init_browser(browser);
		 Launchpf = new LaunchPage();
		 Homepf =new HomePage();
		 Loginpf =new LoginPage();
		 Launchpf.get_testUrl();
			Launchpf.clickgetstarted();
			  Loginpf.clickSigninLink();
		}

    @Test(dataProvider = "validandinvalidlogin",dataProviderClass=Dataprovider.class)
    public void validandinvalidlogin(String username, String password) throws IOException {
  
        Loginpf.setdata(username, password);
        Loginpf.clickLoginbutton();
         if(testData  == ExcelReader.readExcelRow("Valid credential", "Sheet1"))
         {
        	 String expsuccessmsg = Loginpf.validexcelexpsuccessmsg();
             String actualsuccessfullmessage = Loginpf.loginsuccesfullmessage();
    		Assert.assertEquals(expsuccessmsg, actualsuccessfullmessage, "user is not logged in"); 
         }
        else if(testData1  == ExcelReader.readExcelRow("Login1", "Sheet1"))
       {
    	   String experrormsg = testData1.get("ErrorMessage");
          	String actualerrormessage = Loginpf.invalidAssertionusernamebox();
          
          		Assert.assertEquals(experrormsg, actualerrormessage, "user is not logged in");  
       }
       else if(testData2 == ExcelReader.readExcelRow("Login2", "Sheet1"))
       {
    	   String experrormsg = testData2.get("ErrorMessage");
         	String actualerrormessage = Loginpf.invalidAssertiopasswordbox();
         
         		Assert.assertEquals(experrormsg, actualerrormessage, "user is not logged in");    
       }
       else if(testData3 == ExcelReader.readExcelRow("Login2", "Sheet1"))
       {
    	   String experrormsg = testData3.get("ErrorMessage");
        	String actualerrormessage =  Loginpf.invalidAssertionusernamebox();
        
        		Assert.assertEquals(experrormsg, actualerrormessage, "user is not logged in");    
       }
       else if(testData4 == ExcelReader.readExcelRow("Login2", "Sheet1"))
       {
    	   String experrormsg = testData3.get("ErrorMessage");
    	   String acterrormsg = Loginpf.invaliddatamessage();
   		Assert.assertEquals(experrormsg, acterrormsg, "user is not able to see 'please fill out this field'message");
    	   
       }
    }
    

    

    }
