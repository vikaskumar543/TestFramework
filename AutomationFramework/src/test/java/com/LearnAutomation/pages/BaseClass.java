package com.LearnAutomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.LearnAutomation.utility.BrowserFactory;
import com.LearnAutomation.utility.ConfigDataProvider;
import com.LearnAutomation.utility.ExcelDataProvider;
import com.LearnAutomation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	protected WebDriver driver;
	protected ExcelDataProvider excel;
	protected ConfigDataProvider config;
	protected ExtentReports reports;
	protected ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Before Suite Start >> Loading all data provider", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		Reporter.log("Before Suite >> Data provider loaded", true);

		Reporter.log("Before Suite >> Setting extent report", true);
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "\\Reports\\TestReport_" + Helper.getCurrentDateTime() + ".html"));
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		Reporter.log("Before Suite end >> Extend report setup completed", true);
	}
	
	@Parameters({"browser", "URL"})
	@BeforeClass
	public void setup(String browser, String URL) {
		Reporter.log("Before Class Start >> Getting browsers and applicatin details", true);
		
//		Use this to take input from config file
//		driver = BrowserFactory.startApplictaion(driver, config.getBrowser(), config.getStagingURL());
		
//		Use this to take input as a system parameter from pom.xml
		driver = BrowserFactory.startApplictaion(driver, browser, URL);
		
		Reporter.log("Before Class end >> Browser launched and application up and running", true);
	}
	
	@AfterClass
	public void teardown() {
		Reporter.log("After Class start >> About to quit browser", true);
		driver.quit();
		Reporter.log("After Class end >> Browser quited", true);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		Reporter.log("After Method start >> Starting Extent test report preparation", true);
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		reports.flush();
		Reporter.log("After Method  end >> Extent report generated", true);
	}
}
