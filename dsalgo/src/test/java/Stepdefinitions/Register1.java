package Stepdefinitions;

import org.openqa.selenium.WebDriver;

import PageObjects.Home1pf;
import PageObjects.Launch1pf;
import PageObjects.Login1pf;
import PageObjects.Register1pf;
import driverManager.DriverFactory;
import io.cucumber.java.en.*;

public class Register1 {
	WebDriver driver = DriverFactory.getDriver();
	public Login1pf lg;
	public Launch1pf lap;
	public Home1pf Hm;
	public Register1pf rg;
	
@When("the user clicks on the Register")
public void the_user_clicks_on_the_register() {
	Hm =new Home1pf(driver);
	Hm.clickRegister();
	rg=new Register1pf(driver);
	  
	}

@When("the user enters valid inputs and clicks on register button")
public void the_user_enters_valid_inputs_and_clicks_on_register_button() {
    rg.setusername(null);
    rg.setpassword(null);
    rg.setconfirmpassword(null);
    rg.clickRegisterbutton();
}

@Then("User able to see succesfully registered  message")
public void user_able_to_see_succesfully_registered_message() {
   
}

@When("the user enters {string} {string} and {string} and clicks register button")
public void the_user_enters_and_and_clicks_register_button(String string, String string2, String string3) {
   rg.setinvalidusername(string);
   rg.setinvalidpassword(string2);
   rg.setinvalidconfirmpassword(string3);
   rg.clickRegisterbutton();
}


@Then("the user be able to see error message")
public void the_user_be_able_to_see_error_message() {
    
}




}
