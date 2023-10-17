package com.qa.contactlist.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {

	private WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String keys) {
		getElement(locator).sendKeys(keys);
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();	
	}
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();	
	}
}
