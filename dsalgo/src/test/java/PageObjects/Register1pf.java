package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register1pf {

	WebDriver driver;
	
	//constructor
	 public Register1pf(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Locators
	
@FindBy(xpath="//*[@name='username']")
WebElement usernameTextbox;

@FindBy(xpath="//*[@name='password1']")
WebElement passwordTextbox;

@FindBy(xpath="//*[@name='password2']")
WebElement confirmpasswordTextbox;

@FindBy(xpath="//*[@value='Register']")
WebElement RegisterButton;


@FindBy(xpath="//div[@class=\"alert alert-primary\"]")
WebElement missmatchPasswordMessage;
 

//action methods

public void setusername(String username)
{
	usernameTextbox.sendKeys("ninjalinos@work.com");
}
public void setinvalidusername(String username)
{
	usernameTextbox.sendKeys(username);
}
public void setinvalidpassword(String password)
{
	passwordTextbox.sendKeys(password);
}
public void setinvalidconfirmpassword(String confirmpassword)
{
	confirmpasswordTextbox.sendKeys(confirmpassword);
}
public void setpassword(String password)
{
	passwordTextbox.sendKeys("sdet218920@");
}
public void setconfirmpassword(String confirmpassword)
{
	confirmpasswordTextbox.sendKeys("sdet218920@");
}
public void clickRegisterbutton()
{
	RegisterButton.click();
}
public void missmatchPasswordMessage()
{
	missmatchPasswordMessage.getText();
}
}
