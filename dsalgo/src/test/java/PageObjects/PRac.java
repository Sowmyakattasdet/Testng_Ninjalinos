package PageObjects;

import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import junit.framework.Assert;

public class PRac {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		//@BeforeClass
	//	@Given("the user is on Browser")
		//public void the_user_is_on_browser() {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dsportalapp.herokuapp.com/register");
//		WebElement msg=driver.findElement(By.xpath("//*[text()='You are at the right place']"));
//		System.out.println(msg);
//		System.out.println("agregyre");
//		System.out.println("msg="+msg);
//		//form[@class='form-inline']//input
//		Assert.assertEquals("You are at the right place",msg);
		driver.findElement(By.xpath("//input[@value='Register']")).click()	;	
		//WebElement msg=driver.findElement(By.xpath("//*[@name='username']"));
		//boolean isValid=("Boolean").executeScript("return arguments[0].checkValidity();",msg);
		//if(!isValid) {System.out.println("Validation failed on this field");
		//System.out.println(msg.getText());
		//msg.getScreenshotAs(null);
		//form[@method='post']//input[1]
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']")); // Adjust locator if needed
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String validationMsg = (String) jse.executeScript(
		    "return arguments[0].validationMessage;", usernameField
		);
		System.out.println("Validation message: " + validationMsg);
		Assert.assertEquals(validationMsg, "Please fill out this field.");
		}

	}

