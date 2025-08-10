package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import utils.ConfigReaderTest;
import utils.ExcelReaderTestNg;

public class BasePage {
	private WebDriver driver;
	private Actions action;
	ConfigReaderTest config;
	WebDriverWait wait;
	Alert alert;
	
	//constructor
	public BasePage() throws IOException {
		this.driver = DriverFactory.getdriver();//initialize the driver
		PageFactory.initElements(driver, this); //page factory initiate element
		this.action = new Actions(driver);
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//button[text()='Get Started']") WebElement getStarted;
	@FindBy(xpath ="//a[@href='/login' and text()='Sign in']") WebElement signIn;
	@FindBy(id="id_username") WebElement userName;
	@FindBy(id="id_password") WebElement passWord;
	@FindBy (xpath="//input[@type='submit' and @value='Login']") WebElement loginButton;
	@FindBy (xpath="//a[@href='graph' and text()='Get Started']") WebElement GraphPageButton;
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div[6]/div")
	WebElement textEditor;
	@FindBy(xpath = "//button[contains(text(),'Run')]")
	WebElement runBtn;
	@FindBy(id = "output")
	WebElement outputTxt;
	@FindBy(xpath = "//a[@href='/tryEditor' and contains(text(),'Try here')]")
	WebElement tryHereButton;
	
	
	//action methods
	
	public void loadurl() throws IOException {
		config = new ConfigReaderTest();
		Properties prop = config.readConfig();
		String url = prop.getProperty("testurl");
		driver.get(url);
	}
	
	public void clickGetStart() {
		action.moveToElement(getStarted).click().perform();
	}
	
	public void clickSignIn() {
		action.moveToElement(signIn).click().perform();
		
	}
	
	public void setUserName(String uname) throws InterruptedException {
		action.moveToElement(userName)
        .click()
        .sendKeys(userName, uname)
        .perform();
	}
	
	public void setPassword(String pword) throws InterruptedException {
		 action.moveToElement(passWord)
         .click()
         .sendKeys(passWord, pword)
         .perform();
	}
	
	
	public void clickLogin() throws InterruptedException {
		action.scrollToElement(loginButton).perform();
		action.click(loginButton).perform();
	}
	
	public String getTitle() {
		String titleName = driver.getTitle();
		return titleName;
		
	}

	
	public void clickTryHere() {
		action.moveToElement(tryHereButton).click().perform();
	}

	public void clickRun() {
		action.moveToElement(runBtn).click().perform();
	}
	
	public String checkOuputMsg() {
		wait.until(ExpectedConditions.visibilityOf(outputTxt));
		action.moveToElement(outputTxt).perform();
		String text = outputTxt.getText();
		return text;
	}
	
	public void validCode(String testData) throws InterruptedException, IOException {
		action.moveToElement(textEditor).sendKeys(textEditor, testData);
		action.moveToElement(runBtn).click().perform();
	}
	public void invalidCode(String testData) throws InterruptedException, IOException {
		action.moveToElement(textEditor).sendKeys(textEditor, testData);
		action.moveToElement(runBtn).click().perform();
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void handleAlert() throws InterruptedException {
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public String alert_message() {
		alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		return alertMsg;
	}
}
