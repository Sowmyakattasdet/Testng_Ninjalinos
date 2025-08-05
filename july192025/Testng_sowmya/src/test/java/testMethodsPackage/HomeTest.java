package testMethodsPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LaunchPage;

public class HomeTest extends BaseTest {
	  WebDriver driver;
		// LaunchPage Launchpf;
//		 HomePage Homepf;
		 

			@BeforeMethod
			void Home()
			{
				//driver=new FirefoxDriver();
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//				driver.manage().window().maximize();
			//	Launchpf = new LaunchPage(driver);
//				Homepf = new HomePage(driver);
				Launchpf.geturl();
				//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));

				Launchpf.clickgetstarted();
			}
		 
		 //when clicks on Datastructures Getstarted button
			 @Test(priority=1)
			    void ClicksDataStBtn()
			    {
					Homepf.clickgetstartedDatastructures();
					String actmsg = Homepf.notloggedinmesg();
					String expmsg = "You are not logged in";
					Assert.assertEquals(actmsg, expmsg,
							"the user is not able to see mesg your are not logged in because no option in the dropdown");
			    }
		 //Array getstarted button
			 @Test(priority=2)
			    void ClickArrayBtn()
			    {
				 Homepf.clickgetstartedArray();
					String actmsg = Homepf.notloggedinmesg();
					String expmsg = "You are not logged in";
					Assert.assertEquals(actmsg, expmsg,
							"the user is not able to see mesg your are not logged in because no option in the dropdown");
			    }
			//LinkedlstGetStartedbtn
			 @Test(priority=3)
			    void ClickLinkedlstBtn() 
			    {
				 
				 Homepf.clickgetstartedLinkedList();
				
					String actmsg = Homepf.notloggedinmesg();
					String expmsg = "You are not logged in";
					Assert.assertEquals(actmsg, expmsg,
							"the user is not able to see mesg your are not logged in because no option in the dropdown");
			    }
			//StacktGetStartedbtn
			 @Test(priority=4)
			    void ClickStacktBtn() 
			    {
				 
				 Homepf.clickgetstartedStack();
				
					String actmsg = Homepf.notloggedinmesg();
					String expmsg = "You are not logged in";
					Assert.assertEquals(actmsg, expmsg,
							"the user is not able to see mesg your are not logged in because no option in the dropdown");
			    }
			
			
			
			
			//QueueGetStartedbtn
			 @Test(priority=5)
			    void ClickQueueBtn() throws InterruptedException
			    {
				 
				 Homepf.clickgetstartedQueue();
				
					String actmsg = Homepf.notloggedinmesg();
					String expmsg = "You are not logged in";
					Assert.assertEquals(actmsg, expmsg,
							"the user is not able to see mesg your are not logged in because no option in the dropdown");
			    }
			 //TreeGetstartedBtn
			 @Test(priority=6)
			    void ClickTreeBtn() 
			    {
				 
				 Homepf.clickgetstartedTree();
				
					String actmsg = Homepf.notloggedinmesg();
					String expmsg = "You are not logged in";
					Assert.assertEquals(actmsg, expmsg,
							"the user is not able to see mesg your are not logged in because no option in the dropdown");
			    }
			//GraphGetstartdBtn
			 @Test(priority=7)
			    void ClickGraphBtn() 
			    {
				 
				 Homepf.clickgetstartedGraph();
				
					String actmsg = Homepf.notloggedinmesg();
					String expmsg = "You are not logged in";
					Assert.assertEquals(actmsg, expmsg,
							"the user is not able to see mesg your are not logged in because no option in the dropdown");
			    }
			//DropdownDS
			@Test(priority=8)
			void DropdownDS()
			{
				Homepf.clickDropdownbox();
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
			}
			@Test(priority=9)
			void DropdownArray()
			{
				Homepf.clickDropdownbox();
				Homepf.clickDropdownArrays();
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
			}
			@Test(priority=10)
			void DropdownLinkedlst()
			{
				Homepf.clickDropdownbox();
				Homepf.clickDropdownLinkedList();
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
			}
			@Test(priority=11)
			void DropdownStack()
			{
				Homepf.clickDropdownbox();
				Homepf.clickDropdownStack();
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
			}
			@Test(priority=12)
			void DropdownQueue()
			{
				Homepf.clickDropdownbox();
				Homepf.clickDropdownQueue();
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
			}
			@Test(priority=13)
			void DropdownTree()
			{
				Homepf.clickDropdownbox();
				Homepf.clickDropdownTree();
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
			}
			@Test(priority=14)
			void DropdownGraph()
			{
				Homepf.clickDropdownbox();
				Homepf.clickDropdownGraph();
				String actmsg = Homepf.notloggedinmesg();
				String expmsg = "You are not logged in";
				Assert.assertEquals(actmsg, expmsg,
						"the user is not able to see mesg your are not logged in because no option in the dropdown");
			}
			@Test(priority=15)
			 void clickregister() {
				Homepf.clickRegister();
			}

//		 
//			 @AfterMethod
//			    void quitbrowser()
//			    {
//			    	Launchpf.quitdriver();
//			    }	 
//		 
}
