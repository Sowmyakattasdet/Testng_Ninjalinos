package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home1pf {

WebDriver driver;

private Actions action;
	
	//constructor
	 public Home1pf(WebDriver driver)
	{
		this.driver=driver;
		this.action = new Actions(driver);
		PageFactory.initElements(driver,this);
	}
	
	//Locators
	
@FindBy(xpath="//*[text()='Data Structures-Introduction']//../a")
WebElement getstartedButton_dataStructures;

@FindBy(xpath="//*[text()='Array']//../a")
WebElement getstartedButton_Array;

@FindBy(xpath="//*[text()='Get Started']")
WebElement btn_getstarted;

@FindBy(xpath="//h5[text()='Linked List']//../a")
WebElement getstartedButton_LinkedList;

@FindBy(xpath="//h5[text()='Stack']//../a")
WebElement getstartedButton_Stack;

@FindBy(xpath="//h5[text()='Queue']//../a")
WebElement getstartedButton_Queue;

@FindBy(xpath="//h5[text()='Tree']//../a")
WebElement getstartedButton_Tree;

@FindBy(xpath="//h5[text()='Graph']//../a")
WebElement getstartedButton_Graph;

@FindBy(xpath="//*[@data-toggle='dropdown']")
WebElement Dropdownbox;

@FindBy(xpath="//a[text()='Data Structures-Introduction']")
WebElement DropdownDataStructuresIntroduction;

@FindBy(xpath="//a[text()='Arrays']")
WebElement DropdownboxArrays;

@FindBy(xpath="//a[text()='Linked List']")
WebElement DropdownboxLinkedList;

@FindBy(xpath="//a[text()='Stack']")
WebElement DropdownboxStack;

@FindBy(xpath="//a[text()='Queue']")
WebElement DropdownboxQueue;

@FindBy(xpath="//a[text()='Tree']")
WebElement DropdownboxTree;

@FindBy(xpath="//a[text()=' Register ']")
WebElement Register;

@FindBy(xpath="//a[text()='NumpyNinja']")
WebElement Homepage;

@FindBy(xpath="//*[@class='alert alert-primary']")
WebElement notloggedinmesg;
//a[text()='NumpyNinja']
//action methods

public void clickgetstartedDatastructures()
{
	getstartedButton_dataStructures.click();
}
public void clickgetstartedArray()
{
	getstartedButton_Array.click();
	
}

public void clickgetstartedLinkedList()
{
	getstartedButton_LinkedList.click();
}
public void clickgetstartedStack() 
{
	JavascriptExecutor	jse=(JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,400)");
	getstartedButton_Stack.click();
	
}
public void clickgetstartedQueue()
{
	JavascriptExecutor	jse=(JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,400)");
	getstartedButton_Queue.click();
}
public void clickgetstartedTree()
{
	JavascriptExecutor	jse=(JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,400)");
	getstartedButton_Tree.click();
}
public void clickgetstartedGraph()
{
	JavascriptExecutor	jse=(JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,400)");
	getstartedButton_Graph.click();
}
public void clickDropdownbox()
{
	Dropdownbox.click();
}
public void clickDropdownArrays()
{
	DropdownboxArrays.click();
}
public void clickDropdownLinkedList()
{
	DropdownboxLinkedList.click();
}
public void clickDropdownStack()
{
	DropdownboxStack.click();
}
public void clickDropdownQueue()
{
	
	DropdownboxQueue.click();
}
public void clickDropdownTree()
{
	DropdownboxTree.click();
}
public void clickRegister()
{
	Register.click();
}
public String Homepagetext()
{
	String text=Homepage.getText();
	return text;
}
public String notloggedinmesg()
{
	String text1=notloggedinmesg.getText();
	return text1;
}
}
