package com.LearnAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(xpath = "//span[text()='Dashboard']/..") WebElement dashboard;
	
	public void gotoDashboard() {
		dashboard.click();
	}
}
