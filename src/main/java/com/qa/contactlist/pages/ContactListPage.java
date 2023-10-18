package com.qa.contactlist.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.contactlist.utils.ElementUtils;

public class ContactListPage {

	private WebDriver driver;
	private ElementUtils utils;
	
	private By firstname = By.id("firstName");
	private By lastname = By.id("lastName");
	private By dob = By.id("birthdate");
	private By emailId = By.id("email");
	private By phoneNum = By.id("phone");
	private By addr1 = By.id("street1");
	private By addr2 = By.id("street2");
	private By city = By.id("city");
	private By state = By.id("stateProvince");
	private By postalCode = By.id("postalCode");
	private By country = By.id("country");
	private By submitBtn = By.id("submit");
	private By deleteBtn = By.id("delete");
	private By editBtn = By.xpath("//button[text()='Edit Contact']");
	private By addAContactBtn = By.id("add-contact");
	private By returnToListBtn = By.id("return");
	
	public ContactListPage(WebDriver driver) {
		this.driver = driver;
		utils = new ElementUtils(driver);
	}
	
	private void fillContactDetails(AddContact addContact) {
		//utils.doSendKeys(firstname, addContact.getFirstname());
		utils.doSendKeysWithWait(firstname, addContact.getFirstname(), 3);
		utils.doSendKeysWithWait(lastname, addContact.getLastname(), 3);
		//utils.doSendKeys(lastname, addContact.getLastname());
		utils.doSendKeys(dob, addContact.getDob());
		utils.doSendKeys(emailId, addContact.getEmailId());
		utils.doSendKeys(phoneNum, addContact.getPhoneNum());
		utils.doSendKeys(addr1, addContact.getAddr1());
		utils.doSendKeys(addr2, addContact.getAddr2());
		utils.doSendKeys(city, addContact.getCity());
		utils.doSendKeys(state, addContact.getState());
		utils.doSendKeys(postalCode, addContact.getPostalCode());
		utils.doSendKeys(country, addContact.getCountry());
		utils.doClickWithWait(submitBtn, 3);
	}
	
	public void clickAddAContactBtn() {
		utils.doClickWithWait(addAContactBtn, 3);
	}
	
	public String addAContact(AddContact addContact) {
		clickAddAContactBtn();
		fillContactDetails(addContact);	
		String name = utils.waitForElementVisibility(By.xpath("//tr/td[contains(text(),'"+addContact.getFirstname()+"')]"),3).getText();
		System.out.println(name);
		return name;
	}
	
	public Map<String, String> getContact(String fname) {
		Map<String, String> contactMap = new HashMap<String, String>();	
		utils.waitForElementVisibility(By.xpath("//tr/td[contains(text(),'"+fname+"')]"),3).click();
		contactMap.put("FirstName", utils.waitForElementVisibility(firstname,3).getText());
		contactMap.put("LastName", utils.waitForElementVisibility(lastname,3).getText());
		
		System.out.println(contactMap);
		utils.doClickWithWait(returnToListBtn, 3);
		
		return contactMap;
	}
	
	public void updateContact(AddContact addContact, String fname) {
		utils.doClickWithWait(By.xpath("//tr/td[contains(text(),'"+fname+"')]"), 3);
		utils.doClickWithWait(editBtn, 3);
		fillContactDetails(addContact);
	}
	
	public boolean deleteContact(String fname) {
		utils.doClickWithWait(By.xpath("//tr/td[contains(text(),'"+fname+"')]"), 3);
		utils.doClickWithWait(deleteBtn, 3);
		utils.acceptAlert(3);
		try {
		utils.getElement(By.xpath("//tr/td[contains(text(),'"+fname+"')]")).isDisplayed(); 
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	

	
	
}
