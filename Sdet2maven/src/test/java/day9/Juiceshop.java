package day9;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Juiceshop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		
		
		
		WebDriver driver=new ChromeDriver(options);
		Actions act=new Actions(driver);
		
		//to register
		/*driver.get("https://juice-shop.herokuapp.com/#/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//*[text()='Dismiss']")).click();
		WebElement email=driver.findElement(By.xpath("//*[@id='emailControl']"));
		//email.sendKeys("sowmya@gmail.com");
		//WebElement scroll=driver.findElement(By.xpath("//*df[@role='listbox']"));
		act.sendKeys(email,"sowmyaabcd@gmail.com").keyDown(Keys.TAB).keyUp(Keys.TAB)
		.sendKeys("Sowmya@12345").keyDown(Keys.TAB).keyUp(Keys.TAB)       
          .sendKeys("Sowmya@12345").keyDown(Keys.TAB).keyUp(Keys.TAB)
         .perform();
		driver.findElement(By.xpath("//*[@id=\"mat-select-value-0\"]")).click();
		WebElement pet=driver.findElement(By.xpath("//*[@id='mat-option-6']"));
		pet.click();
		driver.findElement(By.xpath("//*[@id='securityAnswerControl']")).sendKeys("dog");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[text()=' Register ']")).click();*/
		
		driver.get("https://demo.owasp-juice.shop/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[text()='Dismiss']")).click();
		//login
		driver.findElement(By.xpath("//*[text()=' Account ']")).click();
		driver.findElement(By.xpath("//*[@id='navbarLoginButton']")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("sowmyaabcd@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Sowmya@12345");
		driver.findElement(By.xpath("//*[text()=' Log in ']")).click();
		//adding 2items by scrolling
		WebElement fruitpress=driver.findElement(By.xpath("//*[text()=' Fruit Press ']/../../../div[2]"));
		Thread.sleep(2000);
		WebElement lemonjuice=driver.findElement(By.xpath("//div[text()=' Lemon Juice (500ml) ']/../../../div[2]"));
		Thread.sleep(1000);
		act.scrollToElement(fruitpress).click(fruitpress).scrollToElement(lemonjuice).click(lemonjuice).perform();
		//adding 2items in cart
		driver.findElement(By.xpath("//*[text()=' Your Basket']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//mat-cell[contains(text(),'Fruit Press')]/..//button[2]/span[3]")).click();
	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//mat-cell[contains(text(),' Lemon Juice (500ml) ')]/..//button[2]/span[3]")).click();
		//checkout
		Thread.sleep(5000);
		
		WebElement checkout=new WebDriverWait(driver,Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[@id='checkoutButton']/span[1]"))));
		driver.findElement(By.xpath("//*[@id='checkoutButton']/span[1]")).click();	
		
		driver.findElement(By.xpath("//*[text()='Add New Address']")).click();
		//details
		
		
		WebElement country=driver.findElement(By.xpath("//*[@id='mat-input-4']"));
		country.sendKeys(RandomStringUtils.randomAlphabetic(6));
		WebElement name=driver.findElement(By.xpath("//*[@id='mat-input-5']"));
		name.sendKeys(RandomStringUtils.randomAlphabetic(6));
		WebElement mobile=driver.findElement(By.xpath("//*[@id='mat-input-6']"));
		mobile.sendKeys(RandomStringUtils.randomNumeric(10));
		WebElement zip=driver.findElement(By.xpath("//*[@id='mat-input-7']"));
		zip.sendKeys(RandomStringUtils.randomNumeric(7));
		WebElement address=driver.findElement(By.xpath("//*[@id='address']"));
		address.sendKeys(RandomStringUtils.randomAlphabetic(6));
		WebElement city=driver.findElement(By.xpath("//*[@id=\"mat-input-9\"]"));
		city.sendKeys(RandomStringUtils.randomAlphabetic(5));
		WebElement state=driver.findElement(By.xpath("id=\"mat-input-10\""));
		state.sendKeys(RandomStringUtils.randomAlphabetic(6));
		driver.findElement(By.xpath("//span[contains(text( ),'Submit')]")).click();
		//select address radio button
		driver.findElement(By.xpath("//*[@class=\"mdc-form-field mat-internal-form-field\"]")).click();
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
	//delivery speed
		driver.findElement(By.xpath("//mat-cell[text()='1 Days']/..//div[2][1][@class=\"mdc-radio__background\"]")).click();
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		
		//add coupon
		driver.findElement(By.xpath("//*[text()=' Add a coupon code to receive discounts ']")).click();
		driver.findElement(By.xpath("//*[@id=\"coupon\"]")).sendKeys("kijhgfrsed");
		driver.findElement(By.xpath("//*[contains(text(),'Redeem')]")).click();
		//add new card
		driver.findElement(By.xpath("//*[contains(text(),' Add a credit or debit card ')]")).click();
		driver.findElement(By.xpath("//*[@id=\"mat-input-11\"]")).sendKeys("ajhdfoiuewh");
		driver.findElement(By.xpath("//*[@id=\"mat-input-12\"]")).sendKeys("1235487787878485");
		driver.findElement(By.xpath("//*[@id=\"mat-input-13\"]")).click();
		driver.findElement(By.xpath("//*[text()='1']")).click();
		driver.findElement(By.xpath("//*[@id=\"mat-input-14\"]")).click();
		driver.findElement(By.xpath("//*[text()='2096']")).click();
		//driver.findElement(By.xpath("//*[text()=' Submit ']")).click();
		//pay using wallet
		//driver.findElement(By.xpath("//*[@type='submit']//span[5]")).click();
		
		//place your order and pay
		driver.findElement(By.xpath("//*[text()='Place your order and pay']")).click();
     	//paymentnote
		driver.findElement(By.xpath("//*[text()='note']")).click();
		//*[text()='note']
		//logout
		driver.findElement(By.xpath("//*[text()=' Account ']")).click();
		driver.findElement(By.xpath("//*[@id='navbarLogoutButton']")).click();
	
		
		
	}

}
