package com.qa.contactlist.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.contactlist.utils.ElementUtils;

public class LoginPage {

	private WebDriver driver;
	private ElementUtils utils;
	
	private By emailId = By.id("email");
	private By password = By.id("password");
	private By submitBtn = By.id("submit");
	private By contactListText = By.xpath("//h1");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		utils = new ElementUtils(driver);
	}
	
	public String doLogin(String email, String pass) {
		utils.doSendKeys(emailId, email);
		utils.doSendKeys(password, pass);
		utils.doClick(submitBtn);
		return utils.doGetText(contactListText);
	}
	
	

}
