package testMethodsPackage;


import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LaunchPage;



public class LaunchTest {
	  WebDriver driver;
	 LaunchPage Launchpf;
	
		
	
	
	@BeforeMethod
	void browser()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Launchpf = new LaunchPage(driver);
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
    @AfterMethod
    void quitbrowser()
    {
    	Launchpf.quitdriver();
    }
}










