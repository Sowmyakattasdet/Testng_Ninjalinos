package practice;


import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Launchprac {
	  WebDriver driver;
	 Launchpf Launchpf;
	
		
	
	
	@BeforeMethod()
	void browser()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Launchpf = new Launchpf(driver);
	}
    @BeforeMethod()
	void openUrl()
	{
		Launchpf.geturl();

	}
    @Test()
    void checkmsg()
    {
    	String expmsg="You are at the right place";
      	String actmsg = Launchpf.gettextmsg();
		Assert.assertEquals(actmsg, expmsg, "user is not able see the message 'you are at rightplace' ");
    }
    @Test()
    void clickgetstarted()
    {    
   	   	Launchpf.clickgetstarted();
    }
//    @AfterMethod()
//    void closebrowser()
//    {
//    	driver.quit();
//    }
}










