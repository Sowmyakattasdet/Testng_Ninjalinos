package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilites.Excel_utils;

public class Login1pf {

	public WebDriver driver;
	
	//constructor
	 public Login1pf(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Locators
	
@FindBy(xpath="//*[text()='Sign in']")
WebElement SigninLink;

@FindBy(xpath="//*[@name='username']")
WebElement Username_textbox;

@FindBy(xpath="//*[@name='password']")
WebElement Password_textbox;

@FindBy(xpath="//*[@value=\"Login\"]")
WebElement Login_button;

@FindBy(xpath="//div[@class='alert alert-primary']")
WebElement loginsuccesfullmessage;

@FindBy(xpath="//*[@name='username']")
WebElement Usernameinvalid_textbox;

@FindBy(xpath="//*[@name='password']")
WebElement Passwordinvalid_textbox;
//*[@role='alert']
//action methods

public void clickSigninLink()
{
	SigninLink.click();
}

public void set_username(String username)
{
	Username_textbox.sendKeys("ninjalinos@work.com");
}
public void set_invalidusername(String username)
{
	Usernameinvalid_textbox.sendKeys(username);
}
public void set_invalidpassword(String password)
{
	 Passwordinvalid_textbox.sendKeys(password);
}
public void set_password(String password)
{
	Password_textbox.sendKeys("sdet218920@");
}
public void clickLoginbutton()
{
	Login_button.click();
}
public String loginsuccesfullmessage()
{
	String msg=loginsuccesfullmessage.getText();
	return msg;
	//loginsuccesfullmessage.getText();
}
public void setDatafromExcel() throws IOException
{
	String filepath=System.getProperty("user.dir")+"\\testdata\\data.xlsx";
	int rows=Excel_utils.rowCount(filepath, "login");
	
	for(int i=1;i<=rows;i++)
	{
		//read data from excel
		String username=Excel_utils.getData(filepath,"login",i,0);
		String password=Excel_utils.getData(filepath,"login",i,0);
		String error_message=Excel_utils.getData(filepath,"login",i,0);
		//pass data to application
		Usernameinvalid_textbox.sendKeys(username);
		 Passwordinvalid_textbox.sendKeys(password);
			Login_button.click();
	}
}
	
	
	
	
	
	
	
	

}