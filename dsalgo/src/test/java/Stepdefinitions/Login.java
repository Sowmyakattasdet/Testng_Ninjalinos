package Stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.Home1pf;
import PageObjects.Launch1pf;
import PageObjects.Login1pf;
import driverManager.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver = DriverFactory.getDriver();
	public Login1pf lg;
	public Launch1pf lap;
	public Home1pf Hm;
	

@Given("the user is on the Home page")
public void the_user_is_on_the_home_page() {
	driver.get("https://dsportalapp.herokuapp.com/");
	lap=new Launch1pf(driver);
	//Hm =new Home1pf(driver);
	lap.clickgetstarted();

	}
	


@When("user clicks on signin")
public void user_clicks_on_signin() {
	 lg=new Login1pf(driver);
	  lg.clickSigninLink();
	 // Login1pf.clickSigninLink();
}

@When("the user enters valid username  password and clicks on Login")
public void the_user_enters_valid_username_password_and_clicks_on_login() {
	   lg.set_username(null);
	    lg.set_password(null);
	    lg.clickLoginbutton();
}

@Then("the user lands on Home page with message {string}")
public void the_user_lands_on_home_page_with_message(String string) {
   
}

@When("the user enters   {string} and {string} and clicks on Login")
public void the_user_enters_and_and_clicks_on_login(String string, String string2) throws IOException {
//  lg.set_invalidusername(Username);
//  lg.set_invalidpassword(Password);
//  lg.clickLoginbutton();
lg.setDatafromExcel();
}

@Then("the user will able to see {string} in login page")
public void the_user_will_able_to_see_in_login_page(String string) {
   
}

}
