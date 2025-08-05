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
import pageFactory.Queue_pf;


public class Queue {
	Queue_pf queue;
	CommonMethods common;
	WebDriver tldriver;
	DriverFactory_TestNG df;
	
	
	
    @Parameters({"browser"})	
	@BeforeClass
	public void open_stack_page(String br) throws IOException {
    	this.df = new DriverFactory_TestNG();
		this.tldriver = df.init_browser(br);
		this.queue = new Queue_pf(tldriver);
		this.common = new CommonMethods(tldriver);
		common.launch_webpage();
		common.waitUntilPageLoads("/home");
		queue.queue_btn();
		
		
	}
	@Test(priority=1)
	public void queueImplementation() {
		common.waitUntilPageLoads("/queue/");
		queue.implementation_queue_python_btn();
		common.waitUntilPageLoads("/implementation-lists/");
		String currentUrl = queue.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/queue/implementation-lists/", currentUrl ,"not in implementation of queue in python page");
	}
	
	@Test(priority=2, dependsOnMethods = { "queueImplementation" })
	public void queueImplementationCodeEditor() {
		common.waitUntilPageLoads("/implementation-lists/");
		queue.tryhere_queue();
		common.waitUntilPageLoads("/tryEditor");
		String currentUrl = queue.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl ,"not in try here page of implemetation of queue in python page");
		
	}
	
	@AfterClass
	public void teardownDriver() {
		df.tear_driver();
		
	}

}
