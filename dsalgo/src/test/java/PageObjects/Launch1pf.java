package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Launch1pf {

	WebDriver driver;
	
	//constructor
	 public Launch1pf(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Locators
	
@FindBy(xpath="//*[text()='You are at the right place']")
WebElement message;

@FindBy(xpath="//*[text()='Get Started']")

WebElement btn_getstarted;

@FindBy(xpath="//*[text()='NumpyNinja']")
WebElement NumpyNinja;

//*[text()='NumpyNinja']
//action methods

public  void clickgetstarted()
{
	btn_getstarted.click();
}
public void  NumpyNinja()
{
  NumpyNinja.isDisplayed();

}
public void geturl()
{
	driver.get("https://dsportalapp.herokuapp.com/");
	
}
public String gettextmsg()
{
	String text = message.getText();
	return text;
}
}
