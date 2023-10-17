package com.qa.contactlist.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.contactlist.utils.ElementUtils;

public class ContactListPage {

	private WebDriver driver;
	private ElementUtils utils;
	
	private By addAContactBtn = By.id("add-contact");
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
	private By firstNameCol = By.xpath("//tr/td[contains(text(),'Indira')]");
	private By contactDetailsText = By.xpath("//h1");
	private By contactListText = By.xpath("//h1");
	private By deleteBtn = By.id("delete");
	private By editBtn = By.id("edit-contact");
	
	public ContactListPage(WebDriver driver) {
		this.driver = driver;
		utils = new ElementUtils(driver);
	}
	
	public AddContact fillContactDetails(AddContact addContact) {
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
		return new AddContact();
	}
	public void clickAddAContactBtn() {
		utils.doClick(addAContactBtn);
	}
	
	public String addAContact(AddContact addContact) {
		clickAddAContactBtn();
		fillContactDetails(addContact);
		utils.doClick(submitBtn);
		return utils.doGetText(By.xpath("//tr/td[contains(text(),'"+addContact.getFirstname()+"')]"));
	}
	
	public String GetAContact(AddContact addContact) {
		clickAddAContactBtn();
		addAContact(addContact);
		utils.doClick(By.xpath("//tr/td[contains(text(),'"+addContact.getFirstname()+"')]"));
		return utils.doGetText(contactDetailsText);
	}
	
	public String deleteAContact(AddContact addContact) {
		clickAddAContactBtn();
		addAContact(addContact);
		GetAContact(addContact);
		utils.doClick(deleteBtn);
		utils.acceptAlert();
		return utils.doGetText(contactListText);		
	}
	
	public void updateAContact(AddContact addContact) {
		clickAddAContactBtn();
		addAContact(addContact);
		GetAContact(addContact);
		utils.doClick(editBtn);
	}
	
}
