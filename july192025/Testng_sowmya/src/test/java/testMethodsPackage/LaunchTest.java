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



public class LaunchTest {
	  WebDriver driver;
	 LaunchPage Launchpf;
	
		
	
	
	@BeforeMethod
	@Parameters({"browser"})
	void browser(String br)
	{
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		case "edge": driver=new EdgeDriver();break;
		default: System.out.println("Invalid browser");return;
		}
		//driver=new ChromeDriver();
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
    void tearDown()
    {
    	Launchpf.quitdriver();
    }
}










