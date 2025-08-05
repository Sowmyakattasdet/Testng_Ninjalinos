package testMethodsPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.LaunchPage;
import pageObjects.LoginPage;

public class LoginTest {
	  WebDriver driver;
LaunchPage Launchpf;
	LoginPage Loginpf;
@BeforeMethod
@Parameters({"browser"})
public void browser(String br)
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
	Loginpf =new LoginPage(driver);
	Launchpf.geturl();
	Launchpf.clickgetstarted();
}

@Test
public void login()
{
	Loginpf.clickSigninLink();
	

}






}
