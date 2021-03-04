package com.LearnAutomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/Dashboard_" + getCurrentDateTime() + ".png";
		try {
			FileHandler.copy(file, new File(screenshotPath));
			System.out.println("Screenshot captured successfully");
		} catch (IOException e) {
			System.out.println("Unable to capture the screenshot >> " + e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat sformat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		return sformat.format(date);
	}

}
