package testMethodsPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import pageObjects.LinkedListPage;

public class LinkedListTest extends BaseTest {

    LinkedListPage linkedListPg;

    @BeforeMethod
    public void initPageObjects() {
        linkedListPg = new LinkedListPage();
        linkedListPg.getToLinkedList();
    }
    
    private void navigateToIntroTryEditor() {
        linkedListPg.clickOnIntroLink();
        linkedListPg.clickTryHere();
    }

    @Test(priority = 1)
    public void verifyIntroPageTitle() {
        System.out.println("Navigating to Linked List Intro Page...");
        linkedListPg.clickOnIntroLink();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Introduction";  // Update with correct expected title if different
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Intro Page Title did not match!");
    }

    @Test(priority = 2)
    public void verifyPracticeQuestionsPageTitle_Intro() {
        System.out.println("Navigating to Practice Questions Page from Intro...");
        linkedListPg.clickOnIntroLink();
        linkedListPg.clickOnPracticeQuestion();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Practice Questions";  
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Practice Questions Page Title did not match!");
    }
    @Test(priority = 3)
    public void verifytryEditorPageTitle_Intro() {
        System.out.println("Navigating to Try Editor Page from Intro...");
        linkedListPg.clickOnIntroLink();
        linkedListPg.clickTryHere();
        String actualTitle = linkedListPg.getTitle();
        String expectedTitle = "Assessment";  
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Try Editotr PageTitle did not match!");
    }
    
    @Test(priority = 4)
    public void verifytryEditorforValidCode_Intro() throws InterruptedException {
        System.out.println("Checking for Valid Code...");
        navigateToIntroTryEditor();
        linkedListPg.validCode();
        String ActualOuput=linkedListPg.checkOuputMsg();
        String expectedOutput = "hello"; 
        Assert.assertEquals(ActualOuput, expectedOutput, "Output didn't Match for Valid Code");
        
        
    }
    @Test(priority = 5)
    public void verifytryEditorforInvalidCode_Intro() throws InterruptedException {
        System.out.println("Checking for Valid Code...");
        navigateToIntroTryEditor();
        linkedListPg.invalidCode();
        String ActualOuput=linkedListPg.alert_message();
        String expectedOutput="NameError: name 'hello__world' is not defined on line 1";
        Assert.assertEquals(ActualOuput, expectedOutput, "Output didn't Match for Valid Code");
		linkedListPg.handleAlert();
        
        
    }
   
    
    
}

