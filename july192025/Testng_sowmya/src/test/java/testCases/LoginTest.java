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
import utils.ExcelReader;

public class LoginTest {
  //  WebDriver driver;
	public  WebDriver driver;
	LaunchPage Launchpf;
	 HomePage Homepf;
	 LoginPage Loginpf;
	 private Map<String, String> testData;
	 
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
		}
			 
	
//    @Test//(dataProvider = "validlogin",dataProviderClass=ExcelReader.class)
//    public void validlogin() throws IOException {//(String username, String password) {
//        Loginpf.clickSigninLink();
//        Loginpf.setvalidDatafromExcel();
//        Loginpf.setdata(null, null);
//        Loginpf.clickLoginbutton();
//        testData = ExcelReader.readExcelRow("validIogin", "Sheet1");
//        System.out.println(testData);
//    	String username = testData.get("username");
//		System.out.println(username);
 //        }
    @Test(dataProvider = "validlogin",dataProviderClass=ExcelReader.class)
    public void validlogin(String username, String password) throws IOException {
        Loginpf.clickSigninLink();
        Loginpf.setdata(username, password);
        Loginpf.clickLoginbutton();
//        String expsuccessmsg="You are logged in";
//        String actualsuccessfullmessage = Loginpf.loginsuccesfullmessage();
//		Assert.assertEquals(expsuccessmsg, actualsuccessfullmessage, "user is not logged in");

         }
//
//    @DataProvider(name="validlogin")
//    public String[][] logindata() {
//         String data[][] ={
//            {"ninjalinos@work.com", "sdet218920@"}
//        };
//        return data;
//    }
    
    

    }
