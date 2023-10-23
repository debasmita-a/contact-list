package com.qa.contactlist.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.contactlist.base.BaseTest;
import com.qa.contactlist.pages.AddContact;
import com.qa.contactlist.pages.ContactListPage;

public class ContactListPageTest extends BaseTest{

	@BeforeClass
	public void setupContactListPage() {
		contactlistPage = loginPage.doLogin(prop.getProperty("user_email"), prop.getProperty("user_pass"));
		//return contactlistPage;
	}
	
	@DataProvider
	public Object[][] addContactTestData(){
		return new Object[][] {
			{"Shashi","Tharoor", "", "", "", "", "", "", "", "", ""},
			{"Sanjeev","Sanyal", "", "", "", "", "", "", "", "", ""},
			{"Sai","Deepak", "", "", "", "", "", "", "", "", ""},
			{"Ramchandra","Guha", "", "", "", "", "", "", "", "", ""},
			{"Joshua","Foer", "", "", "", "", "", "", "", "", ""},			
		};
	}
	
	@Test(dataProvider="addContactTestData")
	public void addAContactTest(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8,
			String s9, String s10, String s11) {
		AddContact addContact = new AddContact(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11);
		String actualName = contactlistPage.addAContact(addContact);
		Assert.assertTrue(actualName.contains(addContact.getFirstname()));
	}
	
	@DataProvider
	public Object[][] getContactTestData(){
		return new Object[][] {
			{"Shashi02","Tharoor02", "", "", "", "", "", "", "", "", ""},
			{"Sanjeev02","Sanyal02", "", "", "", "", "", "", "", "", ""},
			{"Sai02","Deepak02", "", "", "", "", "", "", "", "", ""},
			{"Ramchandra02","Guha02", "", "", "", "", "", "", "", "", ""},
			{"Joshua02","Foer02", "", "", "", "", "", "", "", "", ""},			
		};
	}
	
	@Test(dataProvider="getContactTestData")
	public void getContactTest(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8,
			String s9, String s10, String s11) throws InterruptedException {
		AddContact addContact = new AddContact(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11);
		Map<String, String> actualMap = contactlistPage.getContact(contactlistPage.addAContact(addContact));
		Assert.assertEquals(actualMap.get("FirstName"), addContact.getFirstname());
	}
	
	@DataProvider
	public Object[][] deleteContactTestData(){
		return new Object[][] {
			{"Shashi01","Tharoor01", "", "", "", "", "", "", "", "", ""},
			{"Sanjeev01","Sanyal01", "", "", "", "", "", "", "", "", ""},
			{"Sai01","Deepak01", "", "", "", "", "", "", "", "", ""},
			{"Ramchandra01","Guha01", "", "", "", "", "", "", "", "", ""},
			{"Joshua01","Foer01", "", "", "", "", "", "", "", "", ""},			
		};
	}
	@Test(dataProvider="deleteContactTestData")
	public void deleteContactTest(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8,
			String s9, String s10, String s11) throws InterruptedException {
		AddContact addContact = new AddContact(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11);
		boolean flag = contactlistPage.deleteContact(contactlistPage.addAContact(addContact));
		Assert.assertFalse(flag);
	}
	
	@DataProvider
	public Object[][] updateContactTestData(){
		return new Object[][] {
			{"Shashi03","Tharoor03", "", "", "", "", "", "", "", "", "","New Delhi"},
			{"Sanjeev03","Sanyal03", "", "", "", "", "", "", "", "", "","BBSR"},
			{"Sai03","Deepak03", "", "", "", "", "", "", "", "", "","New York"},
			{"Ramchandra03","Guha03", "", "", "", "", "", "", "", "", "","Texas"},
			{"Joshua03","Foer03", "", "", "", "", "", "", "", "", "","London"},				
		};
	}
	
	@Test(dataProvider="updateContactTestData")
	public void updateContactTest(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8,
			String s9, String s10, String s11, String cityUpdate) throws InterruptedException{
		AddContact addContact = new AddContact(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11);
		contactlistPage.addAContact(addContact);
		addContact.setCity(cityUpdate);
		String header = contactlistPage.updateContact(addContact, addContact.getFirstname());
		Assert.assertTrue(header.equals("Contact Details"));
	}
}
