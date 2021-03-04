package com.LearnAutomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties properties;

	public ConfigDataProvider() {
		File file = new File("./Config/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load config file >> " + e.getMessage());
		}
	}
	
	public String getDataFromConfig(String key) {
		return properties.getProperty(key);
	}
	
	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public String getStagingURL() {
		return properties.getProperty("url");
	}
}
