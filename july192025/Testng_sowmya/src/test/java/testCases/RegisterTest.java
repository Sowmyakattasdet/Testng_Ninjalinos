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
	    	//testData = ExcelReader.readExcelRow("validRegister", "Sheet1");
	       Registerpf.setdatas(username, password, confirmpassword);
	       Registerpf.clickRegisterbutton();
//	        String expsuccessmsg = testData.get("ExpectedMsg");
//	         String actualsuccessfullmessage = Loginpf.loginsuccesfullmessage();
//			Assert.assertEquals(expsuccessmsg, actualsuccessfullmessage, "user is not logged in");

	         }
	 @Test(dataProvider = "invalidRegister",dataProviderClass=ExcelReader.class)
	    public void invalidlogin(String username, String password, String confirmpassword) throws IOException {
	    //	testData1 = ExcelReader.readExcelRow("Login1", "Sheet1");
	    	//  testData2 = ExcelReader.readExcelRow("Login2", "Sheet1");
	      
		 Registerpf.setdatas(username, password, confirmpassword);
	       Registerpf.clickRegisterbutton();
//	        String experrormsg = testData1.get("ErrorMessage");
//	       	String actualerrormessage = Loginpf.invalidAssertionusernamebox();
//	       
//	       		Assert.assertEquals(experrormsg, actualerrormessage, "user is not logged in");
	       

	         }
	 
	 
	 
	 
	 
	 
	 
}
