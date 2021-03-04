package com.LearnAutomation.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.PageFactory;
import com.LearnAutomation.pages.BaseClass;
import com.LearnAutomation.pages.LoginPage;

public class LoginTestCRM extends BaseClass {
	
	@Test
	public void loginApp() {
		logger = reports.createTest("Go to Dashboard");
		
		System.out.println(driver.getTitle());
		logger.info(driver.getTitle());
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.gotoDashboard();
		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equals("Land Record,Bihar")) 
			logger.pass("Moved to dashboard successfully");
		else 
			logger.fail("Go to dashboard step failed");
		
		SoftAssert sassert = new SoftAssert();
		sassert.assertTrue(driver.getTitle().equals("Land Record,Bihar"));
		
		System.out.println(excel.getStringValue("test", 0, 0));
		System.out.println(excel.getNumericValue(0, 0, 1));
		
		System.out.println(config.getDataFromConfig("test"));
	}

	@Test
	public void loginApp1() {
		logger = reports.createTest("Go to Dashboard1");
		
		System.out.println(driver.getTitle());
		logger.info(driver.getTitle());
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.gotoDashboard();
		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equals("Land Record,Bihar1")) 
			logger.pass("Moved to dashboard successfully");
		else 
			logger.fail("Go to dashboard step failed");
		
		SoftAssert sassert = new SoftAssert();
		sassert.assertTrue(driver.getTitle().equals("Land Record,Bihar"));
		
		System.out.println(excel.getStringValue("test", 0, 0));
		System.out.println(excel.getNumericValue(0, 0, 1));
		
		System.out.println(config.getDataFromConfig("test"));
	}
}
