package Stepdefinitions;

import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Launch1pf;
import driverManager.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Launch1 {
//WebDriver driver;
	WebDriver driver = DriverFactory.getDriver();
public Launch1pf lap;

//WebDriver driver = DriverFactory.driver();
@Given("the user is on the Dsalgo portal after entering Url")
public void the_user_is_on_browser() {
	//WebDriver driver = DriverFactory.driver;
	driver.get("https://dsportalapp.herokuapp.com/");
	lap=new Launch1pf(driver);
	//driver.get("https://dsportalapp.herokuapp.com/");
}

@Then("The user should be able to land on DsAlgo portal with the message {string}")
public void the_user_should_be_able_to_land_on_ds_algo_portal_with_the_message(String message) throws InterruptedException {
	Thread.sleep(2000);
	Assert.assertEquals(message, lap.gettextmsg());
}



@When("the user clicks Get started button")
public void the_user_clicks_get_started_button() {
	
	lap.clickgetstarted();
}

@Then("the user lands on Home page")
public void the_user_lands_on_home_page() throws InterruptedException {
	Thread.sleep(2000);
   Assert.assertEquals(driver.getTitle(),"NumpyNinja");
}
}

