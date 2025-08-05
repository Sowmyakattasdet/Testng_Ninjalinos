package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverFactory.DriverFactory_TestNG;
import pageFactory.CommonMethods;
import pageFactory.Stack_pf;

public class Stack {
	Stack_pf stack;
	CommonMethods common;
	WebDriver tldriver;
	DriverFactory_TestNG df;

	@Parameters({"browser"})	
	@BeforeClass
	public void open_stack_page(String br) throws IOException {
		this.df = new DriverFactory_TestNG();
		this.tldriver = df.init_browser(br);
		this.stack = new Stack_pf(tldriver);
		this.common = new CommonMethods(tldriver);
		common.launch_webpage();
		common.waitUntilPageLoads("/home");
		stack.stack_btn();

	}

	@Test(priority = 1)
	public void stackOperations() {
		common.waitUntilPageLoads("/stack/");
		stack.opreations_stack_btn();
		common.waitUntilPageLoads("/operations-in-stack/");
		String currentUrl = stack.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/stack/operations-in-stack/", currentUrl,
				"not in operations in stack page");
	}

	@Test(priority = 2, dependsOnMethods = { "stackOperations" })
	public void StackoperationsCodeEditor() {
		common.waitUntilPageLoads("/operations-in-stack/");
		stack.tryhere_stack();
		common.waitUntilPageLoads("/tryEditor");
		String currentUrl = stack.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl,
				"not in try here page of operations in stack page");

	}

	@AfterClass
	public void teardownDriver() {
		df.tear_driver();

	}

}
