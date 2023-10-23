package com.qa.contactlist.pages;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
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
	private By contactDetailsHeader = By.xpath("//h1");
	
	public ContactListPage(WebDriver driver) {
		this.driver = driver;
		utils = new ElementUtils(driver);
	}
	
	private void fillContactDetails(AddContact addContact) {
		utils.doSendKeys(firstname, addContact.getFirstname());
		utils.doSendKeys(lastname, addContact.getLastname());
		utils.doSendKeys(dob, addContact.getDob());
		utils.doSendKeys(emailId, addContact.getEmailId());
		utils.doSendKeys(phoneNum, addContact.getPhoneNum());
		utils.doSendKeys(addr1, addContact.getAddr1());
		utils.doSendKeys(addr2, addContact.getAddr2());
		utils.doSendKeys(city, addContact.getCity());
		utils.doSendKeys(state, addContact.getState());
		utils.doSendKeys(postalCode, addContact.getPostalCode());
		utils.doSendKeys(country, addContact.getCountry());
		utils.doClick(submitBtn);
	}
	
	public void clickAddAContactBtn() {
		utils.doClick(addAContactBtn);
	}
	
	public String addAContact(AddContact addContact) {
		clickAddAContactBtn();
		fillContactDetails(addContact);	
		String name = utils.doGetText(By.xpath("//tr/td[contains(text(),'"+addContact.getFirstname()+"')]"));
		System.out.println(name);
		return name;
	}
	
	public Map<String, String> getContact(String fname) throws InterruptedException {
		Map<String, String> contactMap = new HashMap<String, String>();	
		utils.doClick(By.xpath("//tr/td[contains(text(),'"+fname+"')]"));
		Thread.sleep(2000);
		contactMap.put("FirstName", utils.doGetText(firstname));
		contactMap.put("LastName", utils.doGetText(lastname));
		
		System.out.println(contactMap);
		utils.doClick(returnToListBtn);
		
		return contactMap;
	}
	
	public String updateContact(AddContact addContact, String fname) throws InterruptedException{
		utils.doClick(By.xpath("//tr/td[contains(text(),'"+fname+"')]"));
		utils.doClick(editBtn);
		fillContactDetails(addContact);
		Thread.sleep(2000);
		String header = utils.doGetText(contactDetailsHeader);
		System.out.println(header);
		utils.doClick(returnToListBtn); 
		return header;
		
	}
	
	public boolean deleteContact(String fname) throws InterruptedException {
		utils.doClick(By.xpath("//tr/td[contains(text(),'"+fname+"')]"));
		utils.doClick(deleteBtn);
		utils.acceptAlert(3);
		Thread.sleep(2000);
		try {
		utils.isElementDisplayed(By.xpath("//tr/td[contains(text(),'"+fname+"')]")); 
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	

	
	
}
