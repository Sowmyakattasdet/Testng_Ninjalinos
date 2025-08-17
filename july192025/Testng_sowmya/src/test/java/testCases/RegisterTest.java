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
import utils.Dataprovider;
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
	 private String actualmessage;
	 private String String;
	 private Object usernameC;
	 private Object confirmpasswordC;
	 private Object passwordC;
	 private Map<java.lang.String, java.lang.String> testDat2; 
	 
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
//	 @Test(dataProvider = "validRegister",dataProviderClass=ExcelReader.class)
//	    public void validregister(String username, String password, String confirmpassword) throws IOException {
//	    	testData = ExcelReader.readExcelRow("validRegister", "Sheet1");
//	    //	Registerpf.row();
//	       Registerpf.setdatas(username, password, confirmpassword);
//	       Registerpf.clickRegisterbutton();
//	       
//	     //  String testData = Registerpf.row();
//    	   System.out.println(testData);
//    	   String actmsg = Registerpf.successfulMessage();
//   	//	System.out.println(expsuccessmsg);
//   		//System.out.println(actmsg);
//   		
//	        String expsuccessmsg = testData.get("ErrorMessage");
//	        String actualsuccessfullmessage = Loginpf.loginsuccesfullmessage();
//	  		Assert.assertEquals(expsuccessmsg, actualsuccessfullmessage, "user not able to see 'user is already registered'");
//
//	         }
	 @Test(dataProvider = "validinvalidRegister",dataProviderClass=Dataprovider.class)
	    public void validinvalidlogin(String username, String password, String confirmpassword) throws IOException {
	    	testData = ExcelReader.readExcelRow("validRegister", "Sheet1");
	    	testData1 = ExcelReader.readExcelRow("Register1", "Sheet1");
	    	testData2 = ExcelReader.readExcelRow("Register2", "Sheet1");
	    	testData3 = ExcelReader.readExcelRow("Register3", "Sheet1");
	    	testData4 = ExcelReader.readExcelRow("Register4", "Sheet1");
	    	testData5 = ExcelReader.readExcelRow("Register5", "Sheet1");
	    	
	      
		 Registerpf.setdatas(username, password, confirmpassword);
	       Registerpf.clickRegisterbutton();
	       Registerpf.username();
	      
	       String usernameA= Registerpf.username();
	       String passwordA= Registerpf.password();
	       String confirmpasswordA= Registerpf.confirmpassword();
	       String usernameB= Registerpf.username1();
	       String passwordB= Registerpf.password1();
	       String confirmpasswordB= Registerpf.confirmpassword1();
	       String usernameC= Registerpf.username2();
	       String passwordC= Registerpf.password2();
	       String confirmpasswordC= Registerpf.confirmpassword2();
	       String usernameD= Registerpf.username3();
	       String passwordD= Registerpf.password3();
	       String confirmpasswordD= Registerpf.confirmpassword3();
	       String usernameE= Registerpf.username4();
	       String passwordE= Registerpf.password4();
	       String confirmpasswordE= Registerpf.confirmpassword4();
	       String usernameF= Registerpf.username5();
	       String passwordF= Registerpf.password5();
	       String confirmpasswordF= Registerpf.confirmpassword5();
	      // System.out.println(Registerpf.username());
	       if(username.equals(usernameA))//&& password.equals(passwordA) && confirmpassword.equals(confirmpasswordA) )
	       {
	    	   String experror =testData.get("ErrorMessage");//Registerpf.Errormsg(); //
		        actualmessage = Registerpf.missmatchPasswordMessage();
		  		Assert.assertEquals(experror, actualmessage, "user not able to see 'user is already registered'");
 
	       }
	       else if(username.equals(usernameB) && password.equals(passwordB))// && confirmpassword.equals(confirmpasswordB))
	       {
	    	   String expsuccessmsg =testData1.get("ErrorMessage"); //Registerpf.Errormsg1();
		        String actualmessage = Registerpf.invalidAssertionUsernamebox();
		  		Assert.assertEquals(expsuccessmsg, actualmessage, "user not able to see 'fill out this field message'");

	       }
	       else if(username.equals(usernameC) && password.equals(passwordC) )//&& confirmpassword.equals(confirmpasswordC))
	       {
	    	   String expsuccessmsg = testData2.get("ErrorMessage");//Registerpf.Errormsg2();
		        String actualmessage =Registerpf.invalidAssertionPasswdnamebox();
		  		Assert.assertEquals(expsuccessmsg, actualmessage, "user not able to see 'fill out this field message'");

	       }
	       else if(username.equals(usernameD) && password.equals(passwordD) )//&& confirmpassword.equals(confirmpasswordD))
	       {
	    	   String expsuccessmsg =testData3.get("ErrorMessage");// Registerpf.Errormsg3();
		        String actualmessage = Registerpf.invalidAssertionUsernamebox();
		  		Assert.assertEquals(expsuccessmsg, actualmessage, "user not able to see 'fill out this field message'");

	       }
	       else if(username.equals(usernameE) && password.equals(passwordE) )//&& confirmpassword.equals(confirmpasswordE))
	       {
	    	   String expsuccessmsg = testData4.get("ErrorMessage");//Registerpf.Errormsg4();
		        String actualmessage = Registerpf.invalidAssertionconfirmpswdbox();
		  		Assert.assertEquals(expsuccessmsg, actualmessage, "user not able to see 'fill out this field message'");

	       }
	       else if(username.equals(usernameF) &&  confirmpassword.equals(confirmpasswordF))
	       {
	    	   String expsuccessmsg = testData5.get("ErrorMessage");//Registerpf.Errormsg5();
		        String actualmessage =  Registerpf.missmatchPasswordMessage();
		  		Assert.assertEquals(expsuccessmsg, actualmessage, "user not able to see 'fill out this field message'");

	       }
	       

	         }


	 }
	 
	 
	 
	 
	 
	 
	 

