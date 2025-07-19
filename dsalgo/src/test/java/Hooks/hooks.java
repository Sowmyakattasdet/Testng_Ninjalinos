package Hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import driverManager.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {


WebDriver driver;

@Before
public void setUp() {
	driver = DriverFactory.getChromeDriver();
//	driver.get("https://dsportalapp.herokuapp.com/");

}
//
//@After
//public void tearDown() {
//	DriverFactory.quitDriver();
//}
}