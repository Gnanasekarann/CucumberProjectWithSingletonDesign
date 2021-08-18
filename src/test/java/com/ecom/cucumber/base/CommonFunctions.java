package com.ecom.cucumber.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.ecom.constants.Constants;
import com.ecom.cucumber.pageobjects.RegisterPageObjects;
import com.ecom.webdrivermanager.DriverManager;

public class CommonFunctions {
	static FileReader reader;
	public void loadProperties() {
		
	
		Properties properties = new Properties();
		
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Constants.APP_URL = properties.getProperty("AppURL");
		Constants.browser = properties.getProperty("Browser");
		
	}
	
	public void initwebElements() {
		PageFactory.initElements(DriverManager.getDriver(), RegisterPageObjects.getInstance());
	}
	

}
