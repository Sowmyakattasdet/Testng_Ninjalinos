package day9;

import java.awt.Label;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Ninp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		
		
WebDriver driver=new ChromeDriver(options);
//1
driver.get(" https://tutorialsninja.com/demo/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//2
driver.findElement(By.xpath("//*[@class='btn btn-link dropdown-toggle']")).click();

driver.findElement(By.xpath("//*[@name='EUR']")).click();
//Thread.sleep(3000);
//3
WebElement cart=new WebDriverWait(driver,Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(By.xpath(("//button[@onclick=\"cart.add('30');\"] "))));
driver.findElement(By.xpath("//button[@onclick=\"cart.add('30');\"] ")).click();


driver.findElement(By.xpath("//button[@id=\"button-cart\"]")).click();
WebElement select_error=driver.findElement(By.xpath("//div[@class=\"text-danger\"]"));
String error= select_error.getText();
System.out.println(error);
//4
driver.findElement(By.xpath("//a[text()='Qafox.com']")).click();
//driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
	
driver.findElement(By.xpath("//img[@title='iPhone']")).click();
WebElement element = driver.findElement(By.xpath("//input[@id='input-quantity'] "));
element.clear();
element.sendKeys("2");
driver.findElement(By.xpath("//button[text()=\"Add to Cart\"]")).click();	
//5
/*
WebElement msg=driver.findElement(By.xpath("//*[@class='alert alert-success alert-dismissible']"));
String successmsg=msg.getText();
System.out.println(successmsg);  */
//6
driver.findElement(By.xpath("//*[@id='cart-total']")).click();
driver.findElement(By.xpath("//*[text()='View Cart']")).click();
//7
WebElement quantity=driver.findElement(By.xpath("//*[@class=\"form-control\"][1]"));
quantity.clear();
quantity.sendKeys("3");
driver.findElement(By.xpath("//button[@type=\"submit\"]/../../..  ")).click();
//8
//driver.findElement(By.xpath("//*[text()='Eco Tax (-2.00)']")).getText()	;
WebElement text=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]"));
String ecotax= text.getText();
System.out.println("ecotax="+ecotax);	
WebElement text1=driver.findElement(By.xpath("//body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[2]"));
String VAT= text1.getText();
System.out.println("VAT="+VAT);	
driver.findElement(By.xpath("//a[text()='Checkout']\r\n")).click();
//9
WebElement error1=driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']"));
String errorregect=error1.getText();
System.out.println("error="+errorregect);
driver.findElement(By.xpath("//*[@data-original-title=\"Remove\"]")).click();
//10
Actions action=new Actions(driver);
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
WebElement lapandnote=driver.findElement(By.xpath("//*[text()='Laptops & Notebooks']"));
WebElement ALLLAP=driver.findElement(By.xpath("//*[text()='Show AllLaptops & Notebooks']"));

