package Stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Home1pf;
import PageObjects.Launch1pf;
import driverManager.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Home {
	WebDriver driver = DriverFactory.driver;
	public Home1pf Hm;
@Given("the user is on DsAlgo portal")
public void the_user_is_on_ds_algo_portal() {

	driver.get("https://dsportalapp.herokuapp.com/");
	Hm =new Home1pf(driver);
	}


@When("the user clicks on Get started button")
public void the_user_clicks_on_get_started_button() {
Launch1pf lap=new Launch1pf(driver);
	lap.clickgetstarted();
}

@Given("the user is on Home page")
public void the_user_is_on_home_page() {
	Assert.assertEquals(Hm.Homepagetext(),"NumpyNinja");
}

@When("the user clicks on Get started button  in Data strucures-Introduction without signin")
public void the_user_clicks_on_get_started_button_in_data_strucures_introduction_without_signin() {
   Hm.clickgetstartedDatastructures();
}

@Then("The user should able to see an warning message You are not logged in")
public void the_user_should_able_to_see_an_warning_message_you_are_not_logged_in() {
   Assert.assertEquals(Hm.notloggedinmesg(), "You are not logged in");
}

@When("the user clicks on Get started button in Array without signin")
public void the_user_clicks_on_get_started_button_in_array_without_signin() {
    Hm.clickgetstartedArray();
}

@When("the user clicks on Get started button in Linked List without signin")
public void the_user_clicks_on_get_started_button_in_linked_list_without_signin() {
  Hm.clickgetstartedLinkedList();
}

@When("the user clicks on Get started button in Stack without signin")
public void the_user_clicks_on_get_started_button_in_stack_without_signin() {
    Hm.clickgetstartedStack();
}

@When("the user clicks on Get started button in Queue without signin")
public void the_user_clicks_on_get_started_button_in_queue_without_signin() {
   Hm.clickgetstartedQueue();
}

@When("the user clicks on Get started button Tree without signin")
public void the_user_clicks_on_get_started_button_tree_without_signin() {
    Hm.clickgetstartedTree();
}

@When("the user clicks on Get started button in Graph without signin")
public void the_user_clicks_on_get_started_button_in_graph_without_signin() {
    Hm.clickgetstartedGraph();
}

@When("the user clicks dropdown and select datastructures")
public void the_user_clicks_dropdown_and_select_datastructures() {
    Hm.clickDropdownbox();
    //Screenshot
}

@When("the user clicks dropdown and select Array")
public void the_user_clicks_dropdown_and_select_array() {
  Hm.clickDropdownbox();
	Hm.clickDropdownArrays();
}

@When("the user clicks dropdown and select Linkedlist")
public void the_user_clicks_dropdown_and_select_linkedlist() {
	 Hm.clickDropdownbox();   
	Hm.clickDropdownLinkedList();
}

@When("the user clicks dropdown and select Stack")
public void the_user_clicks_dropdown_and_select_stack() {
	 Hm.clickDropdownbox();
	Hm.clickDropdownStack();
}

@When("the user clicks dropdown and select Queue")
public void the_user_clicks_dropdown_and_select_queue() {
	 Hm.clickDropdownbox();
	Hm.clickDropdownQueue();
}

@When("the user clicks dropdown and select Tree")
public void the_user_clicks_dropdown_and_select_tree() {
	 Hm.clickDropdownbox();
	Hm.clickDropdownTree();
}

@When("the user clicks dropdown and select Graph")
public void the_user_clicks_dropdown_and_select_graph() {
	 Hm.clickDropdownbox();
	Hm.clickgetstartedGraph();
}

@When("the user clicks on Register")
public void the_user_clicks_on_register() {
    Hm.clickRegister();
}

@Then("The user should land on registration page")
public void the_user_should_land_on_registration_page() {
    
}



}
