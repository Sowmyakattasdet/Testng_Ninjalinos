package PageObjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Datastructures1pf {

	WebDriver driver;
	Actions action;
	//constructor
	 public Datastructures1pf(WebDriver driver)
	{
		this.driver=driver;
		this.action = new Actions(driver);
		PageFactory.initElements(driver,this);
	}
	
	//Locators
	
		
@FindBy(xpath="//*[text()='Data Structures-Introduction']//../a")
WebElement getstartedButton_dataStructures;

@FindBy(xpath="//*[text()='Time Complexity']")
WebElement TimecomplexityLink;

@FindBy(xpath="//*[text()='Practice Questions']")
WebElement PracticeQuestionsLink;

@FindBy(xpath="//*[text()='Try here>>>']")
WebElement TryhereLink;

@FindBy(xpath="//div[@class='CodeMirror-lines']")
WebElement Tryeditorbox;

@FindBy(xpath="//*[text()='Run']")
WebElement RunButton;

@FindBy(xpath="//h4[text()='Data Structures-Introduction']")
WebElement Datastructurespagetitle;


@FindBy(xpath="//p[text()='Time Complexity']")
WebElement Timecomplexitytitle;
//h4[text()='Data Structures-Introduction']
//action methods

public String Datastructurespagetitle()
{
	String text=Datastructurespagetitle.getText();
	return text;
}
public String Timecomplexitytitle()
{
	String text=Timecomplexitytitle.getText();
	return text;
}
public void clickgetstartedDatastructures()
{
	getstartedButton_dataStructures.click();
}
public void clickTimecomplexityLink()
{
	JavascriptExecutor	jse=(JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,400)");
	TimecomplexityLink.click();
}
public void clickPracticeQuestionsLink()
{
	PracticeQuestionsLink.click();
}
public void clickTryhereLink()
{
	JavascriptExecutor	jse=(JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,400)");
	TryhereLink.click();
}
public void Tryeditorboxwithinvaliddata()
{
	//Tryeditorbox.click();
	JavascriptExecutor	jse=(JavascriptExecutor) driver;
	
	jse.executeScript("let editor = document.querySelector('.CodeMirror').CodeMirror;"
			+ "editor.setValue('prin(hello world\")');");
}
public void Tryeditorboxvaliddata()
{
	JavascriptExecutor	jse=(JavascriptExecutor) driver;
	jse.executeScript("let editor = document.querySelector('.CodeMirror').CodeMirror;"
			+ "editor.setValue('print(\"hello world\")');");
	//Tryeditorbox.sendKeys("print('hello')");
}
public String tryeditorurl()
{
String	tryeditorurl;
	@Nullable String tryeditorurl1=driver.getCurrentUrl();
	return tryeditorurl1;

}
public void landDatastructurepage()
{
	driver.get("https://dsportalapp.herokuapp.com/");
	Launch1pf	lap=new Launch1pf(driver);
	lap.clickgetstarted();
	Login1pf lg=new Login1pf(driver);
	 lg.clickSigninLink();
	  lg.set_username("username");
	    lg.set_password("password");
	    lg.clickLoginbutton();
	   
}
public void closealert()
{
	driver.switchTo().alert().accept();
}
public void clickRunButton()
{
	RunButton.click();
}
}