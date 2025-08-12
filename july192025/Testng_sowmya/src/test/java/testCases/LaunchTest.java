package testCases;


import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverFactory.DriverFactory_TestNG;
import pageFactory.LaunchPage;



public class LaunchTest  {
	
	LaunchPage Launchpf;
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) throws IOException, InterruptedException {
			DriverFactory_TestNG driverFact = new DriverFactory_TestNG();
		driverFact.init_browser(browser);
	 Launchpf = new LaunchPage();
		Launchpf.get_testUrl();
	}
	
    @Test
    void checkmsg()
    {
    	
    	String expmsg="You are at the right place";
      	String actmsg = Launchpf.gettextmsg();
		Assert.assertEquals(actmsg, expmsg, "user is not able see the message 'you are at rightplace' ");
    }
    @Test
    void clickgetstarted()
    {    
    	
   	   	Launchpf.clickgetstarted();
   	 String actmsg = Launchpf.gettitle();
		String expmsg = "NumpyNinja";
		Assert.assertEquals(actmsg, expmsg, "user is not on the homepage with title numpyninja");
    }
    @AfterMethod
    public void tearDown() {
        DriverFactory_TestNG.tear_driver();
    }

}