action.moveToElement(lapandnote).moveToElement(ALLLAP).click().build().perform();
//WebElement all=driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
//WebDriverWait wc=new WebDriverWait(driver,Duration.ofSeconds(25));
//wc.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Laptops & Notebooks']")));
//driver.findElement(By.xpath("//*[text()='Show AllLaptops & Notebooks']")).click();
driver.findElement(By.xpath("//*[@title='HP LP3065']")).click();
driver.findElement(By.xpath("//*[@id='button-cart']")).click();
WebElement sucmsg=driver.findElement(By.xpath("//*[@class='alert alert-success alert-dismissible']"));
Boolean successmssg=sucmsg.isDisplayed();
System.out.println(successmssg+"+success message is displayed ");
//11
//Thread.sleep(3000);
//driver.switchTo().frame("iframeResult");
WebElement carttotal=new WebDriverWait(driver,Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cart-total']")));
driver.findElement(By.xpath("//*[@id='cart-total']")).click();
WebElement viewcart=new WebDriverWait(driver,Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='View Cart']")));
driver.findElement(By.xpath("//*[text()='View Cart']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[@class='accordion-toggle']")).click();
driver.findElement(By.xpath("//*[@id='input-coupon']")).sendKeys("ABCD123");
driver.findElement(By.xpath("//*[@id='button-coupon']")).click();
WebElement ermsg=driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']"));
String errormessage2=ermsg.getText();
System.out.println("coupon code msg="+errormessage2);
//12
Thread.sleep(2000);
//WebElement giftcertificate=new WebDriverWait(driver,Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[(text()='Use Gift Certificate ')]")));

driver.findElement(By.xpath("//a[(text()='Use Gift Certificate ')]")).click();
driver.findElement(By.xpath("//*[@id=\"input-voucher\"]")).sendKeys("AXDFGH123 ");
WebElement giftcerti=new WebDriverWait(driver,Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='button-voucher']")));
driver.findElement(By.xpath("//*[@id='button-voucher']")).click();
WebElement coerror=driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']"));
String gifterror=coerror.getText();
System.out.println("gift code message="+gifterror);
//13
driver.findElement(By.xpath("//*[@id=\"input-voucher\"]")).clear();
System.out.println();
driver.findElement(By.xpath("//a[@class='accordion-toggle']")).click();

WebElement coupon=new WebDriverWait(driver,Duration.ofSeconds(25)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='input-coupon']")));

driver.findElement(By.xpath("//*[@id='input-coupon']")).click();
driver.findElement(By.xpath("//*[@id='input-coupon']")).clear();
//Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='input-coupon']")).click();
driver.findElement(By.xpath("//a[text()='Checkout']")).click();
//14
driver.findElement(By.xpath("//*[@id='button-account']")).click();
driver.findElement(By.xpath("//*[@id='input-payment-firstname']")).sendKeys("abc");
driver.findElement(By.xpath("//*[@id='input-payment-lastname']")).sendKeys("abc");
driver.findElement(By.xpath("//*[@id='input-payment-email']")).sendKeys("yyyyyyy@gmail.com");
driver.findElement(By.xpath("//*[@id='input-payment-telephone']")).sendKeys("12345678");
driver.findElement(By.xpath("//*[@id='input-payment-password']")).sendKeys("1234567");
driver.findElement(By.xpath("//*[@id='input-payment-confirm']")).sendKeys("1234567");
driver.findElement(By.xpath("//*[@id='input-payment-company']")).sendKeys("abcd");
driver.findElement(By.xpath("//*[@id='input-payment-address-1']")).sendKeys("abca");
driver.findElement(By.xpath("//*[@id='input-payment-city']")).sendKeys("tc");
driver.findElement(By.xpath("//*[@id='input-payment-postcode']")).sendKeys("12347");
driver.findElement(By.xpath("//*[@id='input-payment-country']")).click();
driver.findElement(By.xpath("//*//*[text()='India']")).click();
driver.findElement(By.xpath("//*[@id='input-payment-zone']")).click();
driver.findElement(By.xpath("//*[text()='Andhra Pradesh']")).click();
driver.findElement(By.xpath("//*[@name='agree']")).click();
driver.findElement(By.xpath("//*[@id='button-register']")).click();
//15
driver.findElement(By.xpath("//*[@id='button-shipping-address']")).click();
driver.findElement(By.xpath("//*[@rows=\"8\"]")).sendKeys("dhfuewhfiewnfoiewhf");
driver.findElement(By.xpath("//*[@id='button-shipping-method']")).click();
driver.findElement(By.xpath("//*[@type='checkbox']")).click();
driver.findElement(By.xpath("//*[@id='button-payment-method']")).click();
driver.findElement(By.xpath("//*[@id='button-confirm']")).click();
//16
driver.findElement(By.xpath("//*[text()='Contact Us']")).click();
driver.findElement(By.xpath("//*[text()='Contact Us']")).click();
driver.findElement(By.xpath("//*[@id='input-enquiry']")).sendKeys("adfihewijfkdnvciodwhj");
driver.findElement(By.xpath("//*[@type='submit']")).click();

	}

}