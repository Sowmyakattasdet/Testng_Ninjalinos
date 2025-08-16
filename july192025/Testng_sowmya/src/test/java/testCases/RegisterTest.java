package testCases;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverFactory.DriverFactory_TestNG;
import pageFactory.HomePage;
import pageFactory.LaunchPage;
import pageFactory.LoginPage;
import pageFactory.RegisterPage;
import utils.ExcelReader;

public class RegisterTest {
	LaunchPage Launchpf;
	 HomePage Homepf;
	 LoginPage Loginpf;
	 RegisterPage Registerpf;
	 private Map<String, String> testData;
	 private Map<String, String> testData1;
	 private Map<String, String> testData2;
	 private Map<String, String> testData3;
	 private Map<String, String> testData4;
	 private Map<String, String> testData5; 
	 
	 @BeforeMethod
		@Parameters("browser")
		public void setup(@Optional("chrome") String browser) throws IOException, InterruptedException {
				DriverFactory_TestNG driverFact = new DriverFactory_TestNG();
			driverFact.init_browser(browser);
		 Launchpf = new LaunchPage();
		 Homepf =new HomePage();
		 Loginpf =new LoginPage();
		 Registerpf =new RegisterPage();
		 Launchpf.get_testUrl();
			Launchpf.clickgetstarted();
			Homepf.clickRegister();
		}
	 @Test(dataProvider = "validRegister",dataProviderClass=ExcelReader.class)
	    public void validregister(String username, String password, String confirmpassword) throws IOException {
	    	testData = ExcelReader.readExcelRow("validRegister", "Sheet1");
	       Registerpf.setdatas(username, password, confirmpassword);
	       Registerpf.clickRegisterbutton();
	       String expsuccessmsg = testData.get("ErrorMessage");
    	   
    	   String actmsg = Registerpf.successfulMessage();
   		System.out.println(expsuccessmsg);
   		System.out.println(actmsg);
   		Assert.assertEquals(actmsg, expsuccessmsg , "user not able to see 'user is already registered'");
//	        String expsuccessmsg = testData.get("ErrorMessage");
//	        String actualsuccessfullmessage = Loginpf.loginsuccesfullmessage();
//	  		Assert.assertEquals(expsuccessmsg, actualsuccessfullmessage, "user not able to see 'user is already registered'");

	         }
	 @Test(dataProvider = "validinvalidRegister",dataProviderClass=ExcelReader.class)
	    public void validinvalidlogin(String username, String password, String confirmpassword) throws IOException {
	    	//testData = ExcelReader.readExcelRow("validRegister", "Sheet1");
	    	//  testData2 = ExcelReader.readExcelRow("Login2", "Sheet1");
	      
		 Registerpf.setdatas(username, password, confirmpassword);
	       Registerpf.clickRegisterbutton();
	       if(testData== ExcelReader.readExcelRow("validRegister", "Sheet1"))
	         {
	    	   String expsuccessmsg = testData.get("ErrorMessage");
	    	   
	    	   String actmsg = Registerpf.successfulMessage();
	   		System.out.println(expsuccessmsg);
	   		System.out.println(actmsg);
	   		Assert.assertEquals(actmsg, expsuccessmsg , "user not able to see 'user is already registered'");
	   	
         }
	       
	        else if(testData1==ExcelReader.readExcelRow("Register1", "Sheet1"))
	       {
	    	   String experrormsg = testData1.get("ErrorMessage");
	    	   String acterrormsg = Registerpf.invalidAssertionUsernamebox();
	   		Assert.assertEquals(acterrormsg, experrormsg, "user is not able to see 'please fill out this field'message");  
	       }
//	       else if(testData2 == ExcelReader.readExcelRow("Register2", "Sheet1"))
//	       {
//	    	   String experrormsg = testData2.get("ErrorMessage");
//	    	   String acterrmsg = Registerpf.invalidAssertionPasswdnamebox();
//	   		Assert.assertEquals(acterrmsg,  experrormsg, "user is not able to see 'please fill out this field'message");  
//	       }
//	       else if(testData3 == ExcelReader.readExcelRow("Register3", "Sheet1"))
//	       {
//	    	   String experrormsg = testData3.get("ErrorMessage");
//	    	   String acterrormsg = Registerpf.invalidAssertionUsernamebox();
//	   		Assert.assertEquals(acterrormsg, experrormsg, "user is not able to see 'please fill out this field'message");   
//	       }
//	       else if(testData4 == ExcelReader.readExcelRow("Register4", "Sheet1"))
//	       {
//	    	   String experrormsg = testData3.get("ErrorMessage");
//	    	   String acterrormsg = Registerpf.invalidAssertionconfirmpswdbox();
//	   		Assert.assertEquals(experrormsg, acterrormsg, "user is not able to see 'please fill out this field'message");
//	    	   
//	       }
//	       else if(testData5 == ExcelReader.readExcelRow("Register5", "Sheet1"))
//	       {
//	    	   String experrormsg = testData3.get("ErrorMessage");
//	    	   String actermsg = Registerpf.invalidAssertionconfirmpswdbox();
//	   		Assert.assertEquals(actermsg, experrormsg, "user is not able to see 'please fill out this field'message");
//	       }

	         }
	 private Object readExcelRow(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	 }
	 
	 
	 
	 
	 
	 
	 
}
