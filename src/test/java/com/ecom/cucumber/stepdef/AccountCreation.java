package com.ecom.cucumber.stepdef;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.ecom.constants.Constants;
import com.ecom.cucumber.base.CommonFunctions;
import com.ecom.cucumber.pageobjects.RegisterPageObjects;
import com.ecom.webdrivermanager.DriverManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountCreation {
	
	private static final Logger LOGGER = LogManager.getLogger(AccountCreation.class);
	@Given("Launch the web application")
	public void launch_the_web_application() {
		LOGGER.info("Web application started");
		DriverManager.getDriver().get(Constants.APP_URL);
	}

	@When("Navigate to My Account and click Register")
	public void navigate_to_My_Account_and_click_Register() {
		LOGGER.info("Clicking Myaccount");

	    RegisterPageObjects.getInstance().getMyAccount().click();
	    RegisterPageObjects.getInstance().getContinue().click();
	}

	@When("Enter {string} {string} {string} {string} {string} {string} and click continue")
	public void enter_and_click_continue(String string, String string2, String string3, String string4, String string5, String string6) {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		LOGGER.info("Entering all the input values");

	    RegisterPageObjects.getInstance().getFirstName().sendKeys(string);
	    RegisterPageObjects.getInstance().getLastName().sendKeys(string2);
	    RegisterPageObjects.getInstance().getInputEmail().sendKeys(string3);
	    RegisterPageObjects.getInstance().getInputTelephone().sendKeys(string4);
	    RegisterPageObjects.getInstance().getInputPassword().clear();
	    RegisterPageObjects.getInstance().getInputPassword().sendKeys("1234");
	    RegisterPageObjects.getInstance().getInputconfirmPassword().clear();
	    RegisterPageObjects.getInstance().getInputconfirmPassword().sendKeys("1234");
	    RegisterPageObjects.getInstance().getCheckBox().click();
	    RegisterPageObjects.getInstance().getSubmitBtn().click();
	}

	@Then("User should successfully created a account")
	public void user_should_successfully_created_a_account() {
		String actualTitle = DriverManager.getDriver().getTitle();
		String expectedTitle = "Your Account Has Been Created!";
		LOGGER.info("Verifying expected and actual result");

		Assert.assertEquals(actualTitle, expectedTitle);
	    System.out.println("Successfully login created.");
		LOGGER.info("Test Passed");

	}

	
}
