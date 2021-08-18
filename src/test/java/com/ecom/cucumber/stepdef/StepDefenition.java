package com.ecom.cucumber.stepdef;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ecom.constants.Constants;
import com.ecom.cucumber.base.CommonFunctions;
import com.ecom.webdrivermanager.DriverManager;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class StepDefenition {
	CommonFunctions functions;
	public static final Logger LOGGER = LogManager.getLogger(StepDefenition.class);

	@Before
	public void beforeScenario() {
		LOGGER.info("Execution Started");
		try {
			functions = new CommonFunctions();
			functions.loadProperties();
			LOGGER.info("Properties Loaded");

			if (DriverManager.getDriver() == null) {
				DriverManager.launchBrowser();
				functions.initwebElements();
				LOGGER.info("Browser launched");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
	DriverManager.getDriver().close();
		LOGGER.info("Browser Closed");

	}
	
	public static void JVMReports(String json) {
		File file = new File("D:\\Users\\gnanas\\eclipse-workspace\\com.ecom.cucumber\\target");
		Configuration configuration = new Configuration(file, "com.ecom.cucumber");
		configuration.addClassifications("Environment", "QA Environment");
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Platform", "Windows");
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add(json);
		
		ReportBuilder builder = new ReportBuilder(arrayList, configuration);
		builder.generateReports();
		

	}

}
