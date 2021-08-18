package com.ecom.cucumber.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.ecom.cucumber.stepdef.StepDefenition;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources" }, dryRun = false, monochrome = true, glue = {
		"com.ecom.cucumber.stepdef" }, plugin = { "json:target/JVM.json" })

public class TestRunner {

	@AfterClass
	public static void report() {
		StepDefenition.JVMReports("target/JVM.json");
	}

}
