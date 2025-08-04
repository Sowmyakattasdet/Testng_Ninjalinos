package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//import driverManager.Passing_Driver;

public class HomePage {

	WebDriver driver;
	JavascriptExecutor js;
	
	

	public HomePage(WebDriver driver )
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		js = (JavascriptExecutor) driver;
	}
	// Locators

	@FindBy(xpath = "//*[text()='Data Structures-Introduction']//../a")
	WebElement getstartedButton_dataStructures;

	@FindBy(xpath = "//*[text()='Array']//../a")
	WebElement getstartedButton_Array;

	@FindBy(xpath = "//*[text()='Get Started']")
	WebElement btn_getstarted;

	@FindBy(xpath = "//h5[text()='Linked List']//../a")
	WebElement getstartedButton_LinkedList;

	@FindBy(xpath = "//h5[text()='Stack']//../a")
	WebElement getstartedButton_Stack;

	@FindBy(xpath = "//h5[text()='Queue']//../a")
	WebElement getstartedButton_Queue;

	@FindBy(xpath = "//h5[text()='Tree']//../a")
	WebElement getstartedButton_Tree;

	@FindBy(xpath = "//h5[text()='Graph']//../a")
	WebElement getstartedButton_Graph;

	@FindBy(xpath = "//*[@data-toggle='dropdown']")
	WebElement dropdownbox;

	@FindBy(xpath = "//a[text()='Data Structures-Introduction']")
	WebElement dropdownDataStructuresIntroduction;

	@FindBy(xpath = "//a[text()='Arrays']")
	WebElement dropdownboxArrays;

	@FindBy(xpath = "//a[text()='Linked List']")
	WebElement dropdownboxLinkedList;

	@FindBy(xpath = "//a[text()='Stack']")
	WebElement dropdownboxStack;

	@FindBy(xpath = "//a[text()='Queue']")
	WebElement dropdownboxQueue;

	@FindBy(xpath = "//a[text()='Graph']")
	WebElement dropdownboxGraph;
	@FindBy(xpath = "//a[text()='Tree']")
	WebElement dropdownboxTree;

	@FindBy(xpath = "//a[text()=' Register ']")
	WebElement register;

	@FindBy(xpath = "//a[text()='NumpyNinja']")
	WebElement homepage;

	@FindBy(xpath = "//*[@class='alert alert-primary']")
	WebElement notloggedinmesg;

//	public HomePage(Passing_Driver passdr) {
//
//		this.driver = passdr.getDriver();
//		this.action = new Actions(driver);
//		PageFactory.initElements(driver, this);
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	}

	public void clickgetstartedDatastructures() {
		getstartedButton_dataStructures.click();
	}

	public void clickgetstartedArray() {
		getstartedButton_Array.click();

	}

	public void clickgetstartedLinkedList() {
		getstartedButton_LinkedList.click();
	}

	public void clickgetstartedStack() {
		js.executeScript("window.scrollBy(0,400)");
		getstartedButton_Stack.click();

	}

	public void clickgetstartedQueue() {
		
		js.executeScript("window.scrollBy(0,400)");
		getstartedButton_Queue.click();
	}
	public void clickgsQueue() 
	{

		 Actions actions = new Actions(driver);
	        actions.moveToElement(getstartedButton_Queue).click().perform();
	}

	public void clickgetstartedTree() {
		
		js.executeScript("window.scrollBy(0,400)");
		getstartedButton_Tree.click();
	}

	public void clickgetstartedGraph() {
		
		js.executeScript("window.scrollBy(0,400)");
		getstartedButton_Graph.click();
	}

	public void clickDropdownbox() {
		dropdownbox.click();
	}

	public void clickDropdownArrays() {
		dropdownboxArrays.click();
	}

	public void clickDropdownLinkedList() {
		dropdownboxLinkedList.click();
	}

	public void clickDropdownStack() {
		dropdownboxStack.click();
	}

	public void clickDropdownQueue() {

		dropdownboxQueue.click();
	}

	public void clickDropdownTree() {
		dropdownboxTree.click();
	}
	public void clickDropdownGraph() {
		dropdownboxGraph.click();
	}

	public void clickRegister() {
		register.click();
	}

	public String homepagetext() {
		String text = homepage.getText();
		return text;
	}

	public String notloggedinmesg() {
		
		String text1 = notloggedinmesg.getText();
		return text1;
	}
}