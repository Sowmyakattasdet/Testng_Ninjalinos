package testMethodsPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageObjects.HomePage;
import pageObjects.LaunchPage;

public class BaseTest {
	public  WebDriver driver;
	LaunchPage Launchpf;
	 HomePage Homepf;
		
	
	
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Launchpf = new LaunchPage(driver);
		Homepf = new HomePage(driver);

	}
	 @AfterMethod
	    void tearDown()
	    {
	    	Launchpf.quitdriver();
	    }}