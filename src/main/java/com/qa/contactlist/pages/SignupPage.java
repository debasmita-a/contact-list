package com.qa.contactlist.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.contactlist.utils.ElementUtils;

public class SignupPage {

	private WebDriver driver;
	private ElementUtils util;
	
	private By signupBtn = By.id("signup");
	private By firstname = By.id("firstName");
	private By lastname = By.id("lastName");
	private By emailId = By.id("email");
	private By password = By.id("password");
	private By submitBtn = By.id("submit");
	
	public SignupPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtils(driver);
	}
	
	public void doSignup(String fname, String lname, String email, String pass) {
		util.doClick(signupBtn);
		util.doSendKeys(firstname, fname);
		util.doSendKeys(lastname, lname);
		util.doSendKeys(emailId, email);
		util.doSendKeys(password, pass);
		util.doClick(submitBtn);
	}
	
}
