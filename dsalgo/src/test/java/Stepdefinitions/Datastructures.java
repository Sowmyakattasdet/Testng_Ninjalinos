package Stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Datastructures1pf;
import PageObjects.Home1pf;
import PageObjects.Launch1pf;
import PageObjects.Login1pf;
import driverManager.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Datastructures {
	WebDriver driver = DriverFactory.driver;
	
public Datastructures1pf Ds;

@Given("the user clicks on get started button of Data structures after logged in with user credentials")
public void the_user_is_on_the_home_page_after_logged_in() {
	
driver.get("https://dsportalapp.herokuapp.com/");
//Ds.landDatastructurepage();
	Launch1pf	lap=new Launch1pf(driver);
	lap.clickgetstarted();
	Login1pf lg=new Login1pf(driver);
	 lg.clickSigninLink();
	  lg.set_username("username");
	    lg.set_password("password");
	    lg.clickLoginbutton();
	   Ds=new Datastructures1pf(driver);
	    Ds.clickgetstartedDatastructures();
//	Ds.landDatastructurepage();
}



@Given("The user is in the Data Structures - Introduction page")
public void the_user_is_in_the_data_structures_introduction_page() {
	Assert.assertEquals(Ds.Datastructurespagetitle(), "Data Structures-Introduction");
	
}

@When("The user clicks on Time Complexity link")
public void the_user_clicks_on_time_complexity_link() {
    Ds.clickTimecomplexityLink();
}

@Then("The user should be directed to Time Complexity of Data structures-Introduction")
public void the_user_should_be_directed_to_time_complexity_of_data_structures_introduction() {
	Assert.assertEquals(Ds.Timecomplexitytitle(), "Time Complexity");
}

@Given("The user is on the Time Complexity page")
public void the_user_is_on_the_time_complexity_page() {
	Ds.clickTimecomplexityLink();
}

@When("The user clicks practice Questions")
public void the_user_clicks_practice_questions() {
   Ds.clickPracticeQuestionsLink();
}

@Then("The user should be directed to Practice Questions of Data structures-Introduction Page, again redirected to Time complexity page")
public void the_user_should_be_directed_to_practice_questions_of_data_structures_introduction_page_again_redirected_to_time_complexity_page() {
	driver.navigate().back();
}

@When("the user clicks Try here button")
public void the_user_clicks_try_here_button() {
    Ds.clickTryhereLink();
}

@Then("The user should be directed the page having an try Editor with a Run button to test")
public void the_user_should_be_directed_the_page_having_an_try_editor_with_a_run_button_to_test() {
  Assert.assertEquals(Ds.tryeditorurl(), "https://dsportalapp.herokuapp.com/tryEditor");
}

@Given("The user is on the tryEditor page")
public void the_user_is_on_the_try_editor_page() {
	Ds.clickTimecomplexityLink();
	  Ds.clickTryhereLink();
}

@When("The user clicks the Run button without entering the code in the Editor")
public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor() {
Ds.clickRunButton();

}

@Then("The user should able to see error message in alert window")
public void the_user_should_able_to_see_error_message_in_alert_window() {
  Ds.closealert();
}

@When("The user clicks the Run button by entering the  wrong code in the Editor")
public void the_user_clicks_the_run_button_by_entering_the_wrong_code_in_the_editor() {
	Ds.Tryeditorboxwithinvaliddata();
	Ds.clickRunButton();
}

@When("the user clicks the Run button by entering the correct python code")
public void the_user_clicks_the_run_button_by_entering_the_correct_python_code() {
 Ds.Tryeditorboxvaliddata();
 Ds.clickRunButton();
}

@Then("the user should able to see output in the console window")
public void the_user_should_able_to_see_output_in_the_console_window() {
   
}




}
