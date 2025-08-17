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
		testData= ExcelReader.readExcelRow("Valid credential", "Sheet1");
		testData1 = ExcelReader.readExcelRow("Login1", "Sheet1");
		testData2 = ExcelReader.readExcelRow("Login2", "Sheet1");
		testData3 = ExcelReader.readExcelRow("Login3", "Sheet1");
		
        Loginpf.setdata(username, password);
        Loginpf.clickLoginbutton();
        
        String usernameA=Loginpf.username();
        String passwordA=Loginpf.password();
        String usernameB=Loginpf.username1();
        String passwordB=Loginpf.password1();
        String usernameC=Loginpf.username2();
        String passwordC=Loginpf.password2();
        String usernameD=Loginpf.username3();
        String passwordD=Loginpf.password3();
        String usernameE=Loginpf.username4();
        String passwordE=Loginpf.password4();
        
         if(username.equals(usernameA) && password.equals(passwordA))
         {
        	 String expsuccessmsg =testData.get("ExpectedMsg");   
        	 System.out.println( expsuccessmsg +"E");
        	 
             String actualsuccessfullmessage = Loginpf.loginsuccesfullmessage();
             System.out.println(actualsuccessfullmessage+"a");
    		Assert.assertEquals(expsuccessmsg, actualsuccessfullmessage, "user is not logged in"); 
         }
        else if(username.equals(usernameB) && password.equals(passwordB))
       {
    	   String experrormsg = testData1.get("ErrorMessage");
          	String actualerrormessage = Loginpf.invalidAssertionusernamebox();
          
          		Assert.assertEquals(experrormsg, actualerrormessage, "user is not logged in");  
       }
       else if(username.equals(usernameC) && password.equals(passwordC))
       {
    	   String experrormsg = testData2.get("ErrorMessage");
         	String actualerrormessage = Loginpf.invalidAssertiopasswordbox();
         
         		Assert.assertEquals(experrormsg, actualerrormessage, "user is not logged in");    
       }
       else if(username.equals(usernameD) && password.equals(passwordD))
       {
    	   String experrormsg = testData3.get("ErrorMessage");
        	String actualerrormessage =  Loginpf.invalidAssertionusernamebox();
        
        		Assert.assertEquals(experrormsg, actualerrormessage, "user is not logged in");    
       }
       else if(username.equals(usernameE) && password.equals(passwordE))
       {
    	   String experrormsg = testData4.get("ErrorMessage");
    	   String acterrormsg = Loginpf.invaliddatamessage();
   		Assert.assertEquals(experrormsg, acterrormsg, "user is not able to see 'please fill out this field'message");
    	   
       }
    }
    

    

    }
