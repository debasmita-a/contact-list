package com.qa.contactlist.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		getElement(locator).clear();
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
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
//************************************************* wait utils **********************************************//
	
	public WebElement waitForElementPresence(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForElementVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public Alert waitForAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(int timeout) {
		waitForAlert(timeout).accept();	
	}

	public void dismissAlert(int timeout) {
		waitForAlert(timeout).dismiss();
	}
	
	public String getAlertText(int timeout) {
		return waitForAlert(timeout).getText();
	}
	
	public void doSendKeysWithWait(By locator,String value, int timeout) {
		waitForElementPresence(locator, timeout).clear();
		waitForElementPresence(locator, timeout).sendKeys(value);
	}
	
	public void doClickWithWait(By locator,int timeout) {
		waitForElementPresence(locator, timeout).click();
	}
	
	public boolean getCurrentUrlWithWait(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.urlContains(getPageUrl()));
	}
	
	public boolean getTextVisibleWithWait(By locator, String text, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
}
