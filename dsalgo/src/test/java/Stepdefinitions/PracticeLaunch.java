package Stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Launch1pf;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import org.testng.asserts.*;

//public class PracticeLaunch {

//WebDriver driver;
	
/*
	@Given("the user is on Browser")
	public void the_user_is_on_browser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.get("https://dsportalapp.herokuapp.com/");
	}

	
	@When("the user enters the valid DsAlgo portal Url")
	public void the_user_enters_the_valid_ds_algo_portal_url() {
		driver.get("https://dsportalapp.herokuapp.com/");
		
	}
Launch1pf lap=new Launch1pf(driver);
	
	@Then("The user should be able to land on DsAlgo portal with the message {string}")
	public void the_user_should_be_able_to_land_on_ds_algo_portal() {
		
	}

	@Given("the user is on DsAlgo portal")
	public void the_user_is_on_ds_algo_portal() {
		
	}

	@When("the user clicks Get started button")
	public void the_user_clicks_get_started_button_after_verifying_the_message(String text) {
	
		
		//String gettextmsg = lap.gettextmsg();
		//lap.clickgetstarted();
		//Assert.assertEquals(text, gettextmsg);
		lap.clickgetstarted();
	}

	@Then("the user lands on Home page")
	public void the_user_lands_on_home_page() {
		
	}

}
*/