package testMethodsPackage;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;

import driverFactory.DriverFactory;
import pageObjects.BasePage;
import utils.ExcelReaderTestNg;


@Listeners(ChainTestListener.class)
public class BaseTest {
	
	
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) throws IOException, InterruptedException {
		DriverFactory driverFact = new DriverFactory();
		driverFact.initDriver(browser);//initialize the driver
		BasePage basePg = new BasePage();
	     basePg.loadurl();
	     basePg.clickGetStart();
	     basePg.clickSignIn();
	     ExcelReaderTestNg exclReader = new ExcelReaderTestNg();
	     String uname= exclReader.getcellData(1, "Username");
		 basePg.setUserName(uname);
		 String pword= exclReader.getcellData(1, "Password");
		 basePg.setPassword(pword);
		 basePg.clickLogin();
	}
	
	
	public void failed_screenshot() {}
	
	
	
	   @AfterMethod
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }

}
