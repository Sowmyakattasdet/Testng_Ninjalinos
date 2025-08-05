package testMethodsPackage;


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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.LaunchPage;



public class LaunchTest extends BaseTest {
  
	@BeforeMethod
	void launch()
	{
		
		Launchpf.geturl();
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

}