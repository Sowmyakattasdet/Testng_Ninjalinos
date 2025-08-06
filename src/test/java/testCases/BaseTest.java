package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;

import driverFactory.DriverFactory_TestNG;
import io.qameta.allure.Attachment;
import pageFactory.BasePage;


public class BaseTest {
	

	
		
	@Parameters({"browser"})	
	@BeforeMethod
	public void open_website(String br) throws IOException {
		DriverFactory_TestNG df = new DriverFactory_TestNG();
		df.init_browser(br);
		BasePage base;
		base = new BasePage();
		base.launch_webpage();
		
	}
		
	
	@AfterMethod
	public void teardownDriver() {
		DriverFactory_TestNG.tear_driver();

	}
	
	@Attachment(value = "Screenshot", type = "image/jpg")
	public byte[] failed_screenshot(String testMethodName) throws IOException {
		
		byte[] screenshot_for_allureReport = ((TakesScreenshot)DriverFactory_TestNG.getDriver()).getScreenshotAs(OutputType.BYTES);
		File screenshot = ((TakesScreenshot)DriverFactory_TestNG.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("target/screenshots/"+"screenshot_"+testMethodName+".jpg"));
		ChainTestListener.embed(screenshot, "image/jpg");
		return screenshot_for_allureReport;
	}

}
