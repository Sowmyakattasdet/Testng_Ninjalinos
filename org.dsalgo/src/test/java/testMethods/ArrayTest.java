package testMethods;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

import pageObjects.Array_pf;
import pageObjects.Base_pf;
import utils.LoggerLoad;
import driverManager.DriverFactory;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

@Listeners(CustomListener.class)
public class ArrayTest extends BaseTest {
	
	Array_pf array_pf;
	Base_pf base_pf;
	LoggerLoad log;
	
	//WebDriver driver;
	
	@BeforeMethod
	public void array_page() throws IOException {
		base_pf = new Base_pf();
		array_pf = new Array_pf();
		this.log = new LoggerLoad();
		array_pf.clickArrayGetStarted();

	}

	
//	@Test
//	public void testEnterArray() {
//	   // array_pf.clickArrayGetStarted();
//	}

	
	@Test
	public void testArraysInPythonLink() throws InterruptedException, IOException {
//		Array_pf array_pf = new Array_pf(DriverFactory.getDriver());
//		array_pf.background_array();
		//array_pf.clickArrayGetStarted();
		array_pf.clickArraysInPython();
		array_pf.waitForUrlToContain("/arrays-in-python/");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/array/arrays-in-python/",currentUrl);
	}
	
	@Test
	public void testArraysUsingListLink() throws IOException {
//		Array_pf array_pf = new Array_pf(DriverFactory.getDriver());
//	    array_pf.background_array()	    
		//array_pf.clickArrayGetStarted();
		array_pf.clickArraysUsingList();
		array_pf.waitForUrlToContain("/arrays-using-list/");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/array/arrays-using-list/",currentUrl);
	}
	
	@Test
	public void testBasicOperationsLink() throws IOException {
//		Array_pf array_pf = new Array_pf(DriverFactory.getDriver());
//	    array_pf.background_array();
	    //array_pf.clickArrayGetStarted();
	    array_pf.clickBasicOperations();
	    array_pf.waitForUrlToContain("/basic-operations-in-lists/");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/array/basic-operations-in-lists/",currentUrl);
		
	}
	
	@Test
	public void testApplicationsOfArray() throws IOException {
//		Array_pf array_pf = new Array_pf(DriverFactory.getDriver());
//	    array_pf.background_array();
	    //array_pf.clickArrayGetStarted();
	    array_pf.clickApplicationsOfArray();
	    array_pf.waitForUrlToContain("/applications-of-array/");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/array/applications-of-array/",currentUrl);
	  
	}
	
	@Test
	public void testClickTryHereFromPythonLink() throws IOException {
//		Array_pf array_pf = new Array_pf(DriverFactory.getDriver());
//		array_pf.background_array();
		//array_pf.clickArrayGetStarted();
		array_pf.clickArraysInPython();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		//log.info("Message1");
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor",currentUrl);
		
	}
	
	@Test
	public void testClickTryHereFromListLink() {
		array_pf.clickArraysUsingList();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor",currentUrl);
	}
	
	@Test
	public void testClickTryHereFromOperationsLink() {
		array_pf.clickBasicOperations();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor",currentUrl);
		
		
	}
	
	@Test
	public void testClickTryHereFromApplicationsLink() {
		array_pf.clickApplicationsOfArray();
		array_pf.clickTryHere();
		array_pf.waitForUrlToContain("/tryEditor");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/tryEditor",currentUrl);
		
	}
	
	@Test
	public void testTryEditorPageWithNoInput() {
		array_pf.clickArraysInPython();
		array_pf.clickTryHere();
		base_pf.clickRun();
		base_pf.getErrMsg_NoCode();
		log.error(
				"There is no alert message displayed when we click on run button without entering any code in the code editor in array module");
		String errorMsg = base_pf.alert_message();
		assertEquals("Enter code", errorMsg);
		
	}
	
	@Test
	public void testTryEditorPageWithInvalidInput() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickTryHere();
		base_pf.tryEditor_invalidCode();
	    base_pf.clickRun();
	    base_pf.handle_alert();
	   
	}
	
	@Test
	public void testTryEditorWithValidInput() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickTryHere();
		base_pf.tryEditor_validCode();
		base_pf.clickRun();
		String outputTxt = base_pf.output_text();
		
		assertEquals("Hello World", outputTxt);
		
	}
	
	@Test
	public void testPracticeQuestionlink() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.waitForUrlToContain("/practice");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/array/practice",currentUrl);
		
	}
	
	@Test
	public void testPracticeQ1() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.waitForUrlToContain("question/1");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/question/1",currentUrl);
		
	}
	
	@Test
	public void testPracticeQ2() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.waitForUrlToContain("question/2");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/question/2",currentUrl);
		
	}
	
	@Test
	public void testPracticeQ3() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.waitForUrlToContain("question/3");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/question/3",currentUrl);
		
	}
	
	@Test
	public void testPracticeQ4() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.waitForUrlToContain("question/4");
		String currentUrl = array_pf.getURL();
		assertEquals("https://dsportalapp.herokuapp.com/question/4",currentUrl);
		
	}
	
	@Test
	public void testQ1NoCode_Run() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		base_pf.clickRun();
		base_pf.handle_alert();
		
	}
	
	@Test
	public void testQ1NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.clickSubmit();
        String outputTxt = base_pf.output_text();
	    assertEquals("Error occurred during submission", outputTxt);
		
	}
	
	@Test
	public void testQ2NoCode_Run() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		base_pf.clickRun();
		base_pf.handle_alert();
		
	}
	
	@Test
	public void testQ2NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickMaxConsecutiveOnes();
		array_pf.clickSubmit();
        String outputTxt = base_pf.output_text();
	    assertEquals("Error occurred during submission", outputTxt);
		
	}
	
	@Test
	public void testQ3NoCode_Run() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		base_pf.clickRun();
		base_pf.handle_alert();
		
	}
	
	@Test
	public void testQ3NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickEvenNumberDigits();
		array_pf.clickSubmit();
        String outputTxt = base_pf.output_text();
	    assertEquals("Error occurred during submission", outputTxt);
		
	}
	
	@Test
	public void testQ4NoCode_Run() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		base_pf.clickRun();
		base_pf.handle_alert();
		
	}
	
	@Test
	public void testQ4NoCode_Submit() {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSquaresOfSortedArray();
		array_pf.clickSubmit();
        String outputTxt = base_pf.output_text();
	    assertEquals(" No tests were collected", outputTxt);
		
	}
	
	//HAVE TO WRITE CODE FOR VALID AND INVALID DATA IN ALL THE 4 QUESTIONS USING EXCEL
	
	@Test
	public void testQ1InvalidCode_Run() throws IOException, InterruptedException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.tryEditor_invalidCode_practiceQ();	
		//Thread.sleep(5000);
	    base_pf.clickRun();
	    base_pf.handle_alert();
		
	}
	
	@Test
	public void testQ1ValidCode_Run() throws IOException {
		array_pf.clickArraysInPython();
		array_pf.clickPracticeQuestionsLink();
		array_pf.clickSearchTheArray();
		array_pf.tryEditor_validCode_practiceQ1();
		base_pf.clickRun();
	    String outputQ1= base_pf.output_text(); 
	    System.out.println(outputQ1);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
   