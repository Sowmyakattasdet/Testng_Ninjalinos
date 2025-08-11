package testMethodsPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverFactory.DriverFactory;
import pageFactory.HomePage;
import pageFactory.LaunchPage;
import pageFactory.LoginPage;
import utils.ExcelReaderTestNg;

public class LoginTest {
  //  WebDriver driver;
	public  WebDriver driver;
	LaunchPage Launchpf;
	 HomePage Homepf;
	 LoginPage Loginpf;
	 
	 @BeforeMethod
		@Parameters("browser")
		public void setup(@Optional("chrome") String browser) throws IOException, InterruptedException {
				DriverFactory driverFact = new DriverFactory();
			driverFact.initDriver(browser);
		 Launchpf = new LaunchPage();
		 Homepf =new HomePage();
		 Loginpf =new LoginPage();
			Launchpf.loadurl();
			Launchpf.clickgetstarted();
		}
			 
	
    @Test(dataProvider = "validlogin",dataProviderClass=ExcelReaderTestNg.class)
    public void validlogin(String username, String password) {
        Loginpf.clickSigninLink();
        Loginpf.setdata(username, password);
        Loginpf.clickLoginbutton();
         }
//    @Test(dataProvider = "invalidlogin1",dataProviderClass=ExcelReaderTestNg.class)
//    public void invalidlogin1(String username, String password) {
//        Loginpf.clickSigninLink();
//        Loginpf.setdata(username, password);
//        Loginpf.clickLoginbutton();
//         }
//
//    @DataProvider(name="validlogin")
//    public String[][] logindata() {
//         String data[][] ={
//            {"ninjalinos@work.com", "sdet218920@"}
//        };
//        return data;
//    }
    
    

    }
