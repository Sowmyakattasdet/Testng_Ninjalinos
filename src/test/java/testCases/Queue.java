package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageFactory.BasePage;
import pageFactory.Queue_pf;

@Listeners(CustomListener.class)
public class Queue extends BaseTest {

	Queue_pf queue;
	BasePage base;

	@BeforeMethod
	public void queue_page() throws IOException {
		base = new BasePage();
		queue = new Queue_pf();

	}

	@Test(priority = 1)
	public void open_queue_page() {

		//base.waitUntilPageLoads("/home");
		queue.queue_btn();

	}

	@Test(priority = 2)
	public void queueImplementation() {
		//base.waitUntilPageLoads("/home");
		queue.queue_btn();
		//base.waitUntilPageLoads("/queue/");
		queue.implementation_queue_python_btn();
		//base.waitUntilPageLoads("/implementation-lists/");
		String currentUrl = queue.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/queue/implementation-lists/", currentUrl,
				"not in implementation of queue in python page");
	}

	// @Test(priority=2, dependsOnMethods = { "queueImplementation" })
	@Test(priority = 3)
	public void queueImplementationCodeEditor() {
		//base.waitUntilPageLoads("/home");
		queue.queue_btn();
		//base.waitUntilPageLoads("/queue/");
		queue.implementation_queue_python_btn();
		//base.waitUntilPageLoads("/implementation-lists/");
		queue.tryhere_queue();
		//base.waitUntilPageLoads("/tryEditor");
		String currentUrl = queue.get_current_url();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor", currentUrl,
				"not in try here page of implemetation of queue in python page");

	}

}
