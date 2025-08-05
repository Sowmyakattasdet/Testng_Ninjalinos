package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory_TestNG {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public WebDriver tldriver;

	public WebDriver init_browser(String br) {

		switch (br.toLowerCase()) {
		case "chrome":
//	        	ChromeOptions optionsChrome = new ChromeOptions();
//				optionsChrome.addArguments("--headless=new");
//	        	driver.set(new ChromeDriver(optionsChrome));
			driver.set(new ChromeDriver());
			break;
		case "edge":
//	        	EdgeOptions optionsEdge = new EdgeOptions();
//				optionsEdge.addArguments("--headless=new");
//	        	driver.set(new EdgeDriver(optionsEdge));
			driver.set(new EdgeDriver());
			break;
		case "firefox":
//	        	FirefoxOptions optionsFirefox = new FirefoxOptions();
//				optionsFirefox.addArguments("--headless");
//	        	driver.set(new FirefoxDriver(optionsFirefox));
			driver.set(new FirefoxDriver());
			break;
		default:
			driver.set(new ChromeDriver());
			break;
		}

		tldriver = driver.get();
		tldriver.manage().deleteAllCookies();
		tldriver.manage().window().maximize();
		tldriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
		return tldriver;

	}

	public void tear_driver() {

		tldriver.quit();

	}

}
