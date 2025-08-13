package driverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_browser(String br) {

		switch (br.toLowerCase()) {
		case "chrome":
	        	//ChromeOptions optionsChrome = new ChromeOptions();
				//optionsChrome.addArguments("--headless=new");
//	        	driver.set(new ChromeDriver(optionsChrome));
				//tlDriver.set(new ChromeDriver(optionsChrome));
			tlDriver.set(new ChromeDriver());
			break;
		case "safari":
	        	tlDriver.set(new SafariDriver());
			break;
		case "firefox":
	        	FirefoxOptions optionsFirefox = new FirefoxOptions();
				optionsFirefox.addArguments("--headless");
	        	tlDriver.set(new FirefoxDriver(optionsFirefox));
			//tlDriver.set(new FirefoxDriver());
			break;
		default:
			tlDriver.set(new ChromeDriver());
			break;
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));

		return getDriver();

	}
 
    public static WebDriver getDriver() {
        return tlDriver.get();  // GETS DRIVER FOR CURRENT THREAD
    }


  
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();  
            tlDriver.remove();     
        }
    }
}



