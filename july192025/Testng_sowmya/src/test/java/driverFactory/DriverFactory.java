package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageObjects.LaunchPage;

public class DriverFactory {
	public static WebDriver driver;
	 
		 LaunchPage Launchpf;
		

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String br) {
        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       		driver.manage().window().maximize();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser: " + br);
                return;
        }

     
    }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		Launchpf = new LaunchPage(driver);
//		Launchpf.geturl();
	}
    

