package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import driverFactory.DriverFactory_TestNG;
import pageFactory.BasePage;


public class BaseTest {
	
	
	
		
	@Parameters({"browser"})	
	@BeforeMethod
	public void open_website(String br) throws IOException {
		DriverFactory_TestNG df = new DriverFactory_TestNG();
		df.init_browser(br);
		BasePage base;
		base = new BasePage();
		base.launch_webpage();
		
	}
		
	
	@AfterMethod
	public void teardownDriver() {
		DriverFactory_TestNG.tear_driver();

	}

}
