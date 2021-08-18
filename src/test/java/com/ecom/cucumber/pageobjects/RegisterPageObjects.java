package com.ecom.cucumber.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPageObjects {

	private static RegisterPageObjects RegisterInstance;

	private RegisterPageObjects() {
	}

	public static RegisterPageObjects getInstance() {
		if (RegisterInstance == null) {
			RegisterInstance = new RegisterPageObjects();
		}
		return RegisterInstance;

	}

	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement MyAccount;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement Continue;

	@FindBy(id = "input-firstname")
	private WebElement FirstName;

	@FindBy(id = "input-lastname")
	private WebElement LastName;

	@FindBy(id = "input-email")
	private WebElement inputEmail;

	@FindBy(id = "input-telephone")
	private WebElement inputTelephone;

	@CacheLookup
	@FindBy(id = "input-password")
	private WebElement inputPassword;

	@CacheLookup
	@FindBy(id = "input-confirm")
	private WebElement inputconfirmPassword;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkBox;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;

	public WebElement getMyAccount() {
		return MyAccount;
	}

	public WebElement getContinue() {
		return Continue;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getInputEmail() {
		return inputEmail;
	}

	public WebElement getInputTelephone() {
		return inputTelephone;
	}

	public WebElement getInputPassword() {
		return inputPassword;
	}

	public WebElement getInputconfirmPassword() {
		return inputconfirmPassword;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	
	
}
