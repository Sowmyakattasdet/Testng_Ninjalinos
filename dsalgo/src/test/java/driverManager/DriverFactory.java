package driverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	
	public static WebDriver driver;
	
	
	public static WebDriver getChromeDriver() {
		
		driver = new ChromeDriver();
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		}
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	
	static WebDriver getSafariDriver() {
		
		driver = new SafariDriver();
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		}
		return driver;
	
	}
	
public	static WebDriver getFireFoxDriver() {
		
		driver = new FirefoxDriver();
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		}
		return driver;
		
	}
public static void quitDriver() {
	if (driver != null) {
		driver.quit();
		driver = null;
	}

}


}