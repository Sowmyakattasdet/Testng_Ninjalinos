package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;

public class LinkedListPage extends BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	private JavascriptExecutor js;
	
	
	 @FindBy(xpath="//*[@href='introduction']")
	 WebElement introPageLink;
	 @FindBy(xpath="//*[contains(text(),'Practice Questions')]")
	 WebElement practicePageLink;
	 @FindBy(xpath="//*[@href='linked-list']")
	 WebElement linkedListButton;
	 @FindBy(xpath="//*[@href='/tryEditor']")
	 WebElement tryHereButton;
	 @FindBy(xpath="//*[@class='CodeMirror-scroll']")
	 WebElement tryEditor;
	 @FindBy(xpath="//*[contains(text(),'Run')]")
	 WebElement runButton;
	 @FindBy(xpath="//*[@id='output']")
	 WebElement output;
	 @FindBy(xpath="//*[@href='creating-linked-list']")
	 WebElement createLinkedListLink;
	 @FindBy(xpath="//*[@href='types-of-linked-list']")
	 WebElement typesofLinkedListLink;
	 @FindBy(xpath="//*[@href='implement-linked-list-in-python']")
	 WebElement implementLinkedListLink;
	 @FindBy(xpath="//*[@href='traversal']")
	 WebElement traversalLink;;
	 @FindBy(xpath="//*[@href='insertion-in-linked-list']")
	 WebElement insertionLink;
	 @FindBy(xpath="//*[@href='deletion-in-linked-list']")
	 WebElement deletionLink;
	
	 
	 public LinkedListPage() {
		    this.driver = DriverFactory.getdriver();
			PageFactory.initElements(driver, this);
			this.action = new Actions(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
	 }
	 
	 public void getToLinkedList(){
		 linkedListButton.click();     	
			
		}
	 public void clickOnIntroLink(){
		 introPageLink.click();     	
			
		}
	 
	 public void clickOnPracticeQuestion() {
		 practicePageLink.click();
	 }
	 
	 

}
